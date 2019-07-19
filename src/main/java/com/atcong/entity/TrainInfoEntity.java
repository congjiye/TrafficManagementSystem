package com.atcong.entity;

import javax.persistence.*;

@Entity
@Table(name = "train_info", schema = "graduation")
public class TrainInfoEntity {
    private int trainId;
    private String trainName;
    private Integer trainRoute;

    @Id
    @Column(name = "train_id")
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "train_name")
    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    @Basic
    @Column(name = "train_route")
    public Integer getTrainRoute() {
        return trainRoute;
    }

    public void setTrainRoute(Integer trainRoute) {
        this.trainRoute = trainRoute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainInfoEntity that = (TrainInfoEntity) o;

        if (trainId != that.trainId) return false;
        if (trainName != null ? !trainName.equals(that.trainName) : that.trainName != null) return false;
        if (trainRoute != null ? !trainRoute.equals(that.trainRoute) : that.trainRoute != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trainId;
        result = 31 * result + (trainName != null ? trainName.hashCode() : 0);
        result = 31 * result + (trainRoute != null ? trainRoute.hashCode() : 0);
        return result;
    }
}
