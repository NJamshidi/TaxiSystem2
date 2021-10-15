package taxiSystem.dataAccess;

import taxiSystem.enumeration.UserStatus;
import taxiSystem.model.person.Driver;
import taxiSystem.model.vehicle.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverDataAccess {

    public int addDriver(Driver driver) throws SQLException {
        Connection connection = SqlConnection.getConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into drivers (driverUserName, name, family, nationalCode, phoneNumber, age, vehicleId,status,location) values ( ?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, driver.getUserName());
            preparedStatement.setString(2, driver.getName());
            preparedStatement.setString(3, driver.getFamily());
            preparedStatement.setString(4, driver.getNationalCode());
            preparedStatement.setString(5, driver.getPhoneNumber());
            preparedStatement.setInt(6, driver.getAge());
            preparedStatement.setInt(7, driver.getVehicle().getVehicleId());
            preparedStatement.setString(8, driver.getUserStatus().toString());
            preparedStatement.setString(9, driver.getLocation().toString());


            int i = preparedStatement.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }

    public List<Driver> getAllDriver() throws SQLException {
        Connection connection = SqlConnection.getConnection();

        if (connection != null) {
            List<Driver> drivers = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM drivers";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            Driver driver = null;
            Vehicle vehicle = null;
            while (resultSet.next()) {
                driver = new Driver();
                driver.setUserName(resultSet.getString("driverUserName"));
                driver.setName(resultSet.getString("name"));
                driver.setFamily(resultSet.getString("family"));
                driver.setNationalCode(resultSet.getString("nationalCode"));
                driver.setPhoneNumber(resultSet.getString("phoneNumber"));
                driver.setAge(resultSet.getInt("age"));
                int vehicleId = resultSet.getInt("vehicleId");
                driver.getUserStatus().toString();
                driver.setLocation(resultSet.getString("location"));

                vehicle = CarDataAccess.getVehicleById(vehicleId);
                driver.setVehicle(vehicle);
                drivers.add(driver);
            }
            return drivers;
        } else {
            return Collections.emptyList();
        }
    }

    public Driver getDriverByDriverUserName(String driverUserName) throws SQLException {
        Connection connection = SqlConnection.getConnection();
        Driver driv = null;
        Vehicle vehicle = null;
        if (connection != null) {

            PreparedStatement statement = connection.prepareStatement("select * from drivers where driverUserName = ?");
            statement.setString(1, driverUserName);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                driv = new Driver();
                driv.setUserName(rs.getString("driverUserName"));
                driv.setName(rs.getString("name"));
                driv.setFamily(rs.getString("family"));
                driv.setNationalCode(rs.getString("nationalCode"));
                driv.setPhoneNumber(rs.getString("phoneNumber"));
                driv.setAge(rs.getInt("age"));
                int vehicleId = rs.getInt("vehicleId");
                vehicle = CarDataAccess.getVehicleById(vehicleId);
                driv.setVehicle(vehicle);
                return driv;

            }
        }
        return null;
    }
    public  void updateDriverStatus(Driver driver, UserStatus userStatus) throws SQLException {
        Connection connection = SqlConnection.getConnection();
        if (connection != null) {
            String sql = "UPDATE drivers SET status = ? WHERE driverUserName = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userStatus.toString().toLowerCase());
            statement.setString(2, driver.getUserName());
            statement.executeUpdate();
        }
    }
    public void updateDriverLocation(Driver driver, String location) throws SQLException {
        Connection connection = SqlConnection.getConnection();
        if (connection != null) {
            String sql = "UPDATE drivers SET location = ? WHERE driverUserName = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, location);
            statement.setString(2, driver.getUserName());
            statement.executeUpdate();
        }
    }

}
