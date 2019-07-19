package com.atcong.entity;

import javax.persistence.*;

@Entity
@Table(name = "bus_details", schema = "graduation")
public class BusDetailsEntity {
    private int busId;
    private Integer routeId;
    private String busRunDate;
    private String busCompany;
    private Integer busPay;
    private String busStatus;

    @Id
    @Column(name = "bus_id")
    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
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
    @Column(name = "bus_run_date")
    public String getBusRunDate() {
        return busRunDate;
    }

    public void setBusRunDate(String busRunDate) {
        this.busRunDate = busRunDate;
    }

    @Basic
    @Column(name = "bus_company")
    public String getBusCompany() {
        return busCompany;
    }

    public void setBusCompany(String busCompany) {
        this.busCompany = busCompany;
    }

    @Basic
    @Column(name = "bus_pay")
    public Integer getBusPay() {
        return busPay;
    }

    public void setBusPay(Integer busPay) {
        this.busPay = busPay;
    }

    @Basic
    @Column(name = "bus_status")
    public String getBusStatus() {
        return busStatus;
    }

    public void setBusStatus(String busStatus) {
        this.busStatus = busStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusDetailsEntity that = (BusDetailsEntity) o;

        if (busId != that.busId) return false;
        if (routeId != null ? !routeId.equals(that.routeId) : that.routeId != null) return false;
        if (busRunDate != null ? !busRunDate.equals(that.busRunDate) : that.busRunDate != null) return false;
        if (busCompany != null ? !busCompany.equals(that.busCompany) : that.busCompany != null) return false;
        if (busPay != null ? !busPay.equals(that.busPay) : that.busPay != null) return false;
        if (busStatus != null ? !busStatus.equals(that.busStatus) : that.busStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = busId;
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        result = 31 * result + (busRunDate != null ? busRunDate.hashCode() : 0);
        result = 31 * result + (busCompany != null ? busCompany.hashCode() : 0);
        result = 31 * result + (busPay != null ? busPay.hashCode() : 0);
        result = 31 * result + (busStatus != null ? busStatus.hashCode() : 0);
        return result;
    }
}
