package taxiSystem.dataAccess;

import java.sql.*;

public class SqlConnection {

    public static Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxiSys",
                    "root", "123asPKb73!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("not connected to DB");

        }
        return connection;
    }
}



