package com.atcong.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "train_details", schema = "graduation", catalog = "")
public class TrainDetailsEntity {
    private int trainId;
    private String trainBeginTime;
    private String trainEndTime;

    @Id
    @Column(name = "train_id")
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }


    @Basic
    @Column(name = "train_begin_time")
    public String getTrainBeginTime() {
        return trainBeginTime;
    }

    public void setTrainBeginTime(String trainBeginTime) {
        this.trainBeginTime = trainBeginTime;
    }

    @Basic
    @Column(name = "train_end_time")
    public String getTrainEndTime() {
        return trainEndTime;
    }

    public void setTrainEndTime(String trainEndTime) {
        this.trainEndTime = trainEndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainDetailsEntity that = (TrainDetailsEntity) o;

        if (trainId != that.trainId) return false;
        if (trainBeginTime != null ? !trainBeginTime.equals(that.trainBeginTime) : that.trainBeginTime != null)
            return false;
        if (trainEndTime != null ? !trainEndTime.equals(that.trainEndTime) : that.trainEndTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trainId;
        result = 31 * result + (trainBeginTime != null ? trainBeginTime.hashCode() : 0);
        result = 31 * result + (trainEndTime != null ? trainEndTime.hashCode() : 0);
        return result;
    }
}
