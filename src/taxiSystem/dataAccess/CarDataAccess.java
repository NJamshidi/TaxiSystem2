package taxiSystem.dataAccess;


import taxiSystem.model.person.Driver;
import taxiSystem.model.vehicle.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDataAccess {


    public static int addVehicle(Vehicle vehicle) throws SQLException {
        Connection connection = SqlConnection.getConnection();
        int generatedId = 0;
        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into vehicles (name, color, number) values (?,?,?)", 1);
            //preparedStatement.setString(1, "1");

            preparedStatement.setString(1, vehicle.getName());
            preparedStatement.setString(2, vehicle.getColor());
            preparedStatement.setString(3, vehicle.getNumber());

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            keys.next();
            generatedId = keys.getInt(1);
        } else {
            return 0;
        }
        return generatedId;
    }

    public static Vehicle getVehicleById(int id) {
        Connection connection = SqlConnection.getConnection();
        Vehicle vehicle = new Vehicle();
        if (connection != null) {

            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement("select * from vehicles where vehicleId = ?");
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    vehicle.setName(rs.getString("name"));
                    vehicle.setColor(rs.getString("color"));
                    vehicle.setNumber(rs.getString("number"));
                    vehicle.setVehicleId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return vehicle;
    }

    public static Vehicle getVehicleByDriverUserName(String driverUserName) throws SQLException {
        Connection connection = SqlConnection.getConnection();
        Vehicle vehicle = null;
        if (connection != null) {

            PreparedStatement statement = connection.prepareStatement("select * from vehicles where driverUserName = ?");
            statement.setString(1, driverUserName);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                vehicle = new Vehicle();
                vehicle.setName(rs.getString("name"));
                vehicle.setColor(rs.getString("color"));
                vehicle.setNumber(rs.getString("number"));


            }
        }
        return vehicle;
    }

}
