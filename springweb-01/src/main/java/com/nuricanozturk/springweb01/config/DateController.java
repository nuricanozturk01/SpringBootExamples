package com.nuricanozturk.springweb01.config;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Scope("prototype") // Her seferinde değişen zaman almak için.
// LocalDateTime prototype yaptık ama Controller singleton
@RequestMapping("date")
public class DateController
{
    private final LocalDateTime m_localDateTime;
    private final DateTimeFormatter m_dateTimeFormatter;

    public DateController(LocalDateTime m_localDateTime, DateTimeFormatter m_dateTimeFormatter)
    {
        this.m_localDateTime = m_localDateTime;
        this.m_dateTimeFormatter = m_dateTimeFormatter;
    }

    @GetMapping("datetime")
    public String getDateTime()
    {
        return m_localDateTime.format(m_dateTimeFormatter);
    }
}
