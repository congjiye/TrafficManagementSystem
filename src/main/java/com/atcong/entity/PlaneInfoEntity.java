package com.atcong.entity;

import javax.persistence.*;

@Entity
@Table(name = "plane_info", schema = "graduation")
public class PlaneInfoEntity {
    private int planeId;
    private String planeName;
    private Integer planeRoute;

    @Id
    @Column(name = "plane_id")
    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    @Basic
    @Column(name = "plane_name")
    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    @Basic
    @Column(name = "plane_route")
    public Integer getPlaneRoute() {
        return planeRoute;
    }

    public void setPlaneRoute(Integer planeRoute) {
        this.planeRoute = planeRoute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaneInfoEntity that = (PlaneInfoEntity) o;

        if (planeId != that.planeId) return false;
        if (planeName != null ? !planeName.equals(that.planeName) : that.planeName != null) return false;
        if (planeRoute != null ? !planeRoute.equals(that.planeRoute) : that.planeRoute != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = planeId;
        result = 31 * result + (planeName != null ? planeName.hashCode() : 0);
        result = 31 * result + (planeRoute != null ? planeRoute.hashCode() : 0);
        return result;
    }
}
