package com.aolisov.tali.data.store.memory;

import com.aolisov.tali.data.store.ResponseEntry;
import com.aolisov.tali.data.store.ResponseStore;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 4/16/2016.
 */
public class InMemoryResponseStore implements ResponseStore {

    private Map<String, ResponseEntry> data = new HashMap<>();

    @Override
    public Map<String, ResponseEntry> get() {
        return data;
    }

    @Override
    public ResponseEntry get(String address) {
        return data.get(address);
    }

    @Override
    public void set(Map<String, ResponseEntry> responseMap) throws IOException {
        this.data = responseMap;
    }
}
