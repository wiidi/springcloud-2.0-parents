package com.wudi.springcloudorderimpl.fallback;

import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import com.wudi.springcloudapimember.entity.UserEntity;
import com.wudi.springcloudorderimpl.feign.MemberServiceFeign;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/30 10:31
 * @UpdateUser:
 * @UpdateDate: 2018/11/30 10:31
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@Component
public class MemberServiceFallback extends BaseApiService implements MemberServiceFeign {
    @Override
    public UserEntity getMember(String name) {
        return null;
    }

    @Override
    public ResponseBase getUserInfo() {
        return setResultError("服务器忙，请稍后重试！以类的方式写服务降级。");
    }
}
