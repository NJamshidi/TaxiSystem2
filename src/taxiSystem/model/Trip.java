package taxiSystem.model;

import taxiSystem.enumeration.Payment;
import taxiSystem.enumeration.TripStatus;
import taxiSystem.model.person.Driver;
import taxiSystem.model.person.Passenger;

public class Trip {
    private int id;
    private Passenger passenger;
    private Driver driver;
    private String origin;
    private String destination;
    private double cost;
    private Payment payment;
    private TripStatus tripStatus;

    public Trip(int id, Passenger passenger, Driver driver, String origin, String destination, double cost, Payment payment, TripStatus tripStatus) {
        this.id = id;
        this.passenger = passenger;
        this.driver = driver;
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
        this.payment = payment;
        this.tripStatus = tripStatus;
    }
    public Trip(int id, Passenger passenger, String origin, String destination, double cost, Payment payment) {
        this.id = id;
        this.passenger = passenger;
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", driver=" + driver +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", cost=" + cost +
                ", payment=" + payment +
                ", tripStatus=" + tripStatus +
                '}';
    }
}
