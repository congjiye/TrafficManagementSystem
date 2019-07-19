package com.atcong.entity;

import javax.persistence.*;

@Entity
@Table(name = "bus_route", schema = "graduation")
public class BusRouteEntity {
    private int routeId;
    private String routeName;

    @Id
    @Column(name = "route_id")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "route_name")
    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusRouteEntity that = (BusRouteEntity) o;

        if (routeId != that.routeId) return false;
        if (routeName != null ? !routeName.equals(that.routeName) : that.routeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId;
        result = 31 * result + (routeName != null ? routeName.hashCode() : 0);
        return result;
    }
}
