package com.aolisov.tali.misc;

import com.aolisov.tali.schedule.PingerScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.IOException;

/**
 * Created by Alex on 4/16/2016.
 */
public class PostInitLauncher implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    PingerScheduler pingerScheduler;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            pingerScheduler.startTask();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldn't start Tali at deployment!");
        }
    }
}
