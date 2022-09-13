package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.*;

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


        write(GSON.toJson(trucks), PATH_TRUCKS);
        System.out.println(readFile(PATH_TRUCKS));
        printInfoTruck(PATH_TRUCKS);

        Truck[] trucks1 = GSON.fromJson(readFile(PATH_TRUCKS),Truck[].class);
        searchTruck(trucks1);



//        String allTrucks = gson.toJson(trucks);
//        System.out.print(allTrucks);
//        writeFile(allTrucks);
//
//    }
//    private static void writeFile(String object){
//        Path write = Paths.get(String.valueOf(WRITE_PATH));
//        try {
//            Files.writeString(write,object, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
//        }catch (Exception e){
//            e.getMessage();
//        }
//
//
//








//        CarFleet[] carFleets = {
//                CarFleet.makeCarFleet("1 | Renault","",State.BASE),
//                CarFleet.makeCarFleet("2 | Volvo","",State.BASE),
//                CarFleet.makeCarFleet("3 | DAF XT","",State.BASE),
//        };
//        String allCarFleet = gson.toJson(carFleets);
//        System.out.println(allCarFleet);
//
//    }
//    public static void writeFile2(String Object){
//        Path write2 = Paths.get(String.valueOf(WRITE_PATH));
//        try {
//            Files.writeString(write2,Object,StandardOpenOption.CREATE,StandardOpenOption.WRITE);
//        }catch (Exception e){
//            e.getMessage();
//        }

    }
}
