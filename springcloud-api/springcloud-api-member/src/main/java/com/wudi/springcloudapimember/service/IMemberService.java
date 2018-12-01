package com.wudi.springcloudapimember.service;

import com.itmayiedu.base.ResponseBase;
import com.wudi.springcloudapimember.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/28 19:28
 * @UpdateUser:
 * @UpdateDate: 2018/11/28 19:28
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
public interface IMemberService {

    @RequestMapping("/getMember")
    //不加@RequestParam，name取不到值
    public UserEntity getMember(@RequestParam("name") String name);


    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo();

}
