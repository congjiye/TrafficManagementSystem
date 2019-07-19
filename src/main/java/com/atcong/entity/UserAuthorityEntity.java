package com.atcong.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_authority", schema = "graduation")
public class UserAuthorityEntity {
    private int userId;
    private Integer userAuthority;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_authority")
    public Integer getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(Integer userAuthority) {
        this.userAuthority = userAuthority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAuthorityEntity that = (UserAuthorityEntity) o;

        if (userId != that.userId) return false;
        if (userAuthority != null ? !userAuthority.equals(that.userAuthority) : that.userAuthority != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userAuthority != null ? userAuthority.hashCode() : 0);
        return result;
    }
}
