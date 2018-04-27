package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.requestException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("loginPage", new loginPage());
        commands.put("carportRequestPage", new carportRequestPage());
        commands.put("logout", new logout());
        commands.put("flatRoofPage", new flatRoofPage());
        commands.put("carportRequest", new carportRequest());
        commands.put("raisedRoofPage", new raisedRoofPage());
        commands.put("orderList", new OrderList());
        commands.put("employeePage", new employeePage());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException, requestException;

}
