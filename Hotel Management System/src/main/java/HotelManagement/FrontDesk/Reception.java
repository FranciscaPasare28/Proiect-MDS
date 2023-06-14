package HotelManagement.FrontDesk;


import HotelManagement.SearchRoom;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener{
    JButton newCustomer , rooms, searchRoom, cleaningService, checkout;
    public Reception() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);


        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30,200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10, 70,200, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);

//        JButton pickup = new JButton("Pickup Service");
//        pickup.setBounds(10, 110,200, 30);
//        pickup.setBackground(Color.BLACK);
//        pickup.setForeground(Color.WHITE);
//        add(pickup);
//
//        managerInfo = new JButton("Manager Info");
//        managerInfo.setBounds(10, 150,200, 30);
//        managerInfo.setBackground(Color.BLACK);
//        managerInfo.setForeground(Color.WHITE);
//        managerInfo.addActionListener(this);
//        add(managerInfo);

        checkout = new JButton("Checkin/Checkout");
        checkout.setBounds(10, 110,200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        cleaningService = new JButton("Cleaning Service");
        cleaningService.setBounds(10, 150,200, 30);
        cleaningService.setBackground(Color.BLACK);
        cleaningService.setForeground(Color.WHITE);
        cleaningService.addActionListener(this);
        add(cleaningService);

        ImageIcon i1  = new ImageIcon("src/main/java/images/reception.png");
        JLabel image = new JLabel (i1);
        image.setBounds(250,30,500,470);
        add(image);


        setBounds(350,200,800,570);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
            setVisible(false);
            new Reservation();

        } else if (ae.getSource() == cleaningService) {
            setVisible(false);
            new CleaningService();

        } else if(ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();

        } else if(ae.getSource() == checkout)
        {
            setVisible(false);
            new Checkin_Checkout();
        }
    }



    public static void main(String[] args) {
        new Reception();
    }



}
