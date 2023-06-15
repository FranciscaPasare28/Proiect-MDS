package HotelManagement;
import java.sql.*;

public class Create_table {

    public static void main(String[] args) throws SQLException {
        try {
            Conn connection = new Conn();


            String createEmployee = "CREATE TABLE employee( " +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(25), " +
                    "birth_date VARCHAR(10), " +
                    "gender VARCHAR(15), " +
                    "job VARCHAR(30), " +
                    "salary VARCHAR(15), " +
                    "phone VARCHAR(15), " +
                    "email VARCHAR(40), " +
                    "password varchar(25), " +
                    "insert_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

            String createRoom = "CREATE TABLE room ( " +
                    "id INT PRIMARY KEY, " +
                    "roomnumber varchar(20), " +
                    "cleaning_status VARCHAR(20), " +
                    "price varchar(20), " +
                    "room_type VARCHAR(50))";


            String createCustomer = "create table CUSTOMER(" +
                    "document varchar(20), " +
                    "\"number\" varchar(30) PRIMARY KEY, " +
                    "name varchar(30)," +
                    "country varchar(20), " +
                    "room varchar(10), " +
                    "checkintime varchar(200), " +
                    "checkouttime varchar(200), " +
                    "payment varchar(20), " +
                    "arrived varchar(10))";


            String createOldCustomer = "create table OLD_CUSTOMER(" +
                    "document varchar(20), " +
                    "\"number\" varchar(30) PRIMARY KEY, " +
                    "name varchar(30)," +
                    "country varchar(20), " +
                    "room varchar(10), " +
                    "checkintime varchar(200), " +
                    "checkouttime varchar(200), " +
                    "payment varchar(20), " +
                    "arrived varchar(10))";


            try {

                connection.s.execute("BEGIN\n" +
                        "    EXECUTE IMMEDIATE 'DROP TABLE employee CASCADE CONSTRAINTS';\n" +
                        "EXCEPTION\n" +
                        "    WHEN OTHERS THEN\n" +
                        "        IF SQLCODE != -942 THEN\n" +
                        "            RAISE;\n" +
                        "        END IF;\n" +
                        "END;\n" );
                connection.s.execute(createEmployee);

                connection.s.execute("BEGIN\n" +
                        "    EXECUTE IMMEDIATE 'DROP TABLE room CASCADE CONSTRAINTS';\n" +
                        "EXCEPTION\n" +
                        "    WHEN OTHERS THEN\n" +
                        "        IF SQLCODE != -942 THEN\n" +
                        "            RAISE;\n" +
                        "        END IF;\n" +
                        "END;\n" );
                connection.s.execute(createRoom);

                connection.s.execute("BEGIN\n" +
                        "    EXECUTE IMMEDIATE 'DROP TABLE customer CASCADE CONSTRAINTS';\n" +
                        "EXCEPTION\n" +
                        "    WHEN OTHERS THEN\n" +
                        "        IF SQLCODE != -942 THEN\n" +
                        "            RAISE;\n" +
                        "        END IF;\n" +
                        "END;\n" );
                connection.s.execute(createCustomer);

                connection.s.execute("BEGIN\n" +
                        "    EXECUTE IMMEDIATE 'DROP TABLE old_customer CASCADE CONSTRAINTS';\n" +
                        "EXCEPTION\n" +
                        "    WHEN OTHERS THEN\n" +
                        "        IF SQLCODE != -942 THEN\n" +
                        "            RAISE;\n" +
                        "        END IF;\n" +
                        "END;\n" );
                connection.s.execute(createOldCustomer);


                System.out.println("Table created successfully");

            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}