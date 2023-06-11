package HotelManagement.FrontDesk;

import HotelManagement.RoomDirectory.SearchRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Clasa care se ocupa cu operatiile de checkin si checkout
public class Checkin_Checkout extends JFrame implements ActionListener {

    JButton update, back;
    static JPanel checkin, checkout;

    static JScrollPane scrollable, scrollable_checkout;
    static int iteratie = 0;
    public Checkin_Checkout(){
        build();

    }

    void build()
    {
        iteratie++; // vedem la a cata apasare de update suntem

        if(iteratie == 1)
        {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel text = new JLabel("CHECKIN/CHECKOUT");
            text.setBounds(100,20,300,30);
            text.setFont(new Font("Raieway",Font.PLAIN, 20));
            add(text);

            update = new JButton("Update reservation");
            update.setBackground(Color.black);
            update.setForeground(Color.WHITE);
            update.setBounds(400, 20, 160, 30);
            update.addActionListener(this);
            add(update);

            back = new JButton("Back");
            back.setBackground(Color.black);
            back.setForeground(Color.WHITE);
            back.setBounds(600, 20, 160, 30);
            back.addActionListener(this);
            add(back);

            update_panels();
            setBounds(350, 200, 800, 550);      //stilizarea panoului care le cuprinde pe celelalte
            setVisible(true);
        }
        else{
            remove(scrollable);
            remove(scrollable_checkout);
            remove(checkin);
            remove(checkout);

            update_panels();
        }
    }
    void update_panels()
    {
        checkin = new JPanel();                          //panoul de checkin
        checkout = new JPanel();                         // panoul de checkout

        scrollable = new JScrollPane(checkin);          // panou scrollable
        scrollable.setBounds(10, 60, 375, 440);

        checkin.setBounds(10,60,375,440);       //stilizarea panourilor
        checkin.setLayout(new BoxLayout(checkin, BoxLayout.Y_AXIS));

        scrollable_checkout = new JScrollPane(checkout);
        scrollable_checkout.setBounds(400, 60, 375, 440);   // setam dimensiunile panoului scrollable pt checkout

        checkout.setBounds(400,60,375,440);
        checkout.setLayout(new BoxLayout(checkout, BoxLayout.Y_AXIS));


        scrollable_checkout.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  //panoul scrollable are bara verticala
        // Set the scroll policy for the scroll pane
        scrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  // adaugam un panou scrollabil

        scrollable.setViewportView(checkin);
        scrollable_checkout.setViewportView(checkout);      // putem panoul cu checkout in prim plan

        add(scrollable);
        add(scrollable_checkout);


        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##mdsuser", "password");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMER WHERE ARRIVED = 'false'");
            ResultSet rs = ps.executeQuery();       // I-au din baza de date rezervarile care nu au fost rezolvate
            int contor = 1;
            while(rs.next())
            {
                JPanel custom = new JPanel();
                custom.setBounds(10,10,200,30);
                custom.setBackground(Color.WHITE);
                custom.setVisible(true);

                String label = "" + contor + ". " + rs.getString("NAME") + ", Room: " + rs.getString("ROOM") + ".";
                JLabel customer = new JLabel(label);
//                lblroom.setFont(new Font("Raieway",Font.PLAIN, 20));
                customer.setBounds(0,0,100,30);
                customer.setFont(new Font("Raieway",Font.PLAIN, 12));
                custom.add(customer);

                Checkbox checkbox = new Checkbox(rs.getString("number") + " checkin" );
//                checkbox.setBounds(300,100,100,100);
                custom.add(checkbox);
                contor++;

//                checkin.add(custom);            // Generam o cutie cu numele rezervarii si camera, alaturi de un checkbox pt a arata ca clientul a venit
                checkin.add(custom);
            }


            ps = con.prepareStatement("SELECT * FROM CUSTOMER WHERE ARRIVED = 'true'");
            rs = ps.executeQuery();
            contor = 1;
            while(rs.next())            // generam lista de clienti care si-au facut checkin ul
            {
                JPanel custom = new JPanel();
                custom.setBounds(10,10,200,30);
                custom.setBackground(Color.WHITE);
                custom.setVisible(true);

                String label = "" + contor + ". " + rs.getString("NAME") + ", Room: " + rs.getString("ROOM") + ".";
                JLabel customer = new JLabel(label);
//                lblroom.setFont(new Font("Raieway",Font.PLAIN, 20));
                customer.setBounds(0,0,100,30);
                customer.setFont(new Font("Raieway",Font.PLAIN, 12));
                custom.add(customer);

                Checkbox checkbox = new Checkbox(rs.getString("number") + " checkout" );
//                checkbox.setBounds(300,100,100,100);
                custom.add(checkbox);
                contor++;

//                checkin.add(custom);            // Generam o cutie cu numele rezervarii si camera, alaturi de un checkbox pt a arata ca clientul a venit
                checkout.add(custom);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##mdsuser", "password");
            PreparedStatement ps = null;
            ResultSet rs = null;

            if (ae.getSource() == update) {  // in caz de update cautam toate checkbox urile bifate si facem update in baza de date
                Component[] checkin_list = checkin.getComponents();    // dupa care updatam listele
                    for (Component panel : checkin_list) {
                        Component[] checkboxes = ((JPanel) panel).getComponents();
                        for (Component checkbox : checkboxes) {
                            if (checkbox instanceof Checkbox) {
                                Checkbox check = (Checkbox) checkbox;
                                if (check.getState()) {
                                    String label = check.getLabel();
                                    String id = (label.strip().split(" "))[0];

                                    ps = con.prepareStatement("UPDATE CUSTOMER SET ARRIVED = 'true' WHERE \"number\" = '" + id + "'");
                                    ps.executeUpdate();
                                }
                            }
                        }
                }

                Component[] checkout_list = checkout.getComponents();    // dupa care updatam listele
                for (Component panel : checkout_list) {
                    Component[] checkboxes = ((JPanel) panel).getComponents();
                    for (Component checkbox : checkboxes) {
                        if (checkbox instanceof Checkbox) {
                            Checkbox check = (Checkbox) checkbox;
                            if (check.getState()) {
                                String label = check.getLabel();
                                String id = (label.strip().split(" "))[0];
                                       // adaugam clientul in table old_customer si il scoatem din customer
                                ps = con.prepareStatement("INSERT INTO OLD_CUSTOMER SELECT * FROM CUSTOMER WHERE \"number\" = " + id);
                                ps.executeUpdate();
                                ps = con.prepareStatement("DELETE FROM CUSTOMER WHERE \"number\" = " + id);
                                ps.executeUpdate();
                            }
                        }
                    }
                }
                build();

            } else if (ae.getSource() == back) {
                iteratie = 0;
                setVisible(false);
                new Reception();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Checkin_Checkout checkinCheckout = new Checkin_Checkout();
    }
}
