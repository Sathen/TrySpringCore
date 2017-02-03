package com.epam.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;


public class Client {


    private int id;
    @Autowired
    private String fullName;
    @Autowired
    private String greeting;


    public Client() {

    }

    public Client(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }


    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("com.epam.spring.bean.Client{");
        sb.append("id=").append(id);
        sb.append(", fullName=").append(fullName);
        sb.append('}');
        return sb.toString();
    }
}
