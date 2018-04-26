/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UserMapperTest {
//    Test date in the UsersTest table
//    INSERT INTO `UsersTest` VALUES 
//    (1,'jens@somewhere.com','jensen','customer'),
//    (2,'ken@somewhere.com','kensen','customer'),
//    (3,'robin@somewhere.com','batman','employee'),
//    (4,'someone@nowhere.com','sesam','customer');

    private static Connection testConnection;
<<<<<<< HEAD
    private static String USER = "testinguser";
    private static String USERPW = "try1try2tryAgain";
    private static String DBNAME = "useradminTest";
    private static String HOST = "46.101.253.149";
=======
    private static String USER = "fogManager";
    private static String USERPW = "1234";
    private static String DBNAME = "fog_testDB";
    private static String HOST = "139.59.132.26";
>>>>>>> dev

    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if ( testConnection == null ) {
                String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
                Class.forName( "com.mysql.jdbc.Driver" );

                testConnection = DriverManager.getConnection( url, USER, USERPW );
                // Make mappers use test 
                Connector.setConnection( testConnection );
            }
            // reset test database
            try ( Statement stmt = testConnection.createStatement() ) {
<<<<<<< HEAD
                stmt.execute( "drop table if exists Users" );
                stmt.execute( "create table Users like UsersTest" );
                stmt.execute( "insert into Users select * from UsersTest" );
=======
                stmt.execute( "drop table if exists user" );
                stmt.execute( "create table user like userTest" );
                stmt.execute( "insert into user select * from userTest" );
>>>>>>> dev
            }

        } catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
    }

<<<<<<< HEAD
//    @Test
//    public void testLogin01() throws LoginSampleException {
//        // Can we log in
//        User user = UserMapper.login( "jens@somewhere.com", "jensen" );
//        assertTrue( user != null );
//    }
=======
    @Test
    public void testLogin01() throws LoginSampleException {
        // Can we log in
        User user = UserMapper.login( "jens@somewhere.com", "jensen");
        assertTrue( user != null );
    }
>>>>>>> dev

    @Test( expected = LoginSampleException.class )
    public void testLogin02() throws LoginSampleException {
        // We should get an exception if we use the wrong password
<<<<<<< HEAD
        User user = UserMapper.login( "jens@somewhere.com", "larsen" );
    }

//    @Test
//    public void testLogin03() throws LoginSampleException {
//        // Jens is supposed to be a customer
//        User user = UserMapper.login( "jens@somewhere.com", "jensen" );
//        assertEquals( "customer", user.getRole() );
//    }

//    @Test
//    public void testCreateUser01() throws LoginSampleException {
//        // Can we create a new user - Notice, if login fails, this will fail
//        // but so would login01, so this is OK
//        User original = new User( "king@kong.com", "uhahvorhemmeligt", "konge" );
//        UserMapper.createUser( original );
//        User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
//        assertEquals( "konge", retrieved.getRole() );
//    }
=======
        User user = UserMapper.login( "jens@somewhere.com", "larsen");
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // Jens is supposed to be a customer
        User user = UserMapper.login( "jens@somewhere.com", "jensen" );
        assertEquals( "customer", user.getRole() );
    }

    @Test
    public void testCreateUser01() throws LoginSampleException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User( "king@kong.com", "uhahvorhemmeligt", "konge", "kong island", "king kong", 12345678);
        UserMapper.createUser( original );
        //User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
        //assertEquals( "konge", retrieved.getRole() );
    }
>>>>>>> dev
}
