package com.js.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.rmi.transport.Transport;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Created by Jason on 2018/3/8.
 */
@Configuration
public class MyConfig {
    @Bean
    public TransportClient client() throws UnknownHostException {
        byte[] bs = new byte[] { (byte) 192, (byte) 168, 40, 82 };
        TransportAddress node = new TransportAddress(InetAddress.getByAddress(bs),9300);


        Settings settings = Settings.builder().put("cluster.name","my-application").build();

        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);

        return client;
    }
}
