package taxiSystem.dataAccess;


import taxiSystem.enumeration.Payment;
import taxiSystem.enumeration.TripStatus;
import taxiSystem.model.Trip;
import taxiSystem.model.person.Driver;
import taxiSystem.model.person.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TripDataAccess {
    public int addNewTrip(Trip trip) throws SQLException {
        Connection connection = SqlConnection.getConnection();
        int generatedId = 0;

        if (connection != null) {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into trips (passengerUserName, driverUserName,origin, destination, cost, payment, status) values (?,?,?,?,?,?,?)", 1);
            preparedStatement.setString(1, trip.getPassenger().getUserName());
            preparedStatement.setString(2, trip.getDriver().getUserName());
            preparedStatement.setString(3, trip.getOrigin());
            preparedStatement.setString(4, trip.getDestination());
            preparedStatement.setDouble(5, trip.getCost());
            preparedStatement.setString(6, trip.getPayment().toString().toLowerCase());
            preparedStatement.setString(7, "on_trip");
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            keys.next();
            generatedId = keys.getInt(1);
        } else {
            return 0;
        }
        return generatedId;
    }
    public List<Trip> getAllTrips() throws SQLException {
        Connection connection = SqlConnection.getConnection();

        if (connection != null) {
            List<Trip> trips = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM trips";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Trip trip = new Trip();
                trip.setPassenger(resultSet.getString("passengerUserName"));
                trip.setDriver(resultSet.getString("driverUserName"));
                trip.setOrigin(resultSet.getString("origin"));
                trip.setDestination(resultSet.getString("destination"));
                trip.setCost(resultSet.getDouble("cost"));
                trip.setPayment(Payment.valueOf(resultSet.getString("payment")));
                trip.setTripStatus(TripStatus.valueOf(resultSet.getString("status")));

                trips.add(trip);
            }

            return trips;
        } else {
            return Collections.emptyList();
        }}
        public void updateTripStatus(Trip trip, TripStatus tripStatus) throws SQLException {
            Connection connection = SqlConnection.getConnection();
            if (connection != null) {
                String sql = "UPDATE trips SET status = ? WHERE id = ?;";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, tripStatus.toString().toLowerCase());
                statement.setInt(2, trip.getId());
                statement.executeUpdate();
            }
        }

        public Trip getTripByDriverUserName(int driverUserName) throws SQLException {
            Connection connection = SqlConnection.getConnection();

            Trip trip = null;
            if (connection != null) {
                String sql = "SELECT * FROM trips where status = \"on_trip\" and driverUserName = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, String.valueOf(driverUserName));
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                        trip = new Trip();
                    trip.setPassenger(resultSet.getString("passengerUserName"));
                    trip.setDriver(resultSet.getString("driverUserName"));
                    trip.setOrigin(resultSet.getString("origin"));
                    trip.setDestination(resultSet.getString("destination"));
                    trip.setCost(resultSet.getDouble("cost"));
                    trip.setPayment(Payment.valueOf(resultSet.getString("payment")));
                    trip.setTripStatus(TripStatus.valueOf(resultSet.getString("status")));
                        return trip;

                    }
                }
                return null;

}}



