package com.atcong.Util;

import java.util.Map;

public class PlaneFindDetils {

    private String planeName;
    private String routeName;
    private String planeBeginTime;
    private String planeEndTime;

    public PlaneFindDetils(){}

    public PlaneFindDetils(String planeName,String routeName,String planeBeginTime,String planeEndTime){
        this.planeBeginTime = planeBeginTime;
        this.planeEndTime = planeEndTime;
        this.planeName = planeName;
        this.routeName = routeName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public String getPlaneBeginTime() {
        return planeBeginTime;
    }

    public void setPlaneBeginTime(String planeBeginTime) {
        this.planeBeginTime = planeBeginTime;
    }

    public String getPlaneEndTime() {
        return planeEndTime;
    }

    public void setPlaneEndTime(String planeEndTime) {
        this.planeEndTime = planeEndTime;
    }

}
