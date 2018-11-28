package com.wudi.springcloudorderimpl.impl;

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
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @RequestMapping("/orderToMember")
    public String orderToMember(@RequestParam("name") String name) {
        UserEntity userEntity = memberServiceFeign.getMember(name);
        return userEntity == null ? "没有找到用户信息" : userEntity.toString();
    }

}
