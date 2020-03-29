package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

public class deleteOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int orderID = Integer.parseInt( request.getParameter("orderID") );
        LogicFacade.removeOrder( orderID );

        return "adminpage";
    }
}
