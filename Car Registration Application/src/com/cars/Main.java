package com.cars;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<com.cars.Car> cars = new ArrayList<>();

        // Collect user details
        System.out.print("Please enter your name: ");
        String name = input.next();

        System.out.print("Please enter your surname: ");
        String surname = input.next();

        System.out.println("\nWelcome, " + name + " " + surname + "! 👋");

        int menuOption;
        do {
            // Display menu
            System.out.println("\nChoose an option:");
            System.out.println("1. Capture vehicle details");
            System.out.println("2. View vehicle report");
            System.out.println("3. Exit");
            menuOption = input.nextInt();

            switch (menuOption) {
                case 1 -> {
                    // Capture vehicle details
                    System.out.print("Enter make: ");
                    String make = input.next();

                    System.out.print("Enter model: ");
                    String model = input.next();

                    // Validate VIN
                    String vin;
                    do {
                        System.out.print("Enter 17-character VIN: ");
                        vin = input.next();
                        if (vin.length() != 17) {
                            System.out.println("❌ VIN must be exactly 17 characters.");
                        }
                    } while (vin.length() != 17);

                    // Plate number format
                    System.out.print("Choose plate format (1 = Old e.g. TTT166GP, 2 = New e.g. TT16TMGP): ");
                    int plateChoice = input.nextInt();

                    System.out.print("Enter plate number: ");
                    String plate = input.next();

                    // Millage and year
                    System.out.print("Enter millage: ");
                    int millage = input.nextInt();

                    System.out.print("Enter year: ");
                    int year = input.nextInt();

                    // Create and add vehicle
                    var car = new com.cars.Car();
                    car.setMake(make);
                    car.setModel(model);
                    car.setVin(vin);
                    car.setPlateNumber(plate);
                    car.setMillage(millage);
                    car.setYear(year);
                    cars.add(car);

                    System.out.println("✅ Vehicle successfully captured.");
                }

                case 2 -> {
                    // Show vehicle report
                    if (cars.isEmpty()) {
                        System.out.println("🚫 No vehicles captured yet.");
                    } else {
                        System.out.println("\n📋 Vehicle Report");
                        System.out.println("----------------------------");
                        for (com.cars.Car car : cars) {
                            System.out.println("Make: " + car.getMake());
                            System.out.println("Model: " + car.getModel());
                            System.out.println("VIN: " + car.getVin());
                            System.out.println("Plate: " + car.getPlateNumber());
                            System.out.println("Year: " + car.getYear());
                            System.out.println("Millage: " + car.getMillage());
                            System.out.println("----------------------------");
                        }
                    }
                }

                case 3 -> System.out.println("👋 Goodbye, " + name + "! Thanks for using the app.");

                default -> System.out.println("❌ Invalid option. Please try again.");
            }

        } while (menuOption != 3);

        input.close();
    }
}

