package com.vip.leona.entity;

import lombok.Data;

@Data
public class Application {
    public Integer id;
    public String envId;
    public String name;
    public String domain;
    public String ip;

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", envId='" + envId + '\'' +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
