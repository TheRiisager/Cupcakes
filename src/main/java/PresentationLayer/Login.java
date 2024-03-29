package PresentationLayer;


import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {

        String email = request.getParameter( "email" );
        String password = request.getParameter( "password1" );
        User user = LogicFacade.login( email, password );
        float balance = LogicFacade.getUserBalance(user.getId());
        String balanceString = String.format("%.2f", balance);
        HttpSession session = request.getSession();

        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
        session.setAttribute("balance", balanceString);

        if( user.getRole().equals("admin") ) {
            session.setAttribute("orderList", LogicFacade.getAllOrders());
        }


        return user.getRole() + "page";
    }

}
