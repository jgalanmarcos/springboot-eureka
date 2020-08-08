package com.jgm.app.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PreTimeFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PreTimeFilter.class);

    // Tipo de filtro: pre, post o route
    @Override

    public String filterType() {
        return "pre";
    }

    // orden del filtro
    @Override
    public int filterOrder() {
        return 1;
    }

    // validación para ejecutar el filtro, en este caso siempre se ejecutará
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // lógica del filtro
    @Override
    public Object run() throws ZuulException {
        log.info("Entrando a pre filter");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));

        Long ini = System.currentTimeMillis();
        request.setAttribute("ini", ini);

        return null;
    }

}