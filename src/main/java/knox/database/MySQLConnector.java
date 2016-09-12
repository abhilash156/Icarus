package knox.database;


import java.sql.*;

public class MySQLConnector {
    private String address;
    private String port;
    private String database;
    private String username;
    private String password;
    private Connection connection = null;

    public MySQLConnector(String address, String port, String database, String username, String password) {
        this.address = address;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + address + ":" + port + "/" + database +
                                "?useSSL=false", username, password);
            } catch (SQLException e) {
                System.out.println("Error Occurred in getConnection(): + " + e.getMessage());
            }
        }
        return connection;
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = getConnection().createStatement();
            if(statement.execute(query)) {
                return statement.getResultSet();
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error Occurred in executeQuery(): + " + e.getMessage());
            return null;
        }
    }
}
