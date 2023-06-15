package HotelManagement.CustomerDirectory;

import HotelManagement.Admin;
import HotelManagement.Conn;
import HotelManagement.FrontDesk.Reception;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class DisplayCustomer extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    public DisplayCustomer(){

        getContentPane().setBackground(Color.decode("#fae5c3"));
        setLayout(null);

        // cream tabelul in care vor fi afisate datele despre clienti
        String[] columnNames = {"Document Type", "Number", "Name", "Country", "Room Number","Checkin time","Checkout time","Payment","Arrived"};
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
                String country = rs.getString("COUNTRY");
                String room_number = rs.getString("ROOM");
                String checkIn = rs.getString("CHECKINTIME");
                String checkOut = rs.getString("CHECKOUTTIME");
                String payment = rs.getString("PAYMENT");
                String arrived = rs.getString("ARRIVED");
                model.addRow(new Object[]{documentType, number, name, country, room_number, checkIn, checkOut, payment, arrived});
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


        setBounds(350,100,1000, 600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new DisplayCustomer();}
}