/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stone.springcloudnative.framework.sample.common;

import com.stone.springcloudnative.framework.sample.common.log.LoggerAspect;
import com.stone.springcloudnative.framework.sample.common.mesh.FeginInterceptor;
import com.stone.springcloudnative.framework.sample.common.mesh.HystrixRequestAttributeAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * desc: Bootstrap config for native.
 *
 * @author 王彦锋
 * @date 4/23/20 10:10 AM
 */
@Configuration(proxyBeanMethods = false)
@Import({LoggerAspect.class, FeginInterceptor.class, HystrixRequestAttributeAutoConfiguration.class})
public class FrameworkCommonBootstrapConfiguration {
}
