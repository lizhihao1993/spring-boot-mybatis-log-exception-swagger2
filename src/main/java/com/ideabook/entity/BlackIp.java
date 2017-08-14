package com.ideabook.entity;

import java.util.Date;

public class BlackIp {
    private Long id;

    private String ip;

    private Date ipTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getIpTime() {
        return ipTime;
    }

    public void setIpTime(Date ipTime) {
        this.ipTime = ipTime;
    }
}