package com.atcong.Util;

public class PlaneFindJson {
    private Integer planeId;
    private String planeName;
    private String routeName;

    public PlaneFindJson(){}

    public PlaneFindJson(Integer planeId,String planeName,String routeName){
        this.planeId = planeId;
        this.planeName = planeName;
        this.routeName = routeName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Integer getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }
}
