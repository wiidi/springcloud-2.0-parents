package com.wudi.springcloudorderimpl.impl;

import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wudi.springcloudapimember.entity.UserEntity;
import com.wudi.springcloudapiorder.service.IOrderService;
import com.wudi.springcloudorderimpl.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/28 20:17
 * @UpdateUser:
 * @UpdateDate: 2018/11/28 20:17
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService {
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @RequestMapping("/orderToMember")
    //不加@RequestParam，name取不到值
    public String orderToMember(@RequestParam("name") String name) {
        UserEntity userEntity = memberServiceFeign.getMember(name);
        return userEntity == null ? "没有找到用户信息" : userEntity.toString();
    }

    /**
     * 添加了@Hystrix注解，该方法访问不成功
     */
    //测试feign客户端超时
    //没有解决雪崩效应
    @RequestMapping("/orderToMemberGetUserInfo")
    public ResponseBase orderToMemberGetUserInfo() {

        return memberServiceFeign.getUserInfo();
    }

    //使用Hystrix 解决雪崩效应
    //@HystrixCommand默认开启线程池隔离，服务降级，开启服务熔断机制
    @HystrixCommand(fallbackMethod = "orderToMemberGetUserInfoHystrixFallback")
    @RequestMapping("/orderToMemberGetUserInfoHystrix")
    public ResponseBase orderToMemberGetUserInfoHystrix() {
        System.out.println("orderToMemberGetUserInfoHystrix 线程池名称："+Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }

    //以类的方式进行 服务降级
    @RequestMapping("/orderToMemberGetUserInfoHystrixDemo2")
    public ResponseBase orderToMemberGetUserInfoHystrixDemo2() {
        System.out.println("orderToMemberGetUserInfoHystrix 线程池名称："+Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }


    public ResponseBase orderToMemberGetUserInfoHystrixFallback() {
        return setResultSuccess("返回一个友好的提示：服务降级。亲，服务忙，请稍后再试！！！");
    }

    //订单服务接口
    @RequestMapping("/orderInfo")
    public ResponseBase orderInfo(){
        System.out.println("orderInfo 线程池名称："+Thread.currentThread().getName());
        return setResultSuccess();
    }
}
