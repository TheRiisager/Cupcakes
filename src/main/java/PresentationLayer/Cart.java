package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Cart extends Command{


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        User u;

        try {
             u = (User) session.getAttribute("user");
        } catch (Exception e) {
            System.out.println(e);
            return "index";
        }
        session.setAttribute("userOrderList", u.getUserOrder().getCakes());



        return "cart";
    }
}
