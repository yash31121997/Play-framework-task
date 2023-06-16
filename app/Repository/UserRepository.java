package Repository;

import java.sql.*;
import java.util.List;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.query.Query;
import play.db.Database;
import Model.User;

public class UserRepository {
    private final Database db;

    @Inject
    public UserRepository(Database db) {
        this.db = db;
        createTable();
    }

    private void createTable() {
        try (Connection conn = db.getConnection()) {
            Statement statement = conn.createStatement();
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS users (" +
                            "id SERIAL PRIMARY KEY, " +
                            "email VARCHAR(255)," +
                            "password VARCHAR(255) " +
                            ")"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(User user) {
        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO users (name, address, password, email) VALUES (?, ?, ?, ?)"
            );

            ps.setString(1, user.getName());
            ps.setString(2, user.getAddress());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findByEmail(String email) {
        User user = null;

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM users WHERE email = ?"
            );
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean updatePassword(String id, String newPassword) {
        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET password = ? WHERE id = ?");
            statement.setString(1, newPassword);
            statement.setInt(2, Integer.parseInt(id));
            int updatedRows = statement.executeUpdate();
            return updatedRows > 0;
        } catch (SQLException e) {
            // Handle the exception
            e.printStackTrace();
            return false;
        }
    }
}
