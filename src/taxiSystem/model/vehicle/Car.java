package taxiSystem.model.vehicle;

import taxiSystem.enumeration.TypeOfVehicle;

public class Car extends Vehicle{

    public Car(String name, String color, String number) {
        super(name, color, number);
        setTypeOfVehicle(TypeOfVehicle.CAR);
    }

    public Car(int id, String name, String color, String number) {
        super(id, name, color, number);
    }

    public Car() {
    }


}
