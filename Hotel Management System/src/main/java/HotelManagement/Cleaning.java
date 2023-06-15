package HotelManagement;

import HotelManagement.FrontDesk.Reception;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Cleaning extends JFrame implements ActionListener {

    JButton update, back;
    static JPanel dirty, clean;

    static JScrollPane scrollable, scrollable_2;
    static int iteratie = 0;
    public Cleaning(){
        build();
    }

    void build()
    {
        iteratie++; // vedem la a cata apasare de update suntem

        if(iteratie == 1)
        {
            getContentPane().setBackground(Color.decode("#fae5c3"));
            setLayout(null);

            JLabel text = new JLabel("Cleaning status for rooms");
            text.setBounds(100,20,300,30);
            text.setFont(new Font("Raieway",Font.PLAIN, 20));
            add(text);

            JLabel romms_clean = new JLabel("Clean rooms");
            romms_clean.setBounds(550, 60, 160, 30);
            add(romms_clean);

            JLabel romms_dirty = new JLabel("Dirty rooms");
            romms_dirty.setBounds(160, 60, 160, 30);
            add(romms_dirty);

            update = new JButton("Update rooms");
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
            setBounds(350, 200, 800, 600);      //stilizarea panoului care le cuprinde pe celelalte
            setVisible(true);
        }
        else{
            remove(scrollable);
            remove(scrollable_2);
            remove(dirty);
            remove(clean);

            update_panels();
        }
    }
    void update_panels()
    {
        dirty = new JPanel();                          //panoul pt camerele murdare
        clean = new JPanel();                         // panoul de camerele curate

        scrollable = new JScrollPane(dirty);          // panou scrollable pt camerele murdare
        scrollable.setBounds(10, 100, 375, 440);

        dirty.setBounds(10,60,375,440);       //stilizarea panourilor
        dirty.setLayout(new BoxLayout(dirty, BoxLayout.Y_AXIS));
        dirty.setBackground(Color.decode("#f5ead7"));

        scrollable_2 = new JScrollPane(clean);
        scrollable_2.setBounds(400, 100, 375, 440);   // setam dimensiunile panoului scrollable pt camerele curate

        clean.setBounds(400,60,375,440);
        clean.setLayout(new BoxLayout(clean, BoxLayout.Y_AXIS));
        clean.setBackground(Color.decode("#f5ead7"));


        scrollable_2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  //panoul scrollable are bara verticala
        // Set the scroll policy for the scroll pane
        scrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  // adaugam un panou scrollabil

        scrollable.setViewportView(dirty);
        scrollable_2.setViewportView(clean);      // putem panourile in prim plan

        add(scrollable);
        add(scrollable_2);


        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##mdsuser", "password");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM room WHERE CLEANING_STATUS = 'Dirty' order by roomnumber");
            ResultSet rs = ps.executeQuery();       // selectam camerele murdare
            int contor = 1;
            while(rs.next())
            {
                JPanel custom = new JPanel();
                custom.setBounds(10,10,200,30);
                custom.setBackground(Color.decode("#f5ead7"));
                custom.setVisible(true);

                String label = "" + contor + ". Room number: " + rs.getString("ROOMNUMBER") + ".";
                JLabel room = new JLabel(label);
                room.setBounds(0,0,100,30);
                room.setFont(new Font("Raieway",Font.PLAIN, 12));
                room.setForeground(Color.RED);
                custom.add(room);

                Checkbox checkbox = new Checkbox("set cleaned room "+ rs.getString("ROOMNUMBER") );
                custom.add(checkbox);
                contor++;
                // Generam o cutie cu nr camerei, alaturi de un checkbox
                dirty.add(custom);
            }


            ps = con.prepareStatement("SELECT * FROM room WHERE cleaning_status = 'Cleaned' order by roomnumber");
            rs = ps.executeQuery();
            contor = 1;
            while(rs.next())            // generam lista camere curate
            {
                JPanel custom = new JPanel();
                custom.setBounds(10,10,200,30);
                custom.setBackground(Color.decode("#f5ead7"));
                custom.setVisible(true);

                String label = "" + contor + ". Room number: " + rs.getString("ROOMNUMBER") + ".";
                JLabel room = new JLabel(label);
                room.setBounds(0,0,100,30);
                room.setFont(new Font("Raieway",Font.PLAIN, 12));
                room.setForeground(Color.GREEN);
                custom.add(room);

                contor++;
                // Generam o cutie cu numarul camerei, alaturi de un checkbox
                clean.add(custom);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();
            PreparedStatement ps = null;
            ResultSet rs = null;

            if (ae.getSource() == update) {  // in caz de update cautam toate checkbox urile bifate si facem update in baza de date
                Component[] checkin_list = dirty.getComponents();    // dupa care updatam listele
                for (Component panel : checkin_list) {
                    Component[] checkboxes = ((JPanel) panel).getComponents();
                    for (Component checkbox : checkboxes) {
                        if (checkbox instanceof Checkbox) {
                            Checkbox check = (Checkbox) checkbox;
                            if (check.getState()) {
                                String label = check.getLabel();
                                String id = (label.strip().split(" "))[3];

                                con.s.executeQuery("UPDATE room SET cleaning_status='Cleaned' WHERE roomnumber = '" + id + "'");

                            }
                        }
                    }
                }

                build();

            } else if (ae.getSource() == back) {
                iteratie = 0;
                setVisible(false);
//                new Dashboard();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Cleaning();
    }

}
