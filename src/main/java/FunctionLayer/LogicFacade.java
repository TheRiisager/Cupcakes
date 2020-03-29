package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "user");
        UserMapper.createUser( user );
        return user;
    }

    public static float getUserBalance(int userID) {
        return UserMapper.getUserBalance(userID);
    }

    public static void setUserBalance(float balance, int userID){
        UserMapper.setUserBalance(balance, userID);
    }

    public static ArrayList<Cupcake> cartLoader(int userID) {
        return OrderMapper.cartLoader(userID);
    }

    public static boolean setIsOrdered(int userID){
        return OrderMapper.setIsOrdered(userID);
    }

    public static boolean setIsPaid(int userID) {
        return OrderMapper.setIsPaid(userID);
    }

    public static ArrayList<Order> getAllOrders() {
        return OrderMapper.getAllOrders();
    }

    public static void removeOrder(int orderID) {
        OrderMapper.removeOrder(orderID);
    }

}
