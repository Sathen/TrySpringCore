package com.epam.spring.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(generator= "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id",nullable = false)
    private Long id;
    private String fullName;
    private String greeting;

    public Client() {
    }

    public Client(String fullName) {
        this.fullName = fullName;
    }


    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
