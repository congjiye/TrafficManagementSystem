package com.atcong.entity;

import javax.persistence.*;

@Entity
@Table(name = "subway_info", schema = "graduation")
public class SubwayInfoEntity {
    private int subwayId;
    private String subwayName;
    private Integer subwayRoute;

    @Id
    @Column(name = "subway_id")
    public int getSubwayId() {
        return subwayId;
    }

    public void setSubwayId(int subwayId) {
        this.subwayId = subwayId;
    }

    @Basic
    @Column(name = "subway_name")
    public String getSubwayName() {
        return subwayName;
    }

    public void setSubwayName(String subwayName) {
        this.subwayName = subwayName;
    }

    @Basic
    @Column(name = "subway_route")
    public Integer getSubwayRoute() {
        return subwayRoute;
    }

    public void setSubwayRoute(Integer subwayRoute) {
        this.subwayRoute = subwayRoute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubwayInfoEntity that = (SubwayInfoEntity) o;

        if (subwayId != that.subwayId) return false;
        if (subwayName != null ? !subwayName.equals(that.subwayName) : that.subwayName != null) return false;
        if (subwayRoute != null ? !subwayRoute.equals(that.subwayRoute) : that.subwayRoute != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subwayId;
        result = 31 * result + (subwayName != null ? subwayName.hashCode() : 0);
        result = 31 * result + (subwayRoute != null ? subwayRoute.hashCode() : 0);
        return result;
    }
}
