package PresentationLayer;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Cart extends Command{


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute( "user" );

        session.setAttribute("userOrderList", u.getUserOrder().getCakes());

        session.setAttribute( "subtotal", u.getUserOrder().getSubtotal() );

        return "cart";
    }
}
