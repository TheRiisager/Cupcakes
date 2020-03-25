package DBAccess;


import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, pass, role, balance) VALUES (?, ?, ?, 0)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT userID, role FROM users "
                    + "WHERE email=? AND pass=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("userID");
                User user = new User(email, password, role);
                user.setId(id);
                user.setUserOrder();

                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static float getUserBalance(int userID) {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT balance FROM users "
                    + "WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            float balance = -1.00f;

            if(rs.next()) {
                balance = rs.getFloat("balance");
            }
            return balance;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }

        return -1.00f;
    }

    public static void setUserBalance(float balance, int userID){

        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE users SET balance = ? WHERE userID = ? ";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setFloat(1, balance);
            ps.setInt(2, userID);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}

