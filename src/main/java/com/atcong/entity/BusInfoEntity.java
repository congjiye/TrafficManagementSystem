package com.atcong.entity;

import javax.persistence.*;

@Entity
@Table(name = "bus_info", schema = "graduation")
public class BusInfoEntity {
    private int busId;
    private String busName;
    private Integer routeId;

    @Id
    @Column(name = "bus_id")
    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    @Basic
    @Column(name = "bus_name")
    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusInfoEntity that = (BusInfoEntity) o;

        if (busId != that.busId) return false;
        if (busName != null ? !busName.equals(that.busName) : that.busName != null) return false;
        if (routeId != null ? !routeId.equals(that.routeId) : that.routeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = busId;
        result = 31 * result + (busName != null ? busName.hashCode() : 0);
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "route_id")
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }
}
