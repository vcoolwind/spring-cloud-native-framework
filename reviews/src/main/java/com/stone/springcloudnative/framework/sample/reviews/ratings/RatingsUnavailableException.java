package com.stone.springcloudnative.framework.sample.reviews.ratings;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class RatingsUnavailableException extends RuntimeException {
}
