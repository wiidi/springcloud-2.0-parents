package com.wudi.springcloudorderimpl;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@EnableSwagger2Doc  //生成文档
public class SpringcloudOrderImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudOrderImplApplication.class, args);
	}
}
