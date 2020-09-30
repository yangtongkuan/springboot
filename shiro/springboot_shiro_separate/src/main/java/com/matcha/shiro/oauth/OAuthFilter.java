package com.matcha.shiro.oauth;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class OAuthFilter extends AuthenticatingFilter {

    private static final String REQ_TOKEN = "token";

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = getRequestToken((HttpServletRequest) servletRequest);
        if (StringUtils.isBlank(token)) {
            return new OAuthToken(0L, token);
        }
        return null;
    }

    /**
     * 是否允许直接访问
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }
        String url = ((HttpServletRequest) request).getRequestURI();
        if (url.contains("/public/")) {
            return true;
        }
        return false;
//        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = getRequestToken((HttpServletRequest) servletRequest);
        if (token == null) {
            /**
             * 直接抛出异常 全局异常进行处理
             */
        }
        return executeLogin(servletRequest, servletResponse);
    }

    // get the request token
    private String getRequestToken(HttpServletRequest httpRequest) {
        //从header中获取tTenant
        String token = httpRequest.getHeader(REQ_TOKEN);
        //如果header中不存在Tenant，则从参数中获取Tenant
        if (StringUtils.isBlank(token)) {
            token = httpRequest.getParameter(REQ_TOKEN);
        }
        return token;
    }

}
