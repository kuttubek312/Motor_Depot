package com.peaksoft;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Service {
//
//    static String truckName;
//
//    static String driverName = null;
//
//    static Driver driver = new Driver();
//    static String dr;

    public void searchTruck(Truck[] trucks,Driver[] drivers){

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Нажмите на ноль что-бы останавить программу");
            System.out.println("Выберите truck: 1,2,3");
            int truckId = sc.nextInt();
            if (truckId == 0){
                break;
            }
            try {
                Truck chooseTruck = getTruckById(trucks, truckId);
                System.out.println(chooseTruck);
                System.out.println("Выберите действия для продолжение программ");
                System.out.println("1 - поменять водителя или назначить водителя");
                System.out.println("2 - Выйте в путь ");
                System.out.println("3 - отпарвить на ремонт");
                System.out.println("0 - завершить пограмму");
                int actionNumber = sc.nextInt();
                if (actionNumber == 0){
                    break;
                }
                switch (actionNumber){
                    case 1 -> changeDrivers(chooseTruck,drivers);
                    case 2 -> startDriving(chooseTruck);
                    case 3 -> startRepairing(chooseTruck);
                }
                System.out.println(chooseTruck);
            }catch (NoSuchElementException e){
                System.out.println(e.getMessage());
            }
        }


    }
    public static void changeDrivers(Truck truck, Driver[] drivers){
        if (truck.getState().equals(State.ROUTE)){
            System.out.println("Грузавик жолдо нельзя сменить водителья");
        }else {
            for (Driver driver : drivers) {
                if (driver.getTruckName.equals(" ")){
                    if (!truck.getDriver().equals(" ")){
                        Driver driver1 = getDriverName(truck.getDriver(), drivers);
                        driver1.setTruckName(" ");
                    }
                    truck.setDriver(driver.getName());
                    driver.setTruckName(truck.getName());
                    System.out.println("Теперь грузовик" + truck.getName() +
                            " ведёть водитель " + driver.getName());
                    break;
                }
            }
        }
        if (truck.getDriver().equals(" ")){
            System.out.println("Нет свободных водителей");
        }
    }
    public static void startDriving(String truckName,String driverName){
        System.out.println("Теперь грузовик " + truckName + "машина в пути и за рулём " + driverName);
    }
    public static void startRepairing(String truckName){
        System.out.println("Теперь грузовик на" + truckName+ " ремонте ");
    }

    public static Truck getTruckById(Truck[] trucks,int id ) throws NoSuchElementException {
        return Arrays.stream(trucks)
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Truck : не найден");
    }
}
