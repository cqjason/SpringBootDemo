package com.springSecurityDemo.model;


import org.springframework.data.annotation.Id;

import javax.annotation.Generated;

/**
 * Created by Jason on 2018/3/19.
 */

public class SysRole {

    @Id
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
