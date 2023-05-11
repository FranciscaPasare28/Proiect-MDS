package HotelManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Room extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Room(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        ImageIcon i1 = new ImageIcon("src/main/java/images/double_room2.jpg");
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);


        String[] columnNames = {"Room Number", "Availability", "Status", "Price", "Bed Type"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(10, 40, 480, 400);
        add(scroll);

        try {
            // Establishing a connection to the database
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "password");
//            Statement stmt = con.createStatement();

            // modificare cod generat de chat gpt
            Conn c = new Conn();

            // Query to retrieve all rows from the room table
            String sql = "SELECT * FROM room";

            // Executing the query and storing the result in a ResultSet object
            ResultSet rs = c.s.executeQuery(sql);  // stmt.executeQuery(sql);

            // Iterating through the ResultSet and adding each row to the table model
            while (rs.next()) {
                String roomNumber = rs.getString("ROOMNUMBER");
                String availability = rs.getString("AVAILABILITY");
                String status = rs.getString("CLEANING_STATUS");
                String price = rs.getString("PRICE");
                String bedType = rs.getString("BED_TYPE");
                model.addRow(new Object[]{roomNumber, availability, status, price, bedType});
            }

            // Closing the connection and statement objects
            rs.close();
            c.s.close();  // stmt.close();
                          // con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200, 500, 120, 30);
        add(back);


        setBounds(300,200,1050, 600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new Room();
    }
}


// cod gresit ce a fost inlocuit cu cel generat de chat gpt


//        table = new JTable();
//                table.setBounds(0, 40, 500, 400);
//
//
//                try {
//                Conn c = new Conn();
//                ResultSet rs = c.s.executeQuery("select * from room");
//                // afisare a rezultatelor interogarii in tabel
////             table.setModel(DbUtils.resultSetToTableModel(rs));
//
//                String[] columnNames = {"Room number", "Availability", "Status", "Price", "Bed Type"};
//                DefaultTableModel model = new DefaultTableModel();
//                model.setColumnIdentifiers(columnNames);
//
//                table = new JTable();
//                table.setModel(model);
//                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//                table.setFillsViewportHeight(true);
//                JScrollPane scroll = new JScrollPane(table);
//                scroll.setHorizontalScrollBarPolicy(
//                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//                scroll.setVerticalScrollBarPolicy(
//                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//
//                if (rs.next()) {
//                String RoomNumber = rs.getString("ROOMNUMBER");
//                String Availability = rs.getString("AVAILABILITY");
//                String Status = rs.getString("CLEANING_STATUS");
//                String Price = rs.getString("PRICE");
//                String BedType = rs.getString("BED_TYPE");
//                model.addRow(new Object[]{RoomNumber, Availability, Status, Price, BedType});
//                }
//                }
//                catch (Exception e) {
//                e.printStackTrace();
//                }
//
//                add(table);