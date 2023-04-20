package org.csystem.app.geonames.postalcodesearch.api.geonames.service;

import org.csystem.app.geonames.postalcodesearch.api.geonames.PostalCodes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Scope("prototype")
public class PostalCodeSearchService
{
    private final RestTemplate m_restTemplate;


    @Value("${app.geonames.url}")
    private String m_url;

    public PostalCodeSearchService(RestTemplate restTemplate)
    {
        m_restTemplate = restTemplate;
    }

    public PostalCodes searchPostalCode(String code)
    {
        var pc = m_restTemplate.getForObject(String.format(m_url, code), PostalCodes.class);
        return m_restTemplate.getForObject(String.format(m_url, code), PostalCodes.class);
    }
}
