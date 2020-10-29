package com.xignitex.zuulxignitex.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String apiKey = request.getHeader("API-KEY");

        System.out.println("Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());

        if(apiKey == null || !apiKey.equals("secret-aa-bb")) {
            ctx.unset();
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
