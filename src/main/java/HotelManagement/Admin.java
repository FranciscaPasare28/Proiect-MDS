package HotelManagement;


import HotelManagement.EmployeeDirectory.Employee;
import HotelManagement.RoomDirectory.Room;
import HotelManagement.RoomDirectory.DisplayRoom;
import HotelManagement.RoomDirectory.Room;
import HotelManagement.RoomDirectory.UpdateRoom;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Admin extends JFrame implements ActionListener{
    JButton newCustomer , rooms, department, managerInfo, customers, roomStatus, update;
    JButton butEmployee, butRooms;
    public Admin() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        // Butonul pentru gestionarea angajaților
        butEmployee = new JButton("Employees");
        butEmployee.setBounds(10, 30,200, 30);
        butEmployee.setBackground(Color.BLACK);
        butEmployee.setForeground(Color.WHITE);
        butEmployee.addActionListener(this);
        add(butEmployee);

        // Butonul pentru gestionarea camerelor
        butRooms = new JButton("Rooms");
        butRooms.setBounds(10, 70,200, 30);
        butRooms.setBackground(Color.BLACK);
        butRooms.setForeground(Color.WHITE);
        butRooms.addActionListener(this);
        add(butRooms);

        department = new JButton("Departments");
        department.setBounds(10, 230,200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);


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

    //In functie de apasarea fiecarui buton suntem trimisi in diferite pagini
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
            setVisible(false);
            new AddCustomer();

        }else if(ae.getSource() == department){
            setVisible(false);
            new Department();

        }  else if (ae.getSource() == managerInfo) {
            setVisible(false);
            new ManagerInfo();

        } else if (ae.getSource() == customers) {
            setVisible(false);
            new CustomerInfo();

        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateCheck();

        } else if(ae.getSource() == butEmployee){
            setVisible(false);
            new Employee();

        } else if (ae.getSource() == butRooms) {
            setVisible(false);
            new Room();

        }
    }



    public static void main(String[] args) {
        new Admin();
    }



}
