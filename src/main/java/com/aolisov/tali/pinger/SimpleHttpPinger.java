package com.aolisov.tali.pinger;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * Created by Alex on 4/14/2016.
 */
public class SimpleHttpPinger implements Pinger {
    @Override
    public int ping(String address) {

        HttpClient client = HttpClientBuilder.create().build();
        try {
        HttpGet request = new HttpGet(address);
            HttpResponse response = client.execute(request);
            return response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            //So site is unavailable.
        }
        return 0;
    }
}
