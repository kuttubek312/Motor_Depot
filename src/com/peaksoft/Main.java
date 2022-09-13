package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.*;

import static com.peaksoft.Driver.printInfoDriver;
import static com.peaksoft.JsonUtils.readFile;
import static com.peaksoft.JsonUtils.write;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path PATH_DRIVERS = Path.of("./drivers.json");
    public static final Path PATH_TRUCKS = Path.of("./trucks.json");
    public static void main(String[] args) {
	// write your code here

        Truck[] trucks = {
                Truck.makeTruck(1,"Renault Magnum","",State.BASE),
                Truck.makeTruck(2,"VOLVO","",State.BASE),
                Truck.makeTruck(3,"DAF XT","",State.BASE),
        };

        Driver[] drivers = {
                Driver.createDriver(1,"","Petr"),
                Driver.createDriver(2,"","ASKAR"),
                Driver.createDriver(3,"","Uson")
        };

        write(GSON.toJson(trucks), PATH_TRUCKS);
        write(GSON.toJson(drivers),PATH_DRIVERS);
        System.out.println(readFile(PATH_TRUCKS));
        System.out.println(readFile(PATH_DRIVERS));

        printInfoDriver(PATH_DRIVERS);
       // printInfoTruck(PATH_TRUCKS);



        Truck[] trucks1 = GSON.fromJson(readFile(PATH_TRUCKS),Truck[].class);
        Driver[] drivers1 = GSON.fromJson(readFile(PATH_DRIVERS),Driver[].class);
      //  searchTruck(trucks1,drivers1);

    }
}
