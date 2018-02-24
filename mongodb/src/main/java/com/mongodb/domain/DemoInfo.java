package com.mongodb.domain;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;

/**
 * Created by Jason on 2018/1/16.
 */
public class DemoInfo {

    @Id
    private String id;

    private String name;

    @Min(value = 18,message = "Too little!")
    private int age;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DemoInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", agel=" + age +
                '}';
    }
}
