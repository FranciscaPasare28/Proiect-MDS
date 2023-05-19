package HotelManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class CustomerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    CustomerInfo(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        String[] columnNames = {"Document Type", "Number", "Name", "Gender", "Country", "Room Number","Checkin time","Deposit"};
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
        scroll.setBounds(0, 40, 1000, 400);
        add(scroll);

        try {
            Conn c = new Conn();
            String sql = "SELECT * FROM customer";
            ResultSet rs = c.s.executeQuery(sql);

            while (rs.next()) {
                String documentType = rs.getString("DOCUMENT");
                String number = rs.getString("number");
                String name = rs.getString("NAME");
                String gender = rs.getString("GENDER");
                String country = rs.getString("COUNTRY");
                String room_number = rs.getString("ROOM");
                String checkIn = rs.getString("CHECKINTIME");
                String deposit = rs.getString("DEPOSIT");
                model.addRow(new Object[]{documentType, number, name, gender, country, room_number, checkIn, deposit});
            }

            rs.close();
            c.s.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420, 500, 120, 30);
        add(back);


        setBounds(300,200,1000, 600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Admin();
    }

    public static void main(String[] args) {
        new CustomerInfo();}
}