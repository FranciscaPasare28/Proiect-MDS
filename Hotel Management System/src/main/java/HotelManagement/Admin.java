package HotelManagement;


import HotelManagement.CustomerDirectory.DisplayCustomer;
import HotelManagement.CustomerDirectory.UpdateCustomer;
import HotelManagement.EmployeeDirectory.Employee;
import HotelManagement.FrontDesk.Reservation;
import HotelManagement.RoomDirectory.Room;
import HotelManagement.FrontDesk.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Admin extends JFrame implements ActionListener{
    JButton newCustomer, customers, updateCustomer;
    JButton butEmployee, butRooms, butReception, butCleaning;

    public Admin() {
        getContentPane().setBackground(Color.decode("#fae5c3"));
        setLayout(null);

        // Butonul pentru gestionarea angajaților
        butEmployee = new JButton("Employees");
        butEmployee.setBounds(50, 100,200, 30);
        butEmployee.setBackground(Color.BLACK);
        butEmployee.setForeground(Color.WHITE);
        butEmployee.addActionListener(this);
        add(butEmployee);

        // Butonul pentru gestionarea camerelor
        butRooms = new JButton("Rooms");
        butRooms.setBounds(50, 140,200, 30);
        butRooms.setBackground(Color.BLACK);
        butRooms.setForeground(Color.WHITE);
        butRooms.addActionListener(this);
        add(butRooms);

        butReception = new JButton("Reception");
        butReception.setBounds(50, 180,200, 30);
        butReception.setBackground(Color.BLACK);
        butReception.setForeground(Color.WHITE);
        butReception.addActionListener(this);
        add(butReception);


        ImageIcon i1  = new ImageIcon("src/main/java/images/admin.png");
        Image i3 = i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel (i2);
        image.setBounds(250,0,500,400);
        add(image);


        setBounds(350,200,800,450);
        setVisible(true);

    }

    //In functie de apasarea fiecarui buton suntem trimisi in diferite pagini
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == butReception){
            setVisible(false);
            new Reception();

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
