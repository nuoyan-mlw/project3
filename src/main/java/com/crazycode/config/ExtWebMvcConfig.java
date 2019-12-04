package com.crazycode.config;

import com.crazycode.convert.StringToTimestamp;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ExtWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(new StringToTimestamp());
    }
}
