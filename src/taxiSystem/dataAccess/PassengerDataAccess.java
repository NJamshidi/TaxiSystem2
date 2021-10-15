package taxiSystem.dataAccess;

import taxiSystem.enumeration.UserStatus;
import taxiSystem.model.person.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class PassengerDataAccess {
    public int addPassenger(Passenger passenger) throws SQLException {
        Connection connection = SqlConnection.getConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into passengers (PassengerUserName,name,family,nationalCode,phoneNumber,age,userStatus,accountBalance) values (?, ?, ?, ?,? ,?,?,?)");
            preparedStatement.setString(1, passenger.getUserName());
            preparedStatement.setString(2, passenger.getName());
            preparedStatement.setString(3, passenger.getFamily());
            preparedStatement.setString(4, passenger.getNationalCode());
            preparedStatement.setString(5, passenger.getPhoneNumber());
            preparedStatement.setInt(6, passenger.getAge());
            preparedStatement.setString(7, passenger.getUserStatus().toString().toLowerCase());
            preparedStatement.setDouble(8, passenger.getAccountBalance());


            int i = preparedStatement.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }

    public static Passenger getPassengerByUserName(String userName) throws SQLException {
        Connection connection = SqlConnection.getConnection();
        Passenger passenger = null;
        if (connection != null) {

            PreparedStatement statement = connection.prepareStatement("select * from passengers where PassengerUserName = ?");
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                passenger = new Passenger();
                passenger.setUserName(rs.getString("PassengerUserName"));
                passenger.setName(rs.getString("name"));
                passenger.setFamily(rs.getString("family"));
                passenger.setNationalCode(rs.getString("nationalCode"));
                passenger.setPhoneNumber(rs.getString("phoneNumber"));
                passenger.setAge(rs.getInt("age"));
                passenger.setAccountBalance(rs.getDouble("accountBalance"));

            }
        }
        return passenger;
    }


    public int updatePassenger(String username, double accountBalance) throws SQLException {
        Connection connection = SqlConnection.getConnection();
        if (connection != null) {
            String sql = "UPDATE passengers SET accountBalance = accountBalance + ?  WHERE passengerUserName = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setDouble(1, accountBalance);
            preparedStmt.setString(2, username);


            int i = preparedStmt.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }

    public List<Passenger> getAllPassenger() throws SQLException {
        Connection connection = SqlConnection.getConnection();

        if (connection != null) {
            List<Passenger> passengers = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM passengers";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setUserName(resultSet.getString("passengerUserName"));
                passenger.setName(resultSet.getString("name"));
                passenger.setFamily(resultSet.getString("family"));
                passenger.setNationalCode(resultSet.getString("nationalCode"));
                passenger.setPhoneNumber(resultSet.getString("phoneNumber"));
                passenger.setAge(resultSet.getInt("age"));
                passenger.setAccountBalance(resultSet.getDouble("accountBalance"));

                passengers.add(passenger);
            }

            return passengers;
        } else {
            return Collections.emptyList();
        }
    }
    public void updatePassengerStatus(Passenger passenger, UserStatus userStatus) throws SQLException {
        Connection connection = SqlConnection.getConnection();

        if (connection != null) {
            String sql = "UPDATE passengers SET status = ? WHERE PassengerUserName= ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userStatus.toString().toLowerCase());
            statement.setString(2, passenger.getUserName());
            statement.executeUpdate();
        }
    }
}
