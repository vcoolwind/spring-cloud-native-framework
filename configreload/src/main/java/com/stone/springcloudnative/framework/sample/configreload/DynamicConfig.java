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

package com.stone.springcloudnative.framework.sample.configreload;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * use config info from configmap,this info can be changed runtime.
 * 1.create k8s configmap [dynamic-configmap.yml]
 * 2.set load cm on bootstap  [bootstrap.yaml]
 * 3.change configmap on runtime, config will be updated and show config [ReloadConfigStatus.java]
 */
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "dynamic")
public class DynamicConfig {
	private int requestThreshold = 80;

	private String alertLevel = "error";

	public int getRequestThreshold() {
		return requestThreshold;
	}

	public void setRequestThreshold(int requestThreshold) {
		this.requestThreshold = requestThreshold;
	}

	public String getAlertLevel() {
		return alertLevel;
	}

	public void setAlertLevel(String alertLevel) {
		this.alertLevel = alertLevel;
	}

	@Override
	public String toString() {
		return "DynamicConfig{" +
				"requestThreshold=" + requestThreshold +
				", alertLevel='" + alertLevel + '\'' +
				'}';
	}
}
