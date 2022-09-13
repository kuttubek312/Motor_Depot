package com.peaksoft;

import com.google.gson.Gson;

import java.nio.file.Path;

import static com.peaksoft.JsonUtils.readFile;
import static com.peaksoft.Main.GSON;

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
        Truck truck = new Truck();
        truck.id = id;
        truck.name = name;
        truck.driver = driver;
        truck.state = state;
        return truck;
    }

   public static void printInfoTrack(Path path){
       System.out.println("\n \tINFO ABOUT TRUCKS\n" +
               "----------------------------------------\n +" +
               "#  |    Bus         |  Driver      |  State\n +" +
               "----------------------------------------");
       Truck[] trucks = GSON.fromJson(readFile(path),Truck[].class);
       for (Truck truck : trucks) {
           System.out.printf("%-1s |",truck.getId());
           System.out.printf(" %-18s |", truck.getName());
           System.out.printf(" %-10s|",  truck.getDriver());
           System.out.printf(" %-10s", truck.getState());
           System.out.println("-------------------------------------");
       }
   }

    @Override
    public String toString() {
        return " " + id + " | " + name + " | " + driver + " | " + state;
    }
}
