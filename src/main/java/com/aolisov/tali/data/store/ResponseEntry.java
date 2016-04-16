package com.aolisov.tali.data.store;

import java.util.Date;

/**
 * Created by Alex on 4/16/2016.
 */
public class ResponseEntry {

    private int code;
    private Date dateTime;

    public ResponseEntry() {
    }

    public ResponseEntry(int code, Date dateTime) {
        this.code = code;
        this.dateTime = dateTime;
    }

    public int getCode() {
        return code;
    }

    public Date getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseEntry that = (ResponseEntry) o;

        if (code != that.code) return false;
        return dateTime != null ? dateTime.equals(that.dateTime) : that.dateTime == null;

    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }
}
