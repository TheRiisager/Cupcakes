package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class OrderComplete extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute( "user" );

        u.setUserOrder(new Order(new ArrayList<Cupcake>()));

        // TODO actually check users account balance
        if(true) {
            OrderMapper.setIsOrdered( u.getUserOrder().getId() );
            OrderMapper.setIsPaid( u.getUserOrder().getId() );
            return "ordercomplete";
        } else {
            return "notenoughmoney";
        }
    }
}
