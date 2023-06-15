package HotelManagement.CustomerDirectory;

import HotelManagement.Admin;
import HotelManagement.Conn;
import HotelManagement.FrontDesk.Reception;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class UpdateCustomer extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom, tfname, tfcheckin, tfpaid, tfpending, tfcheckout;
    JComboBox arrived, checkedout;
    JButton check, update, back;
    public UpdateCustomer(){

        getContentPane().setBackground(Color.decode("#fae5c3"));
        setLayout(null);

        // titlul paginii
        JLabel text = new JLabel("Update Customer");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 30);
        text.setForeground(Color.BLUE);
        add(text);

        // id unic customer
        JLabel lblid = new JLabel("Customer id");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        // adaug in choice id-urile persoanelor cazate
        try{
            Conn c = new Conn();
            // afisez crescator id-urile persoanelor cazate
            ResultSet rs = c.s.executeQuery("select \"number\" from CUSTOMER group by \"number\" order by \"number\" asc");
            while(rs.next())
            {
                ccustomer.add(rs.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lbroom = new JLabel("Room id");
        lbroom.setBounds(30, 120, 100, 20);
        add(lbroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        add(tfroom);

        JLabel lbname = new JLabel("Name");
        lbname.setBounds(30, 160, 100, 20);
        add(lbname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);

        JLabel lbcheckin = new JLabel("Checkin Time");
        lbcheckin.setBounds(30, 200, 100, 20);
        add(lbcheckin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 200, 150, 25);
        add(tfcheckin);

        JLabel lbcheckout = new JLabel("Checkout Time");
        lbcheckout.setBounds(30, 240, 100, 20);
        add(lbcheckout);

        tfcheckout = new JTextField();
        tfcheckout.setBounds(200, 240, 150, 25);
        add(tfcheckout);

        JLabel lbarrived = new JLabel("Arrived");
        lbarrived.setBounds(30, 280, 100, 20);
        add(lbarrived);

        arrived = new JComboBox(new String[] {"false", "true"});
        arrived.setBounds(200, 280, 150, 25);
        arrived.setBackground(Color.WHITE);
        add(arrived);


        // butoane
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 390, 100, 30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 390, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 390, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon il = new ImageIcon("src/main/java/images/checkin.png");
        JLabel image = new JLabel(il);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setBounds(300,200,900,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac)
    {
        if (ac.getSource() == check) // afisez datele persoanei selectate
        {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where \"number\" = '" + id + "'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfcheckout.setText(rs.getString("checkouttime"));
                }

            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }else if (ac.getSource() == update)  // updatez datele persoanei selectate
        {
            String id_customer = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String checkout = tfcheckout.getText();
            String arrived = (String) this.arrived.getSelectedItem();


            try{
                Conn c = new Conn();

                float plata = 0;  // pret camera * nr nopti
                float camera_pret = 0;
                String pret_camera = "select price from room where roomnumber = '"+room+"'";
                ResultSet rs = c.s.executeQuery(pret_camera);
                while (rs.next()) {
                    camera_pret = Float.parseFloat(rs.getString("price"));
                }
                long nr_nopti = 0;
                LocalDate in = LocalDate.parse(checkin);
                LocalDate out = LocalDate.parse(checkout);
                long daysDifference = ChronoUnit.DAYS.between(in, out);
                nr_nopti = Math.abs(daysDifference);
                plata = camera_pret * nr_nopti;

                c.s.executeUpdate("update customer set room = '" + room + "', name = '" + name + "', checkintime = '" + checkin +
                        "', checkouttime = '" + checkout + "', arrived = '" + arrived +
                        "', payment = '" + plata +
                        "' where \"number\" = '" + id_customer + "'");

                JOptionPane.showMessageDialog(null, "Data updated successfully!");
                setVisible(false);
                new Reception();

            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new UpdateCustomer();
    }
}
