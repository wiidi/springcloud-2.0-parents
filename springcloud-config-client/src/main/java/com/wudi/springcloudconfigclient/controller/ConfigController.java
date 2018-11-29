package com.wudi.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/29 18:51
 * @UpdateUser:
 * @UpdateDate: 2018/11/29 18:51
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@RestController
public class ConfigController {
    @Value("${wudiInfo}")
    private String wudiInfo;

    @RequestMapping("/wudiInfo")
    public String getWudiInfo() {
        return wudiInfo;
    }
}
