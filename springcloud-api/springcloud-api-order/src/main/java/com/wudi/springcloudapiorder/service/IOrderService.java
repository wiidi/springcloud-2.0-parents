package com.wudi.springcloudapiorder.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/28 20:15
 * @UpdateUser:
 * @UpdateDate: 2018/11/28 20:15
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
public interface IOrderService {
    //订单服务调用会员服务接口信息 feign
    @RequestMapping("/orderToMember")
    public String orderToMember(String name);
}
