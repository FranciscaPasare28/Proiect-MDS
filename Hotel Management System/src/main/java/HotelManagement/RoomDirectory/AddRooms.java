
package HotelManagement.RoomDirectory;


import HotelManagement.Admin;
import HotelManagement.Conn;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class AddRooms extends JFrame implements ActionListener {

    JButton add,cancel;
    JTextField tfroom, tfprice;
    JComboBox typecombo, availablecombo, cleancombo;

    // Metodă pentru generarea unui ID unic pentru cameră
    private static int generateUniqueId(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public AddRooms() {
        getContentPane().setBackground(Color.decode("#fae5c3"));
        setLayout(null);

        // Eticheta pentru titlul paginii
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        // Eticheta și câmpul de introducere pentru numărul camerei
        JLabel ldlroomno = new JLabel("Room Number");
        ldlroomno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ldlroomno.setBounds(60, 80, 120, 20);
        add(ldlroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);

        // Eticheta și câmpul de introducere pentru preț
        JLabel ldprice = new JLabel("Price");
        ldprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ldprice.setBounds(60, 130, 120, 20);
        add(ldprice);

        tfprice = new JTextField();
        tfprice.setBounds(200, 130, 150, 30);
        add(tfprice);

        // Eticheta și lista derulantă pentru tipul de pat
        JLabel ldtype = new JLabel("Room type");
        ldtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ldtype.setBounds(60, 180, 120, 30);
        add(ldtype);

        String typeOptions[] = {"Single", "Double", "Triple"};
        typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(200, 180, 150, 30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);

        // Butonul pentru adăugarea camerei
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);

        // Butonul pentru anularea adăugării camerei
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.black);
        cancel.setBounds(230, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon("src/main/java/images/room1.png");
        Image i3 = i1.getImage().getScaledInstance(560, 374, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400, 30, 500, 370);
        add(l15);


        setBounds(330, 200, 940, 470);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String roomnumber = tfroom.getText();
//            String availability = "Available";
            String status = "Cleaned";
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();
            int id = generateUniqueId(1, 9999);


            try{
                Conn con = new Conn();
                String str = "INSERT INTO room values( "+id+",'"+roomnumber+ "','"+status+"','"+price+"', '"+type+"')";

                con.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "New Room Added Successfully");

                setVisible(false);
                new Room();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Room();
        }
    }
    public static void main(String[] args) {
        new AddRooms();
    }
}
