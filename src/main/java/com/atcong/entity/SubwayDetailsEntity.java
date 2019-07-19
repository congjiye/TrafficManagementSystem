package com.atcong.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "subway_details", schema = "graduation")
public class SubwayDetailsEntity {
    private int subwayId;
    private Integer routeId;
    private String subwayBeginTime;
    private String subwayEndTime;

    @Id
    @Column(name = "subway_id")
    public int getSubwayId() {
        return subwayId;
    }

    public void setSubwayId(int subwayId) {
        this.subwayId = subwayId;
    }

    @Basic
    @Column(name = "route_id")
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "subway_begin_time")
    public String getSubwayBeginTime() {
        return subwayBeginTime;
    }

    public void setSubwayBeginTime(String subwayBeginTime) {
        this.subwayBeginTime = subwayBeginTime;
    }

    @Basic
    @Column(name = "subway_end_time")
    public String getSubwayEndTime() {
        return subwayEndTime;
    }

    public void setSubwayEndTime(String subwayEndTime) {
        this.subwayEndTime = subwayEndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubwayDetailsEntity that = (SubwayDetailsEntity) o;

        if (subwayId != that.subwayId) return false;
        if (routeId != null ? !routeId.equals(that.routeId) : that.routeId != null) return false;
        if (subwayBeginTime != null ? !subwayBeginTime.equals(that.subwayBeginTime) : that.subwayBeginTime != null)
            return false;
        if (subwayEndTime != null ? !subwayEndTime.equals(that.subwayEndTime) : that.subwayEndTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subwayId;
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        result = 31 * result + (subwayBeginTime != null ? subwayBeginTime.hashCode() : 0);
        result = 31 * result + (subwayEndTime != null ? subwayEndTime.hashCode() : 0);
        return result;
    }
}
