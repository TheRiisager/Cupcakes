package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class OrderComplete extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute( "user" );

        float subtotal = u.getUserOrder().getSubtotal();
        float userBalance = LogicFacade.getUserBalance(u.getId());


        if(userBalance >= subtotal) {

            LogicFacade.setIsPaid(u.getId());
            LogicFacade.setIsOrdered(u.getId());
            u.setUserOrder(new Order(new ArrayList<Cupcake>()));
            float newBalance = userBalance - subtotal;
            LogicFacade.setUserBalance(newBalance, u.getId());
            session.setAttribute("balance", newBalance);
            return "ordercomplete";
        } else {
            return "notenoughmoney";
        }
    }
}
