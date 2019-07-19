package com.atcong.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "plane_details", schema = "graduation")
public class PlaneDetailsEntity {
    private int planeId;
    private String planeBeginTime;
    private String planeEndTime;

    @Id
    @Column(name = "plane_id")
    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }


    @Basic
    @Column(name = "plane_begin_time")
    public String getPlaneBeginTime() {
        return planeBeginTime;
    }

    public void setPlaneBeginTime(String planeBeginTime) {
        this.planeBeginTime = planeBeginTime;
    }

    @Basic
    @Column(name = "plane_end_time")
    public String getPlaneEndTime() {
        return planeEndTime;
    }

    public void setPlaneEndTime(String planeEndTime) {
        this.planeEndTime = planeEndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaneDetailsEntity that = (PlaneDetailsEntity) o;

        if (planeId != that.planeId) return false;
        if (planeBeginTime != null ? !planeBeginTime.equals(that.planeBeginTime) : that.planeBeginTime != null)
            return false;
        if (planeEndTime != null ? !planeEndTime.equals(that.planeEndTime) : that.planeEndTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = planeId;
        result = 31 * result + (planeBeginTime != null ? planeBeginTime.hashCode() : 0);
        result = 31 * result + (planeEndTime != null ? planeEndTime.hashCode() : 0);
        return result;
    }
}
