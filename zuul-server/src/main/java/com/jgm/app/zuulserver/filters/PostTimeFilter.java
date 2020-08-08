package com.jgm.app.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PostTimeFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PostTimeFilter.class);

    // Tipo de filtro: pre, post o route
    @Override

    public String filterType() {
        return "post";
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
        log.info("Entrando a post filter");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        Long ini = (Long) request.getAttribute("ini");
        Long fin = System.currentTimeMillis();
        Long tiempo = fin - ini;

        log.info(String.format("Tiempo transcurrido en segundos %s", tiempo.doubleValue() / 1000.00));
        log.info(String.format("Tiempo transcurrido en milisegundos %s", tiempo));

        return null;
    }

}