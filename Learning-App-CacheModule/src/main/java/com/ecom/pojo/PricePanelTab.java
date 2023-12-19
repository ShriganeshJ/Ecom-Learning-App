package com.ecom.pojo;

import org.springframework.data.mongodb.core.mapping.Field;

public class PricePanelTab {
    @Field("id")
    private String id;
    @Field("name")
    private String name;

    @Override
    public String toString() {
        return "PricePanelTab{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }

    @Field("actve")
    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }





}
