package com.peaksoft;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TruckService {

    public static void searchTruck(Truck[] trucks, Driver[] drivers) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Выберите truck: 1,2,3");
        while (true) {
            System.out.println("Если хотите заврешить программу нажмите на 0");
            System.out.println("выберите грузавика 1 2 3 ");
            int truckNumber = scn.nextInt();
            if (truckNumber == 0) {
                break;
            }
            Truck chooseTruck =  new Truck();
            for (Truck truck : trucks) {
                if (truck.getId() == truckNumber) {
                    chooseTruck = truck;
                }
            }
            System.out.println(chooseTruck);
            System.out.println("Выберите действие что хотите сделать");
            System.out.println("1- поменять водителя или назначить водителья");
            System.out.println("2- выйты на путь");
            System.out.println("3- отправить на ремонт");
            System.out.println("0- выйти из системы");
            int actionNumber = scn.nextInt();
            if (actionNumber == 0) {
                break;
            }
            switch (actionNumber) {
                case 1 -> changeDriver(chooseTruck, drivers);
                case 2 -> startDriving(chooseTruck);
                case 3 -> startRepairing(chooseTruck);
            }
            System.out.println(chooseTruck);
        }
    }

    public static void changeDriver(Truck truck, Driver[] drivers) {
        if (truck.getState().equals(State.ROUTE)) {
            System.out.println("Грузавик в пути нельзя сменить водителя");
        } else if (truck.getState().equals(State.REPAIR)) {
            System.out.println("Грузавик на ремонте нельзя его сменить");
        } else {
            for (Driver driver : drivers) {
                if (driver.getName().equals(" ")) {
                    if (!truck.getDriver().equals(" ")) {
                        Driver driver1 = getTruckName(truck.getDriver(), drivers);
                        driver1.setName(" ");
                    }
                    truck.setDriver(driver.getName());
                    driver.setName(truck.getName());
                    System.out.println("Теперь грузавик " + truck.getName() +
                            "ведёт водитель" + driver.getName());
                    break;
                }
            }
            if (truck.getDriver().equals(" ")) {
                System.out.println("Нет свободных водителей");
            }
        }
    }
    public static Driver getTruckName(String driver, Driver[] drivers) {
        return Arrays.stream(drivers)
                .filter(d -> d.getName().equals(""))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("нет свободных водителей"));
    }

    public static void startDriving(Truck truck) {
        if (truck.getState().equals(State.ROUTE)) {
            System.out.println("Грузавик уже в пути");
        } else if (truck.getDriver() == null) {
            System.out.println("нет свободных водителей");
        } else {
            truck.setState(State.ROUTE);
            System.out.println("Грузавик уже в пути");
        }
    }

    public static void startRepairing (Truck truck) {
        if (truck.getState().equals(State.REPAIR)) {
            System.out.println("Грузавик в ремонте брат");
        } else {
            truck.setState(State.REPAIR);
            System.out.println("Грузавик в ремонте");
        }
    }
}
