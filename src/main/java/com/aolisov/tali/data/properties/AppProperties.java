package com.aolisov.tali.data.properties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/14/2016.
 */
public class AppProperties {
    private List<String> addresses = new ArrayList<>();
    private String cron = "";
    private String adminUserName = "";
    private String adminPassword = "";

    public AppProperties() {
    }

    public AppProperties(List<String> addresses, String cron, String adminUserName, String adminPassword) {
        this.addresses = addresses;
        this.cron = cron;
        this.adminUserName = adminUserName;
        this.adminPassword = adminPassword;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public String getCron() {
        return cron;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
}
