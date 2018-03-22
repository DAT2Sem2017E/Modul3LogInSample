package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "Login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "help", new Help() );
        commands.put( "order", new  Order() );
        commands.put( "customer", new Customer() );
        commands.put( "employee", new Employee() );
        commands.put( "orders", new Orders() );
        commands.put( "emporders", new EmpOrders() );
        commands.put( "changeStatus", new changeStatus() );
        commands.put( "createOrder", new createOrder() );
        commands.put( "logout", new logout() );
        commands.put( "loginpage", new loginPage() );
        commands.put( "confirmOrder", new confirmOrder() );
        commands.put( "viewPieces", new viewPieces() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
