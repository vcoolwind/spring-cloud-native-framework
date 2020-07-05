package com.stone.springcloudnative.framework.sample.reviews.reviews;

import com.alibaba.fastjson.JSONObject;
import com.stone.springcloudnative.framework.sample.common.util.MiscUtils;
import com.stone.springcloudnative.framework.sample.reviews.configreload.ConfigReloadClient;
import com.stone.springcloudnative.framework.sample.reviews.ratings.Rating;
import com.stone.springcloudnative.framework.sample.reviews.ratings.RatingsClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.RunnableWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RefreshScope
public class ReviewsController {

    @Value("${ratings.enabled}")
    private Boolean ratingsEnabled;

    @Value("${configReload.enabled}")
    private Boolean configReloadEnabled;

    private ReviewsRepository reviewRepository;

    private RatingsClient ratingsClient;

    @Autowired
    private ConfigReloadClient configReloadClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ReviewService reviewService;


    public ReviewsController(ReviewsRepository reviewRepository, RatingsClient ratingsClient) {
        log.info("ReviewsController init ,ReviewsRepository = {}, RatingsClient= {}", reviewRepository, ratingsClient);
        this.reviewRepository = reviewRepository;
        this.ratingsClient = ratingsClient;
    }

    @GetMapping(value = "/")
    public String root() {
        return "hello reviews";
    }

    @GetMapping(value = "/reviews/{productId}")
    public ReviewDto getReviewsByProductId(@PathVariable UUID productId, HttpServletRequest request) {
        log.info("getReviewsByProductId by productId:{}", productId);
        //MiscUtils.showHeaders(request);
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setProductId(productId);
        List<Review> reviews = reviewRepository.findByProductId(productId);
        reviewDto.setReviews(reviews);
        MiscUtils.sleep(MiscUtils.random(500));
        Review lastReview = null;
        for (Review review : reviews) {
            if (this.ratingsEnabled) {
                Rating rating = ratingsClient.getRating(productId, review.getReviewer());
                review.setRating(rating);
                lastReview = review;
            } else {
                log.info("ratings is not enabled");
            }
        }
        asyncDoSth(productId, lastReview.getReviewer());
        MiscUtils.sleep(MiscUtils.random(500));

        if (this.configReloadEnabled) {
            reviewDto.setRemoteConfig(configReloadClient.getRemoteConfig());
        } else {
            log.info("configReload is not enabled");
        }

        return reviewDto;
    }

    private void asyncDoSth(UUID productId, String reviewer) {
        new Thread(
                RunnableWrapper.of(() -> {
                    log.info("asyncDoSth start");
                    syncDoSth(productId, reviewer);
                    log.info("asyncDoSth end");
                })
        ).start();
    }

    private void syncDoSth(UUID productId, String reviewer) {
        log.info("syncDoSth do sth start .");
        MiscUtils.sleep(MiscUtils.random(500));
        Rating rating = ratingsClient.getRating(productId, reviewer);
        log.info("syncDoSth -- rating:{}", rating);
        log.info("syncDoSth do sth end .");
    }


    @GetMapping(value = "/trace")
    public String trace() {
        return reviewService.doAction1("haha!");
    }


    @GetMapping(value = "/values")
    public String values() {
        JSONObject ret = new JSONObject();
        ret.put("useLocalCache", useLocalCache);
        ret.put("logLevel", logLevel);
        ret.put("configReloadEnabled", configReloadEnabled);
        ret.put("ratingsEnabled", ratingsEnabled);


        return ret.toJSONString();
    }

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${logLevel:debug}")
    private String logLevel;


    // curl -d '{"reviewerId":"9bc908be-0717-4eab-bb51-ea14f669ef20","productId":"a071c269-369c-4f79-be03-6a41f27d6b5f","review":"This was OK.","rating":3}' -H "Content-Type: application/json" -X POST http://localhost:8102/reviews
//    @PostMapping(value = "/reviews")
//    public ReviewDto createReview(@RequestBody ReviewDto reviewDto) {
//        if (this.ratingsEnabled) {
//            Rating rating = new Rating(null, reviewDto.getReviewerId(), reviewDto.getProductId(), reviewDto.getRating());
//            ResponseEntity<Rating> ratingResponse = ratingsClient.createRating(rating);
//
//            // No way to propagate exception from the fallback, so we need to create it again
//            if (ratingResponse.getStatusCode() != HttpStatus.OK) {
//                throw new RatingsUnavailableException();
//            }
//        }
//
//        Review review = new Review(null, reviewDto.getReviewerId(), reviewDto.getProductId(), reviewDto.getReview());
//        review = reviewRepository.save(review);
//
//        reviewDto.setId(review.getId());
//        return reviewDto;
//    }
}