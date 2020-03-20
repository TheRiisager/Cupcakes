package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import FunctionLayer.Cupcake;
import java.sql.*;
import java.util.ArrayList;
import FunctionLayer.Bottom;
import FunctionLayer.Top;



public class DBUtil {




    public static ArrayList cartLoader(int userID) {

        ArrayList<Cupcake> cart = new ArrayList<Cupcake>();
        try {


            int orderID = getOrderID(userID);
            Connection con = Connector.connection();
            String SQL = "SELECT caketopID, cakebotID FROM orderscupcakes "
                    + "WHERE orderID=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {


                String topName = getCupCakeTopIDName(rs.getInt("caketopID"));
                String botName = getCupCakeBottomIDName(rs.getInt("cakebotID"));
                cart.add(new Cupcake(botName, topName));
            }


        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return cart;
    }

    public static String getCupCakeTopIDName(int cakeTopID) throws SQLException, ClassNotFoundException {
        Connection con = Connector.connection();
        String SQL = "SELECT cakename FROM cupcaketop "
                + "WHERE caketopID=?";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, cakeTopID);
        ResultSet rs = ps.executeQuery();
        String cupCakeTopName = rs.getString("cakename");

        return cupCakeTopName;
    }

    public static String getCupCakeBottomIDName(int cakeBotID) throws SQLException, ClassNotFoundException {
        Connection con = Connector.connection();
        String SQL = "SELECT cakename FROM cupcakebot "
                + "WHERE cakebotID=?";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, cakeBotID);
        ResultSet rs = ps.executeQuery();
        String cupCakeBottomName = rs.getString("cakename");

        return cupCakeBottomName;
    }

    public static void cupCakeTopLoader() {

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT cakename, price FROM cupcaketop ";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString(1);
                int price = rs.getInt(2);
                Cupcake.addTop(name, new Top(price, name));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void cupCakeBottomLoader() {

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT cakename, price FROM cupcakebot ";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString(1);
                int price = rs.getInt(2);
                Cupcake.addBottom(name, new Bottom(price, name));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    Henter OrderID fra DB hvor isordered = 0
 */
    private static int getOrderID(int userID) throws SQLException, ClassNotFoundException {
        Connection con = Connector.connection();
        String SQL = "SELECT orderID FROM orders "
                + "WHERE userID=? AND isordered=0";

        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt( 1, userID );
        ResultSet rs = ps.executeQuery();
        int orderID = rs.getInt("orderID");

        return orderID;
    }
}
