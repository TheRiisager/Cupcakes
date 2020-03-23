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

    public static ArrayList<Cupcake> cartLoader(int userID) {

        return OrderMapper.cartLoader(userID);

    }

    public static boolean setIsOrdered(int userID){

        return OrderMapper.setIsOrdered(userID);
    }

}
