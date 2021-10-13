package taxiSystem.model.vehicle;

import taxiSystem.enumeration.TypeOfVehicle;

public class Vehicle {
    private int vehicleId;
    private String name;
    private String color;
    private String number;
    private TypeOfVehicle typeOfVehicle;

    public Vehicle(int id, String name, String color, String number,TypeOfVehicle typeOfVehicle) {
        this.vehicleId = id;
        this.name = name;
        this.color = color;
        this.number = number;
        this.typeOfVehicle = typeOfVehicle;
    }

    public Vehicle(String name, String color, String number) {

        this.name = name;
        this.color = color;
        this.number = number; }

    public Vehicle() {

    }

    public TypeOfVehicle getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", number='" + number + '\'' +
                ", typeOfVehicle=" + typeOfVehicle +
                '}';
    }
}

