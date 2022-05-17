package com.database;

public class ExpertModal {

    private String name;
    private String email;
    private String carrier;
    private String works;
    private int id;

    // creating getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setCEmail(String email) {
        this.email = email;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public ExpertModal(String name, String email, String carrier, String works) {
        this.name = name;
        this.email = email;
        this.carrier = carrier;
        this.works = works;
    }
}
