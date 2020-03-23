package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class OrderCompleteNoPay extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute( "user" );

        u.setUserOrder(new Order(new ArrayList<Cupcake>()));
        LogicFacade.setIsOrdered(u.getId());
        return "ordercomplete";
    }
}
