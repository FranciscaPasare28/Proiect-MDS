package HotelManagement.EmployeeDirectory;

import HotelManagement.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Employee extends JFrame implements ActionListener {
    JButton addEmployee, deleteEmployee, displayEmployee, updateEmployee, back;

    public Employee(){
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        // Butonul pentru adăugarea unui angajat
        addEmployee = new JButton("Add employee");
        addEmployee.setBounds(10, 30,200, 30);
        addEmployee.setBackground(Color.BLACK);
        addEmployee.setForeground(Color.WHITE);
        addEmployee.addActionListener(this);
        add(addEmployee);

        // Butonul pentru ștergerea unui angajat
        deleteEmployee = new JButton("Delete employee");
        deleteEmployee.setBounds(10, 70,200, 30);
        deleteEmployee.setBackground(Color.BLACK);
        deleteEmployee.setForeground(Color.WHITE);
        deleteEmployee.addActionListener(this);
        add(deleteEmployee);

        // Butonul pentru afișarea tuturor angajaților
        displayEmployee = new JButton("All employees");
        displayEmployee.setBounds(10, 110,200, 30);
        displayEmployee.setBackground(Color.BLACK);
        displayEmployee.setForeground(Color.WHITE);
        displayEmployee.addActionListener(this);
        add(displayEmployee);

        // Butonul pentru actualizarea unui angajat
        updateEmployee = new JButton("Update employee");
        updateEmployee.setBounds(10, 150,200, 30);
        updateEmployee.setBackground(Color.BLACK);
        updateEmployee.setForeground(Color.WHITE);
        updateEmployee.addActionListener(this);
        add(updateEmployee);

        // Butonul pentru revenirea la pagina de administrare
        back = new JButton("Back");
        back.setBounds(10, 430,200, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(350,200,800,570);
        setVisible(true);
    }

    //In functie de apasarea fiecarui buton suntem trimisi in diferite pagini
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addEmployee){
            setVisible(false);
            new AddEmployee();
        }else if(ae.getSource() == deleteEmployee){
            setVisible(false);
            new DeleteEmployee();
        }else if(ae.getSource() == displayEmployee){
            setVisible(false);
            new DisplayEmployee();
        }else if(ae.getSource() == updateEmployee){
            setVisible(false);
            new UpdateEmployee();
        }else if(ae.getSource() == back){
            setVisible(false);
            new Admin();
        }
    }

        public static void main(String[] args) {
        new Employee();
    }
}
