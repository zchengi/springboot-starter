package org.cheng.config;

import org.cheng.controller.interceptor.OneInterceptor;
import org.cheng.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author cheng
 *         2018/4/27 22:18
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 拦截器按照顺序执行
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
        // 拦截两次，先拦截 two，再拦截 one
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**").addPathPatterns("/one/**");

        super.addInterceptors(registry);
    }
}
