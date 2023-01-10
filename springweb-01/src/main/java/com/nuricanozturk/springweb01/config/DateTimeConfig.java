package com.nuricanozturk.springweb01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeConfig
{
    @Bean
    public DateTimeFormatter getFormatter()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss");
    }
    @Bean
    @Scope("prototype")
    public LocalDateTime getDateTime()
    {
        return LocalDateTime.now();
    }
}
