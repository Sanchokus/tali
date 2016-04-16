package com.aolisov.tali.data.store;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Alex on 4/15/2016.
 */
public interface ResponseStore{
    Map<String, ResponseEntry> get();
    ResponseEntry get(String address);
    void set(Map<String, ResponseEntry> responseMap) throws IOException;
}
