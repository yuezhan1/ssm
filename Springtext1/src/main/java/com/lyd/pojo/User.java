package com.lyd.pojo;

public class User {
    private String name;
    private String compony; //公司
    private Car car;
    private String habit;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompony() {
        return compony;
    }

    public void setCompony(String compony) {
        this.compony = compony;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }
}
