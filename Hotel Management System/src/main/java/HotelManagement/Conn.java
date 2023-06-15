package HotelManagement;

import java.sql.*;
public class Conn {  // Connection to database

    public Connection c;
    public Statement s;
    public Conn(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##mdsuser", "password");
            s = c.createStatement();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public String getEmailFromDatabase() {
        String email = null;
        try {
            ResultSet rs = s.executeQuery("SELECT email FROM employee ORDER BY insert_date DESC FETCH FIRST 1 ROW ONLY");

            if (rs.next()) {
                email = rs.getString("email");
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return email;
    }
    public static void deleteAllEmployees() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##mdsuser", "password");
            Statement statement = connection.createStatement();

            String sql = "DELETE FROM employee";
            int rowsDeleted = statement.executeUpdate(sql);
            System.out.println("Numărul de înregistrări șterse: " + rowsDeleted);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
