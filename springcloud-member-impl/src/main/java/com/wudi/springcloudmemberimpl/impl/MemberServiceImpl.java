package com.wudi.springcloudmemberimpl.impl;

import com.wudi.springcloudapimember.entity.UserEntity;
import com.wudi.springcloudapimember.service.IMemberService;
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
@RestController
public class MemberServiceImpl implements IMemberService{
    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name){
        UserEntity userEntity=new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(20);
        System.out.println(userEntity.toString());
        return userEntity;
    }
}
