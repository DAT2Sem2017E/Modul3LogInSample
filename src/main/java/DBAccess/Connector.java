package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {

    //private static final String URL = "jdbc:mysql://46.101.253.149:3306/useradmin";
    private static final String URL = "jdbc:mysql://138.68.103.105:3306/LegoDB?autoReconnect=true";
    private static final String USERNAME = "legoboi";
    private static final String PASSWORD = "lego";

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

}
