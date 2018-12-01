package com.wudi.springcloudzuulgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/12/1 12:02
 * @UpdateUser:
 * @UpdateDate: 2018/12/1 12:02
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@Component
public class TokenFilter  extends ZuulFilter{
    @Override
    //过滤器类型  pre表示在请求之前执行
    public String filterType() {
        return "pre";
    }

    @Override
//    过滤器执行顺序，当一个请求在同一个阶段时，存在多个过滤器时，过个过滤器执行顺序问题
    public int filterOrder() {
        return 0;
    }

    @Override
//    判断过滤器是否生效
    public boolean shouldFilter() {
        return true;
    }

    @Override
    //编写业务逻辑代码
    public Object run() throws ZuulException {
        //拦截所有的服务接口，判断服务接口上是否有传递userToken参数
        //获取上下文
        RequestContext currentContext= RequestContext.getCurrentContext();
        //获取Request
        HttpServletRequest request = currentContext.getRequest();
        //获取Token 时 从请求头中获取
        String userToken=request.getParameter("userToken");
        //StringUtils，是 null 安全的(即如果输入参数 String 为 null 则不会抛出 NullPointerException）
        // 如果使用userToken.isEmpty会报错
        if (StringUtils.isEmpty(userToken)){
            //不会继续执行，不会调用服务接口，网关服务直接相应给客户端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("token is null!");
            currentContext.setResponseStatusCode(401);
            //返回错误提示
        }
        //正常调用服务接口
        return null;
    }
}
