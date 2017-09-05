package com.vip.leona.entity;

import lombok.Data;

@Data
public class Environment {
    public Integer id;
    public String name;
    public String displayName;

    @Override
    public String toString() {
        return "Environment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
