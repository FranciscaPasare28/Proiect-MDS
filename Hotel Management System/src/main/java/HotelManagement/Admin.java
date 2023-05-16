package HotelManagement;


import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class Admin extends JFrame implements ActionListener{
    JButton newCustomer , rooms, department, searchRoom, allEmployee, managerInfo, customers, roomStatus, update;
    JButton addEmployee, addRooms, addDriver;
    Admin() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        addEmployee = new JButton("Add Employee");
        addEmployee.setBounds(10, 30,200, 30);
        addEmployee.setBackground(Color.BLACK);
        addEmployee.setForeground(Color.WHITE);
        addEmployee.addActionListener(this);
        add(addEmployee);

        addRooms = new JButton("Add Rooms");
        addRooms.setBounds(10, 70,200, 30);
        addRooms.setBackground(Color.BLACK);
        addRooms.setForeground(Color.WHITE);
        addRooms.addActionListener(this);
        add(addRooms);

        addDriver = new JButton("Add Driver");
        addDriver.setBounds(10, 110,200, 30);
        addDriver.setBackground(Color.BLACK);
        addDriver.setForeground(Color.WHITE);
        addDriver.addActionListener(this);
        add(addDriver);

        rooms = new JButton("Rooms");
        rooms.setBounds(10, 150,200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);


        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10, 190,200, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);

        department = new JButton("Departments");
        department.setBounds(10, 230,200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10, 270,200, 30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customer Info");
        customers.setBounds(10, 310,200, 30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

        update = new JButton("Update Status Customer");
        update.setBounds(10, 350,200, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        JButton checkout = new JButton("Checkout");
        checkout.setBounds(10, 390,200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);

        JButton logout = new JButton("Logout");
        logout.setBounds(10, 430,200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);

        ImageIcon i1  = new ImageIcon("src/main/java/images/admin.png");
        Image i3 = i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel (i2);
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

        } else if (ae.getSource() == customers) {
            setVisible(false);
            new CustomerInfo();

        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateCheck();

        } else if (ae.getSource() == roomStatus) {
            setVisible(false);
            new UpdateRoom();

        } else if(ae.getSource() == addEmployee){
            setVisible(false);
            new AddEmployee();

        } else if (ae.getSource() == addRooms) {
            setVisible(false);
            new AddRooms();

        }else if(ae.getSource() == addDriver){
            setVisible(false);
            new AddDriver();
        }
    }



    public static void main(String[] args) {
        new Admin();
    }



}
