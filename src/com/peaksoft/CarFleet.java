package com.peaksoft;

public class CarFleet {
    private String Bus;
    private String Driver;
    private State state;

    public String getBus() {
        return Bus;
    }

    public void setBus(String bus) {
        Bus = bus;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static CarFleet makeCarFleet(String bus,String driver,State state){
        CarFleet carFleet = new CarFleet();
        carFleet.Bus = bus;
        carFleet.Driver = driver;
        carFleet.state = state;
        return carFleet;
    }


    @Override
    public String toString() {
        return "CarFleet{" +
                "Bus='" + Bus + '\'' +
                ", Driver='" + Driver + '\'' +
                ", state=" + state +
                '}';
    }
}
