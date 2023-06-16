package database;

import play.mvc.Controller;
import play.mvc.Result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionPool extends Controller {
    public Result index() {
        Connection conn = null;
        try {
            // Register the JDBC driver (if needed)
            Class.forName("org.postgresql.Driver");

            // Establish a connection
            String url = "jdbc:postgresql://localhost/postgres";
            String user = "postgres";
            String password = "1234";
            conn = DriverManager.getConnection(url, user, password);

            // Do something with the connection

            return ok("Success!");
        } catch (SQLException e) {
            // Handle errors
            return internalServerError("Database error");
        } catch (ClassNotFoundException e) {
            // Handle errors
            return internalServerError("Database driver not found");
        } finally {
            // Close the connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // Ignore errors
                }
            }
        }
    }
}

