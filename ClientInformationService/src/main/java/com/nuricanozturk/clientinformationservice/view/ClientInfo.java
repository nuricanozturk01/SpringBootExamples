package com.nuricanozturk.clientinformationservice.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.SortedMap;

public class ClientInfo
{
    public String host;
    public int port;
    @JsonProperty("localAddr")
    public String localHost;
    //@JsonFormat(pattern = "dd/MM/yyyy kk:mm:ss")
    public int localPort;

    @Override
    public String toString()
    {
        return String.format("%s:%d, %s:%d", host, port, localHost, localPort);
    }
}
