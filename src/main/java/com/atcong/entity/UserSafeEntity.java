package com.atcong.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_safe", schema = "graduation", catalog = "")
public class UserSafeEntity {
    private int userId;
    private String userEmail;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSafeEntity that = (UserSafeEntity) o;

        if (userId != that.userId) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        return result;
    }
}
