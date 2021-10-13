package taxiSystem.enumeration;

public enum TypeOfVehicle {
    CAR("car"),
    MOTOR("motor");

    String abbr;

    TypeOfVehicle(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}
