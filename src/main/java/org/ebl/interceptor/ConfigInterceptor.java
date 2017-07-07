package org.ebl.interceptor;

import org.ebl.domain.WebConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yeli on 07/07/2017.
 */
public class ConfigInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!request.getRequestURI().contains("."))request.setAttribute("webConfig",new WebConfig());
        return super.preHandle(request, response, handler);
    }

}
