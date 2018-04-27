/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rlumh
 */
public class OrderMapperTest {
    
    private static Connection testConnection;
    private static String USER = "fogManager";
    private static String USERPW = "1234";
    private static String DBNAME = "Fog-CarportsDB";
    private static String HOST = "139.59.132.26";
    
    public OrderMapperTest() {
        
    }
    
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
//            try ( Statement stmt = testConnection.createStatement() ) {
//
//                stmt.execute( "drop table if exists user" );
//                stmt.execute( "create table user like userTest" );
//                stmt.execute( "insert into user select * from userTest" );
//            }

        } catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }
    
    @Test
    public void testCon() {
        assertNotNull(testConnection);
    }

//    @Test
//    public void testCreateOrder() throws Exception {
//    }

    @Test
    public void testGetOrders() {
        ArrayList<Order> orders = LogicFacade.getOrders();
        
        assertTrue(orders.size() > 0);
        
        for (int i = 0; i < orders.size()-1; i++) {
            assertTrue(orders.get(i).getId() > orders.get(i+1).getId());
        }
        
    }
    
}
