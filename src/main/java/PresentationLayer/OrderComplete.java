package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderComplete extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        // TODO actually check users account balance
        if(true) {
            return "ordercomplete";
        } else {
            return "notenoughmoney";
        }
    }
}
