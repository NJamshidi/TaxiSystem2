package taxiSystem.model.person;

import taxiSystem.enumeration.TypeOfVehicle;
import taxiSystem.model.vehicle.Vehicle;

public class Driver extends Person {

    private Vehicle vehicle;
    private String location;

    public Driver(String userName, String name, String family, String nationalCode, String phoneNumber, int age, Vehicle vehicle, String location) {
        super(userName, name, family, nationalCode, phoneNumber, age);
        this.vehicle = vehicle;
        this.location = location;
    }

    public Driver() {

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Driver{" +
                super.toString() + '\'' +
                ",vehicle" + vehicle +'\'' +
                ", location='" + location +
                '}';
    }


}
