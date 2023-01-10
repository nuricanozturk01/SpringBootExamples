package com.nuricanozturk.clientinformationservice.controller;

import com.nuricanozturk.clientinformationservice.data.entity.Client;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientInfoController
{
    private final HttpServletRequest m_httpServletRequest;

    public ClientInfoController(HttpServletRequest m_httpServletRequest)
    {
        this.m_httpServletRequest = m_httpServletRequest;
    }

    @GetMapping("info")
    public String getClientInfo()
    {
        var ci = new Client();

        ci.host = m_httpServletRequest.getRemoteHost();
        ci.port = m_httpServletRequest.getRemotePort();
        ci.localHost = m_httpServletRequest.getLocalAddr();
        ci.localPort = m_httpServletRequest.getLocalPort();

        return ci.toString();
    }

    @GetMapping("json/info")
    public Client getClientInfoJSON()
    {
        var ci = new Client();

        ci.host = m_httpServletRequest.getRemoteHost();
        ci.port = m_httpServletRequest.getRemotePort();
        ci.localHost = m_httpServletRequest.getLocalAddr();
        ci.localPort = m_httpServletRequest.getLocalPort();

        return ci;
    }

}
