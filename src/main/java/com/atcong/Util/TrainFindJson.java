package com.atcong.Util;

public class TrainFindJson {
    private Integer trainId;
    private String trainName;
    private String routeName;

    public TrainFindJson(){}

    public TrainFindJson(Integer trainId,String trainName,String routeName){
        this.trainId = trainId;
        this.trainName = trainName;
        this.routeName = routeName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
}
