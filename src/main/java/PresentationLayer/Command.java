package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "index", new Index() );
        commands.put( "about", new About() );
        commands.put( "products", new Products() );
        commands.put( "contact", new Contact() );
        commands.put( "userregister", new UserRegister() );
        commands.put( "cart", new Cart() );
        commands.put( "addItem", new AddItem() );
        commands.put( "userpage", new Userpage() );
    }

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
