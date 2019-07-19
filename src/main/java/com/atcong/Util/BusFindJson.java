package com.atcong.Util;

public class BusFindJson {
    private Integer bus_id;
    private String bus_name;
    private String route_name;

    public BusFindJson(){}

    public BusFindJson(Integer bus_id,String bus_name,String route_name){
        this.bus_id = bus_id;
        this.bus_name = bus_name;
        this.route_name = route_name;
    }

    public Integer getBus_id() {
        return bus_id;
    }

    public void setBus_id(Integer bus_id) {
        this.bus_id = bus_id;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public String getRoute_name() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }
}
