package com.epam.spring.bean;


import java.text.DateFormat;
import java.util.Date;
import java.util.Random;


public class Event {

    private int id ;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date dat,  DateFormat dateFormat) {
        this.id = new Random().nextInt();
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Event{");
        sb.append("id=").append(id);
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", date=").append(dateFormat.format(date));
        sb.append('}');
        return sb.toString();
    }
}
