package com.aolisov.tali.pinger;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/14/2016.
 */
public class SimpleHttpPingerTest {

    private static int HTTP_OK_CODE = 200;

    @Test
    public void testCorrectSites() {
        List<String> urls = new ArrayList<>();
        urls.add("http://google.com");
        urls.add("http://yandex.com");

        Pinger pinger = new SimpleHttpPinger();
        for(String url: urls) {
            int code = pinger.ping(url);
            Assert.assertEquals(code, HTTP_OK_CODE);
        }
    }

    @Test
    public void testNotExistedSite() {
        Assert.assertEquals(0, new SimpleHttpPinger().ping("http://i-really-do-not-exist.xyzabc"));
    }
}