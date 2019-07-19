package com.atcong.Util;

public class BusShowInfo {
    private String busName;
    private String routeName;
    private Integer busPay;

    public BusShowInfo(){}

    public BusShowInfo(String busName,String routeName,Integer busPay){
        this.busName = busName;
        this.routeName = routeName;
        this.busPay = busPay;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public Integer getBusPay() {
        return busPay;
    }

    public void setBusPay(Integer busPay) {
        this.busPay = busPay;
    }
}
