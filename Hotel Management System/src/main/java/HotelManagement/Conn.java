package HotelManagement;

import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    Conn(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##mdsuser", "password");
            s = c.createStatement();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
