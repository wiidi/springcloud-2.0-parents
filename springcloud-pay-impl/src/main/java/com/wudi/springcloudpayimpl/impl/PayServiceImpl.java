package com.wudi.springcloudpayimpl.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/12/1 15:37
 * @UpdateUser:
 * @UpdateDate: 2018/12/1 15:37
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@RestController
public class PayServiceImpl {
    @RequestMapping("/")
    public String index() {
        return "这是pay的默认方法！";
    }
}
