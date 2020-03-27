package DBAccess;
import FunctionLayer.Cupcake;
import java.sql.*;
import java.util.ArrayList;
import FunctionLayer.Bottom;
import FunctionLayer.Order;
import FunctionLayer.Top;


/**
 *  Gets and sends order related data to or from our database.
 */
public class OrderMapper {

    /**
     *A method to retrieve the contents of a users latest unfinished order (their cart).
     *
     *
     * @param userID The ID of the user whose cart you want to fetch.
     * @return An Arraylist of cupcakes from the latest order belonging to the supplied userID.
     */
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


    /**
     *  A method for fetching the name of a topping from its database ID.
     *
     * @param cakeTopID The ID of the topping.
     * @return A String with the name belonging to the specified caketopID
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * A method for fetching the name of a topping from its database ID.
     *
     * @param cakeBotID The ID of the Bottom
     * @return A String with the name belonging to the specified cakebotID
     * @throws SQLException
     * @throws ClassNotFoundException
     */

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


    /**
     * A method for loading all cupcake tops into a static hashmap in the Cupcake class.
     */
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

    /**
     * A method for loading all cupcake bottoms into a static hashmap in the Cupcake class.
     */
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

    /**
     * Retrieves the orderID from a users latest unordered order.
     *
     * @param userID The ID of the user whose order you want to fetch.
     * @return
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

    /**
     * Makes a new order in the database, and returns an empty Arraylist.
     *
     * @param userID The user you wish to give a new order.
     * @return An empty Arraylist of Cupcake objects.
     */
    public static ArrayList createCart(int userID){
        ArrayList<Cupcake> cart = new ArrayList<Cupcake>();

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (userID, isordered, ispaid)"
                    + "VALUES    (?, 0, 0);";

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

    /**
     * Saves a cupcake to an order in the database.
     *
     * @param top The name of the cupcakes topping.
     * @param bottom The name of the cupcakes bottom.
     * @param userID The user that the order belongs to.
     * @return True if the method completes without error, false if an exception occurs.
     */
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

    /**
     * Marks a users latest incomplete order as ordered.
     *
     * @param userID The user whose order you wish to complete.
     * @return True if the method succeeds, false if an exception occurs.
     */
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

    /**
     * Marks a users latest incomplete order as paid.
     *
     * @param userID the user whose order you wish to complete.
     * @return True if the method succeeds, false if an exception occurs.
     */
    public static boolean setIsPaid(int userID){

        try{
            int orderID = getOrderID(userID);
            Connection con = Connector.connection();
            String SQL = "UPDATE orders " +
                         "SET ispaid = 1 " +
                         "Where orderID = ?;";
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

    /**
     * Fetches all orders from the database, for admin use only.
     *
     * @return Arraylist containing orders.
     */
    public static ArrayList<Order> getAllOrders() {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Order> orders = new ArrayList<>();

            while( rs.next() ) {

                int orderID = rs.getInt("orderID");

                String SQL2 = "SELECT * FROM orderscupcakes WHERE orderID =?;";
                PreparedStatement ps2 = con.prepareStatement(SQL2);
                ps2.setInt(1, orderID);
                ResultSet rs2 = ps2.executeQuery();

                ArrayList<Cupcake> cupcakes = new ArrayList<>();

                while( rs2.next() ) {
                    String top = getCupCakeTopIDName( rs2.getInt("caketopID") );
                    String bot = getCupCakeBottomIDName( rs2.getInt("cakebotID") );

                    cupcakes.add( new Cupcake( bot , top ) );
                }
                Order o = new Order(cupcakes);
                o.setId(orderID);
                orders.add( o );

            }

            return orders;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
