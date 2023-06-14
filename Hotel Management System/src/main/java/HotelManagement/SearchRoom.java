package HotelManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    JComboBox bedType;
    JCheckBox available;

    public SearchRoom(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);

        bedType = new JComboBox(new String[] {"Single Bed", "Double Bed"});
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available = new JCheckBox("Only show available");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(Color.WHITE);
        add(available);


        String[] columnNames = {"Room Number", "Availability", "Status", "Price", "Bed Type"};
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
        scroll.setBounds(0, 200, 1000, 300);
        add(scroll);

        try {

            Conn c = new Conn();

            String sql = "SELECT * FROM room";

            ResultSet rs = c.s.executeQuery(sql);

            while (rs.next()) {
                String roomNumber = rs.getString("ROOMNUMBER");
                String availability = rs.getString("AVAILABILITY");
                String status = rs.getString("CLEANING_STATUS");
                String price = rs.getString("PRICE");
                String bedType = rs.getString("BED_TYPE");
                model.addRow(new Object[]{roomNumber, availability, status, price, bedType});
            }

            rs.close();
            c.s.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300, 520, 120, 30);
        add(submit);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500, 520, 120, 30);
        add(back);


        setBounds(300,200,1000, 600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            try{
                String query1 = "SELECT * FROM room WHERE BED_TYPE = '" + bedType.getSelectedItem() + "'";
                String query2 = "SELECT * FROM room WHERE BED_TYPE = '" + bedType.getSelectedItem() + "' AND AVAILABILITY = 'Available'";

                Conn c = new Conn();
                ResultSet rs;

                if(available.isSelected()){
                    rs = c.s.executeQuery(query2);
                }
                else{
                    rs = c.s.executeQuery(query1);
                }

                String[] columnNames = {"Room Number", "Availability", "Status", "Price", "Bed Type"};
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
                scroll.setBounds(0, 200, 1000, 300);
                add(scroll);

                while (rs.next()) {
                    String roomNumber = rs.getString("ROOMNUMBER");
                    String availability = rs.getString("AVAILABILITY");
                    String status = rs.getString("CLEANING_STATUS");
                    String price = rs.getString("PRICE");
                    String bedType = rs.getString("BED_TYPE");
                    model.addRow(new Object[]{roomNumber, availability, status, price, bedType});
                }


            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new HotelManagement.FrontDesk.Reception();
        }

    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}

