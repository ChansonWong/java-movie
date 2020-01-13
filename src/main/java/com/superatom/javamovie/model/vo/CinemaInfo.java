package com.superatom.javamovie.model.vo;

import java.util.List;

public class CinemaInfo {
    private String address;
    private List<String> channelicon;
    private String id;
    private String length;
    private String name;
    private String price;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getChannelicon() {
        return channelicon;
    }

    public void setChannelicon(List<String> channelicon) {
        this.channelicon = channelicon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
