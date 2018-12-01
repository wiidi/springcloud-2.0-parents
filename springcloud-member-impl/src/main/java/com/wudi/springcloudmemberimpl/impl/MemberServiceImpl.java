package com.wudi.springcloudmemberimpl.impl;

import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import com.wudi.springcloudapimember.entity.UserEntity;
import com.wudi.springcloudapimember.service.IMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/28 19:44
 * @UpdateUser:
 * @UpdateDate: 2018/11/28 19:44
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@Api("会员服务")
@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService{

    @RequestMapping("/")
    public String index() {
        return "我是member项目默认方法！";
    }

    @ApiOperation("获取会员相关信息")
    @ApiImplicitParam(name = "userName", value = "用户信息参数", required = true, dataType = "String")
    @PostMapping("/getMember-swagger")
    public String getMemberSwagger(String userName) {
        System.out.println("userName" + userName);
        return "userName" + userName;
    }

    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name){
        UserEntity userEntity=new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(20);
        System.out.println(userEntity.toString());
        return userEntity;
    }

    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo(){
        try {
            //会员服务睡眠1.5秒
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setResultSuccess("订单服务调用会员服务成功！！！");
    }

}
