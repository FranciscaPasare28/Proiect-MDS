package HotelManagement.FrontDesk;


import HotelManagement.FrontDesk.SearchRoom;
import HotelManagement.CustomerDirectory.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener{
    JButton newCustomer , rooms, searchRoom, cleaning, checkInOut, updateCustomer, customerInfo;
    public Reception() {
        getContentPane().setBackground(Color.decode("#FFE0BA"));
        setLayout(null);


        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(20, 110,200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(20, 150,200, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);

        cleaning = new JButton("Cleaning request");
        cleaning.setBounds(20, 190,200, 30);
        cleaning.setBackground(Color.BLACK);
        cleaning.setForeground(Color.WHITE);
        cleaning.addActionListener(this);
        add(cleaning);

        checkInOut = new JButton("CheckIn-CheckOut");
        checkInOut.setBounds(20, 230,200, 30);
        checkInOut.setBackground(Color.BLACK);
        checkInOut.setForeground(Color.WHITE);
        checkInOut.addActionListener(this);
        add(checkInOut);

        updateCustomer = new JButton("Update Customer");
        updateCustomer.setBounds(20, 270,200, 30);
        updateCustomer.setBackground(Color.BLACK);
        updateCustomer.setForeground(Color.WHITE);
        updateCustomer.addActionListener(this);
        add(updateCustomer);

        customerInfo = new JButton("Customer Info");
        customerInfo.setBounds(20, 310,200, 30);
        customerInfo.setBackground(Color.BLACK);
        customerInfo.setForeground(Color.WHITE);
        customerInfo.addActionListener(this);
        add(customerInfo);

        ImageIcon i1  = new ImageIcon("src/main/java/images/reception.png");
        JLabel image = new JLabel (i1);
        image.setBounds(250,30,500,470);
        add(image);


        setBounds(350,100,800,570);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
            setVisible(false);
            new Reservation();

        } else if (ae.getSource() == cleaning) {
            setVisible(false);
            new CleaningService();

        } else if(ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();

        } else if(ae.getSource() == checkInOut) {
            setVisible(false);
            new Checkin_Checkout();

        } else if (ae.getSource() == updateCustomer) {
            setVisible(false);
            new UpdateCustomer();

        } else if (ae.getSource() == customerInfo) {
            setVisible(false);
            new DisplayCustomer();

        }
    }

    public static void main(String[] args) {
        new Reception();
    }

}
