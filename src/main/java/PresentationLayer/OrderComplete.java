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

        // TODO actually check users account balance
        if(true) {
            boolean nej = LogicFacade.setIsOrdered(u.getId());
            boolean nej2 = LogicFacade.setIsPaid(u.getId());
            u.setUserOrder(new Order(new ArrayList<Cupcake>()));
            return "ordercomplete";
        } else {
            return "notenoughmoney";
        }
    }
}
