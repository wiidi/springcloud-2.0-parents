package com.wudi.springcloudzuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

@SpringBootApplication
@EnableEurekaClient
//开启网关代理
@EnableZuulProxy
public class SpringcloudZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudZuulGatewayApplication.class, args);
	}

    // zuul配置能够使用config实现实时更新
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }

}
