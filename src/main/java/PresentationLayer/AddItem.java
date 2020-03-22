package PresentationLayer;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddItem extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute( "user" );


        String top = request.getParameter( "Cupcaketop" );
        String bottom = request.getParameter( "Cupcakebot" );

        u.addToOrder( new Cupcake( bottom , top ) );

        return "userpage";
    }
}
