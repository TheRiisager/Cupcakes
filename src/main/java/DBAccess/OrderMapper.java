package DBAccess;
import FunctionLayer.Cupcake;
import java.sql.*;
import java.util.ArrayList;
import FunctionLayer.Bottom;
import FunctionLayer.Top;



public class OrderMapper {

    public static ArrayList<Cupcake> cartLoader(int userID) {

        ArrayList<Cupcake> cart = new ArrayList<Cupcake>();
        try {
            int orderID = getOrderID(userID);

            if(orderID != -1) {
                Connection con = Connector.connection();
                String SQL = "SELECT orderID, caketopID, cakebotID FROM orderscupcakes "
                        + "WHERE orderID=?;";
                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setInt(1, orderID);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String topName = getCupCakeTopIDName(rs.getInt("caketopID"));
                    String botName = getCupCakeBottomIDName(rs.getInt("cakebotID"));
                    cart.add(new Cupcake(botName, topName));
                }

                return cart;

            } else {
                return createCart(userID);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("CartLoader: Something went wrong here. Order might be empty in DB");

            System.out.println(ex);
        }
        return new ArrayList<Cupcake>();
    }

    public static String getCupCakeTopIDName(int cakeTopID) throws SQLException, ClassNotFoundException {
        Connection con = Connector.connection();
        String SQL = "SELECT cakename FROM cupcaketop "
                + "WHERE caketopID=?;";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, cakeTopID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String cupCakeTopName = rs.getString("cakename");

        return cupCakeTopName;
    }

    public static String getCupCakeBottomIDName(int cakeBotID) throws SQLException, ClassNotFoundException {
        Connection con = Connector.connection();
        String SQL = "SELECT cakename FROM cupcakebot "
                + "WHERE cakebotID=?;";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, cakeBotID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String cupCakeBottomName = rs.getString("cakename");

        return cupCakeBottomName;
    }

    public static void cupCakeTopLoader() {

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT cakename, price, caketopID FROM cupcaketop;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString(1);
                float price = rs.getFloat(2);
                int cakeID = rs.getInt(3);
                Cupcake.addTop(name, new Top(price, name, cakeID));
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
            String SQL = "SELECT cakename, price, cakebotID  FROM cupcakebot;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString(1);
                float price = rs.getFloat(2);
                int cakeID = rs.getInt(3);
                Cupcake.addBottom(name, new Bottom(price, name, cakeID));
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
    private static int getOrderID(int userID) {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT orderID, isordered FROM orders "
                    + "WHERE userID = ? AND isordered = 0;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt( 1, userID );
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                int orderID = rs.getInt(1);

                return orderID;
            }
            return -1;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            return -1;
        }

    }

    public static ArrayList createCart(int userID){
        ArrayList<Cupcake> cart = new ArrayList<Cupcake>();

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (userID, subtotal, quantity, isordered, ispaid)"
                    + "VALUES    (?, 0, 0, 0, 0);";

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ps.executeUpdate();

            return cart;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean saveCupcakeToOrder(String top, String bottom, int userID){

        try{
            int orderID = getOrderID(userID);

            Connection con = Connector.connection();
            String SQL = "INSERT INTO orderscupcakes (orderID, caketopID, cakebotID, price)"
                    + "VALUES    (?, ?, ?, ?);";

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderID);
            ps.setInt(2, Cupcake.getTopCakeID(top));
            ps.setInt(3, Cupcake.getBottomCakeID(bottom));
            ps.setFloat( 4, Cupcake.getBottoms().get(bottom).getPrice() + Cupcake.getTops().get(top).getPrice() );
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean setIsOrdered(int userID){

        try{
            int orderID = getOrderID(userID);
            Connection con = Connector.connection();
            String SQL = "UPDATE orders "
                    + "SET isordered = 1 "
                    + "Where orderID = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderID);
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }



    }

    public static boolean setIsPaid(int userID){

        try{
            int orderID = getOrderID(userID);
            Connection con = Connector.connection();
            String SQL = "UPDATE orders "
                    + "SET ispaid = 1 "
                    + "Where orderID = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderID);
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }



    }












}
