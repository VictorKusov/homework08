package ru.list.victor_90.study.myapplication.rest.models;


import com.google.gson.annotations.SerializedName;

import java.util.*;

public class Users {
    @SerializedName("user-token")
    private String userToken;

    private String email;
    private java.util.Date lastLogin;
    private String name;

    private String objectId;
    private java.util.Date updated;
    private java.util.Date created;
    private String ownerId;

    public String getUserToken() {
        return userToken;
    }

    public String getEmail() {
        return email;
    }

    public java.util.Date getLastLogin() {
        return lastLogin;
    }

    public String getName() {
        return name;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userToken='" + userToken + '\'' +
                ", email='" + email + '\'' +
                ", lastLogin=" + lastLogin +
                ", name='" + name + '\'' +
                ", objectId='" + objectId + '\'' +
                ", updated=" + updated +
                ", created=" + created +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
