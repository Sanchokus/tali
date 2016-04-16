package com.aolisov.tali.schedule;

import com.aolisov.tali.data.properties.PropertiesHolder;
import com.aolisov.tali.data.store.ResponseStore;
import com.aolisov.tali.data.store.ResponseEntry;
import com.aolisov.tali.pinger.Pinger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by Alex on 4/15/2016.
 */

//fixme why i see 2 pinger scheduler tasks in log??
@Component
@Scope("singleton")
public class PingerScheduler implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(PingerScheduler.class);

    @Autowired
    private PropertiesHolder propertiesHolder;
    @Autowired
    private ResponseStore responseStore;
    @Autowired
    private Pinger pinger;

    private ScheduledFuture future;

    private class Task implements Runnable {
        @Override
        public void run() {
            pingAllAddresses();
        }
    }

    private void pingAllAddresses() {
        try {
            Map<String,ResponseEntry> resultMap = new HashMap<>();
            for(String address: propertiesHolder.getProperties().getAddresses()) {
                logger.info("Started to ping {}", address);
                int code = pinger.ping(address);
                logger.info("Successfully pinged {}", address);
                resultMap.put(address, new ResponseEntry(code, new Date()));
            }
            responseStore.set(resultMap);
            logger.info("Result store was successfully set. Number of addresses: {}", resultMap.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startTask() throws IOException {
        startTask(propertiesHolder.getProperties().getCron());
    }

    public void startTask(String cron) {
        if(future != null) {
            stopTask();
        }
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.initialize();
        logger.info("Task will be started now - cron will be: " + cron);
        future = scheduler.schedule(new Task(),new CronTrigger(cron));
    }

    public void stopTask() {
        if(future != null) {
            future.cancel(false);
            future = null;
            logger.info("Tali task successfully stopped.");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Initializing Tali...");
        pingAllAddresses();
        startTask();
        logger.info("Tali initialized.");
    }
}
