package com.wudi.springcloudorderimpl.feign;

import com.wudi.springcloudapimember.service.IMemberService;
import com.wudi.springcloudorderimpl.fallback.MemberServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;

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
@FeignClient(value = "app-springcloud-member",fallback = MemberServiceFallback.class)
public interface MemberServiceFeign extends IMemberService{

}
