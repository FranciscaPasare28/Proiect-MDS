package HotelManagement;


import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener{
    JButton newCustomer , rooms, department, searchRoom, allEmployee, managerInfo, customers, roomStatus, update;
    Reception() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);


        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30,200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70,200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton("Department");
        department.setBounds(10, 110,200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10, 150,200, 30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customer Info");
        customers.setBounds(10, 190,200, 30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10, 230,200, 30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);

        JButton checkout = new JButton("Checkout");
        checkout.setBounds(10, 270,200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);

        update = new JButton("Update Status");
        update.setBounds(10, 310,200, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10, 350,200, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);

        JButton pickup = new JButton("Pickup Service");
        pickup.setBounds(10, 390,200, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        add(pickup);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10, 430,200, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);

        JButton logout = new JButton("Logout");
        logout.setBounds(10, 470,200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);

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
            new AddCustomer();

        }else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();

        }else if(ae.getSource() == department){
            setVisible(false);
            new Department();

        } else if (ae.getSource() == allEmployee) {
            setVisible(false);
            new EmployeeInfo();

        } else if (ae.getSource() == managerInfo) {
            setVisible(false);
            new ManagerInfo();

        } else if(ae.getSource() == searchRoom){
            setVisible(false);
            new SearchRoom();

        } else if (ae.getSource() == customers) {
            setVisible(false);
            new CustomerInfo();

        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateCheck();

        } else if (ae.getSource() == roomStatus) {
            setVisible(false);
            new UpdateRoom();

        }
    }



    public static void main(String[] args) {
        new Reception();
    }



}
