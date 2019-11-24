package com.moocaltin.simpleservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    private final FreeMarkerViewResolver freeMarkerViewResolver;

    public MvcConfig(FreeMarkerViewResolver freeMarkerViewResolver) {
        this.freeMarkerViewResolver = freeMarkerViewResolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(freeMarkerViewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");
        registry
                .addResourceHandler("/*")
                .addResourceLocations("classpath:/");
    }
}
