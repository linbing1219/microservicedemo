package com.jimmylin.springcloud.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private Date dateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public User() {}

    public User(int id) {
        this.id = id;
        this.dateTime = new Date();
    }


}
