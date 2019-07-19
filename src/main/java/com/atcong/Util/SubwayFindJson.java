package com.atcong.Util;

public class SubwayFindJson {
    private String subwayName;
    private String routeName;
    private Integer subwayId;

    public SubwayFindJson(){}

    public SubwayFindJson(String subwayName,String routeName,Integer subwayId){
        this.subwayId = subwayId;
        this.subwayName = subwayName;
        this.routeName = routeName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Integer getSubwayId() {
        return subwayId;
    }

    public void setSubwayId(Integer subwayId) {
        this.subwayId = subwayId;
    }

    public String getSubwayName() {
        return subwayName;
    }

    public void setSubwayName(String subwayName) {
        this.subwayName = subwayName;
    }
}
