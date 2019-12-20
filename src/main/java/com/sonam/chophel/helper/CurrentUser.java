package com.sonam.chophel.helper;

import java.util.Date;

/**
 * Created by N-Zepa on 19-Jun-18.
 */
public class CurrentUser {
    private String username;
    private String userFullName;
    private Date serverDate = new Date(); //Calender Date
    private Character userType;
    private Character userStatus;
    private Integer userGroupId;

    public CurrentUser() {
    }

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getServerDate() {
        return serverDate;
    }

    public void setServerDate(Date serverDate) {
        this.serverDate = serverDate;
    }

    public Character getUserType() {
        return userType;
    }

    public void setUserType(Character userType) {
        this.userType = userType;
    }

    public Character getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Character userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
}