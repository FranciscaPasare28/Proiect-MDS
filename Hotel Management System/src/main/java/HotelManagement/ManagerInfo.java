package HotelManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ManagerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    ManagerInfo(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        String[] columnNames = {"Name", "Age", "Gender", "Job", "Salary", "Phone","Email"};
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
            String sql = "SELECT * FROM employee where job = 'Manager'";
            ResultSet rs = c.s.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("NAME");
                String age = rs.getString("AGE");
                String gender = rs.getString("GENDER");
                String job = rs.getString("JOB");
                String salary = rs.getString("SALARY");
                String phone = rs.getString("PHONE");
                String email = rs.getString("EMAIL");
                model.addRow(new Object[]{name, age, gender, job, salary, phone, email});
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
        new Reception();
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
}