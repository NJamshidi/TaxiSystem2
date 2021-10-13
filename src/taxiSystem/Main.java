package taxiSystem;

import taxiSystem.enumeration.TypeOfVehicle;
import taxiSystem.model.person.Driver;
import taxiSystem.model.person.Passenger;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

import taxiSystem.dataAccess.*;
import taxiSystem.model.vehicle.Car;
import taxiSystem.model.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        DriverDataAccess driverDataAccess = new DriverDataAccess();
        PassengerDataAccess passengerDataAccess = new PassengerDataAccess();
        while (true) {
            showMenu:
            showFirstPage();
            int selection = input.nextInt();
            switch (selection) {
                case 1: {
                    System.out.println("Enter number of drivers:");
                    int numberOfdrivers = input.nextInt();
                    for (int i = 0; i < numberOfdrivers; i++) {
                        System.out.println("Enter drivers information: (userName, name, family, nationalCode, phoneNumber ,age,nameOfCar ,color, numberOfCar ) ");
                        input.nextLine();

                        String line = input.nextLine();
                        String[] lineArray = line.split(",");
                        String userName = lineArray[0];
                        String name = lineArray[1];
                        String family = lineArray[2];
                        String nationalCode = lineArray[3];
                        String phoneNumber = lineArray[4];
                        String strAge = lineArray[5];
                        int age = Integer.parseInt(strAge);
                        String nameOfCar = lineArray[6];
                        String color = lineArray[7];
                        String number = lineArray[8];
                        Vehicle vehicle = new Vehicle(1, nameOfCar, color, number);
                        int id = CarDataAccess.addVehicle(vehicle);
                        vehicle.setVehicleId(id);
                        Driver driver = new Driver(userName, name, family, nationalCode, phoneNumber, age, vehicle);
                        try {

                            driverDataAccess.addDriver(driver);
                        } catch (SQLException e) {
                            System.out.println("can not add driver :" + e.getMessage());
                        }
                    }
                    System.out.println("Your information was successfully registered.");
                }
                break;
                case 2: {
                    System.out.println("Enter number of passenger:");
                    int numberOfPassengers = input.nextInt();
                    for (int i = 0; i < numberOfPassengers; i++) {
                        System.out.println("Enter passengers information: (userName, name, family, nationalCode, phoneNumber,age,userStatus,accountBalance) ");
                        input.nextLine();
                        String line = input.nextLine();
                        String[] lineArray = line.split(",");
                        String userName = lineArray[0];
                        String name = lineArray[1];
                        String family = lineArray[2];
                        String nationalCode = lineArray[3];
                        String phoneNumber = lineArray[4];
                        String strAge = lineArray[5];
                        int age = Integer.parseInt(strAge);
                        String str = lineArray[6];
                        double accountBalance = Double.parseDouble(str);
                        Passenger passenger = new Passenger(userName, name, family, nationalCode, phoneNumber, age, accountBalance);
                        try {
                            passengerDataAccess.addPassenger(passenger);
                        } catch (SQLException e) {
                            System.out.println("can not add passenger :" + e.getMessage());
                        }
                    }
                    System.out.println("Your information was successfully registered.");
                }
                break;
                case 3: {
                    System.out.println("Enter username:");
                    String uName = input.next();
                    Driver driver = driverDataAccess.getDriverByDriverUserName(uName);
                    if (driver == null) {
                        System.out.println("1.Register");
                        System.out.println("2.Exit");
                        int selection2 = input.nextInt();
                        switch (selection2) {
                            case 1: {
                                System.out.println("Enter your information: (userName, name, family, nationalCode, phoneNumber ,age ,nameOfCar ,color, numberOfCar) ");
                                input.nextLine();
                                String line = input.nextLine();
                                String[] lineArray = line.split(",");
                                String userName = lineArray[0];
                                String name = lineArray[1];
                                String family = lineArray[2];
                                String nationalCode = lineArray[3];
                                String phoneNumber = lineArray[4];
                                String strAge = lineArray[5];
                                int age = Integer.parseInt(strAge);
                                String nameOfCar = lineArray[6];
                                String color = lineArray[7];
                                String number = lineArray[8];
                                Vehicle vehicle = new Vehicle(1, nameOfCar, color, number);
                                int id = CarDataAccess.addVehicle(vehicle);
                                vehicle.setVehicleId(id);
                                Driver driv = new Driver(userName, name, family, nationalCode, phoneNumber, age, vehicle);
                                try {
                                    driverDataAccess.addDriver(driv);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Your information was successfully registered.");
                            }
                            break;
                            case 2:
                                break;
                            default:
                                System.out.println("Invalid input!");
                        }
                    } else if (driver.getUserStatus()==driver.getUserStatus().WA){
                        System.out.println("you are waiting for trip");
                        System.out.println("1.Exit");
                        break;
                    } else {
                        System.out.println(driver.getUserStatus());
                        System.out.println("1.Confirmation Receive money");
                        System.out.println("2.Trip Finish");
                        System.out.println("3.Exit");
                    }
                }
                break;
                case 4: {
                    System.out.println("Enter username:");
                    String uNamePass = input.next();
                    Passenger passenger = passengerDataAccess.getPassengerByUserName(uNamePass);

                    if (passenger == null) {
                        System.out.println("1.Register");
                        System.out.println("2.Exit");
                        int selection2 = input.nextInt();
                        switch (selection2) {
                            case 1: {
                                System.out.println("Enter your information: (userName, name, family, nationalCode, phoneNumber, age, accountBalance) ");
                                input.nextLine();
                                String line = input.nextLine();
                                String[] lineArray = line.split(",");
                                String userName = lineArray[0];
                                String name = lineArray[1];
                                String family = lineArray[2];
                                String nationalCode = lineArray[3];
                                String phoneNumber = lineArray[4];
                                String strAge = lineArray[5];
                                int age = Integer.parseInt(strAge);
                                String str1 = lineArray[6];
                                double accountBalance = Double.parseDouble(str1);
                                Passenger pass = new Passenger(userName, name, family, nationalCode, phoneNumber, age, accountBalance);
                                try {
                                    passengerDataAccess.addPassenger(pass);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }

                                System.out.println("Your information was successfully registered.");
                            }
                            break;
                            case 2:
                                break;
                            default:
                                System.out.println("Invalid input!");
                        }
                    } else {
                        menuIncreaseBalance();
                        int selection3 = input.nextInt();
                        switch (selection3) {
                            case 1: {
                                System.out.println("Enter amount in RIAL:");
                                input.nextLine();
                                double increaseAccount = input.nextDouble();
                                passengerDataAccess.updatePassenger(uNamePass, increaseAccount);
                                System.out.println("Your account balance has been updated");
                            }
                            break;

                            case 2:
                                break;
                            default:
                                System.out.println("Invalid input!");
                        }
                    }
                }
                break;
                case 5: {
                    System.out.println(driverDataAccess.getAllDriver());
                }
                break;
                case 6: {
                    System.out.println(passengerDataAccess.getAllPassenger());
                }
                break;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }

    public static void showFirstPage() {
        System.out.println("1.Add a group of drivers");
        System.out.println("2.Add a group of passengers");
        System.out.println("3.Driver signup or login");
        System.out.println("4.Passenger signup or login");
        System.out.println("5.Show a list of drivers");
        System.out.println("6.Show a list of passengers");
    }

    public static void menuIncreaseBalance() {
        System.out.println("1.Increase account balance");
        System.out.println("2.Exit");
    }
}
