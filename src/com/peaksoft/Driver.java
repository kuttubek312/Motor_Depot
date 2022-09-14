package com.peaksoft;

import java.nio.file.Path;

import static com.peaksoft.JsonUtils.readFile;
import static com.peaksoft.Main.GSON;

public class Driver {
    private int id;
    private String name;
    private String truckName;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriver() {
        return truckName;
    }

    public void setDriver(String driver) {
        this.truckName = driver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", driver='" + name + '\'' +
                ", name='" + truckName + '\'' +
                '}';
    }

    public static Driver createDriver(int id, String truckName, String name){
        Driver driver1 = new Driver();
        driver1.id = id;
        driver1.name = name;
        driver1.truckName = truckName;
        return driver1;

    }
    public static void printInfoDriver(Path path){
        System.out.println("\n \tINFO ABOUT DRIVERS\n" +
                "---------+--------------+---------\n " +
                "# Driver       |Bus     ");
        Driver[] drivers = GSON.fromJson(readFile(path),Driver[].class);
        for (Driver driver : drivers) {
            System.out.printf("%-1s| ",driver.getId());
            System.out.printf(" %-11s |", driver.getName());
            System.out.printf(" %-12s | " , driver.getDriver());
            System.out.println("\n--------------------");
        }
    }
}
