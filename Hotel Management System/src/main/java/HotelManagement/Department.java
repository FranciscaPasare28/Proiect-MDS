package HotelManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Department(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        String[] columnNames = {"Department", "Budget"};
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
        scroll.setBounds(0, 50, 700, 350);
        add(scroll);

        try {
            Conn c = new Conn();

            String sql = "SELECT * FROM department";

            ResultSet rs = c.s.executeQuery(sql);

            while (rs.next()) {
                String department_name = rs.getString("DEPARTMENT");
                String budget = rs.getString("BUDGET");
                model.addRow(new Object[]{department_name, budget});
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
        back.setBounds(280, 400, 120, 30);
        add(back);


        setBounds(400,200,700, 480);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new Department();
    }
}
