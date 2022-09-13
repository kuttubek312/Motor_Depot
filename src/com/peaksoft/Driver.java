package com.peaksoft;

import java.nio.file.Path;

import static com.peaksoft.JsonUtils.readFile;
import static com.peaksoft.Main.GSON;

public class Driver {
    private int id;
    private String name;
    private String driver;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
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
                ", name='" + driver + '\'' +
                '}';
    }

    public static Driver createDriver(int id, String driver, String name){
        Driver driver1 = new Driver();
        driver1.id = id;
        driver1.name = name;
        driver1.driver = driver;
        return driver1;

    }
    public static void printInfoDriver(Path path){
        System.out.println("\n \tINFO ABOUT DRIVERS\n" +
                "-------+--------------------+---------\n " +
                "#Driver    |       Bus     ");
        Driver[] drivers = GSON.fromJson(readFile(path),Driver[].class);
        for (Driver driver : drivers) {
            System.out.printf("%-1s | ",driver.getId());
            System.out.printf(" %-10s  | " , driver.getDriver());
            System.out.printf(" %-10s | ", driver.getName());
            System.out.println("-----------------------------");
        }
    }
}
