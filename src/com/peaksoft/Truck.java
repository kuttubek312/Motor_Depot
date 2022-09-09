package com.peaksoft;

public class Truck {
    private int id;
    private String name;
    private String driver;
    private State state;

//    public Driver(int id, String name, String driver, State state) {
//        this.id = id;
//        this.name = name;
//        this.driver = driver;
//        this.state = state;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static Truck makeTruck(int id, String name, String driver, State state){
        Truck driver1 = new Truck();
        driver1.id = id;
        driver1.name = name;
        driver1.driver = driver;
        driver1.state = state;
        return driver1;
    }

    @Override
    public String toString() {
        return "Truck{" + "id=" + id + " name='" + name + "" + " driver='" + driver + "" + " state=" + state + '}';
    }
}
