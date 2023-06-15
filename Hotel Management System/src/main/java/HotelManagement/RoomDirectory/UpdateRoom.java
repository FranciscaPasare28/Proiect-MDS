package HotelManagement.RoomDirectory;

import HotelManagement.Conn;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener {

    private JTextField tfId, tfroom, tfPrice;
    private JButton updateButton, cancelButton;
    private JComboBox<String> availablecombo, cleancombo, typecombo;


    public UpdateRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Titlu
        JLabel heading = new JLabel("Update Room");
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        // Etichetă și câmp pentru ID-ul camerei
        JLabel lblId = new JLabel("Room ID");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblId.setBounds(60, 80, 120, 20);
        add(lblId);

        tfId = new JTextField();
        tfId.setBounds(200, 80, 150, 30);
        add(tfId);

        // Etichetă și combobox pentru tipul de pat
        JLabel ldtype = new JLabel("Room type");
        ldtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ldtype.setBounds(60, 130, 120, 30);
        add(ldtype);

        String typeOptions[] = {"Single", "Double", "Triple"};
        typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(200, 130, 150, 30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);


        // Etichetă și combobox pentru statusul de curățenie
        JLabel lblClean = new JLabel("Cleaning Status");
        lblClean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblClean.setBounds(60, 230, 120, 30);
        add(lblClean);

        String[] cleanOptions = {"Cleaned", "Dirty"};
        cleancombo = new JComboBox<>(cleanOptions);
        cleancombo.setBounds(200, 230, 150, 30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        // Etichetă și câmp pentru preț
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPrice.setBounds(60, 280, 120, 20);
        add(lblPrice);

        tfPrice = new JTextField();
        tfPrice.setBounds(200, 280, 150, 30);
        add(tfPrice);

        // Etichetă și câmp pentru numărul camerei
        JLabel ldlroomno = new JLabel("Room Number");
        ldlroomno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ldlroomno.setBounds(60, 330, 120, 20);
        add(ldlroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200, 330, 150, 30);
        add(tfroom);

        // Butonul pentru actualizarea camerei
        updateButton = new JButton("Update Room");
        updateButton.setForeground(Color.WHITE);
        updateButton.setBackground(Color.BLACK);
        updateButton.setBounds(60, 380, 130, 30);
        updateButton.addActionListener(this);
        add(updateButton);

        // Butonul pentru actualizarea camerei
        cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setBounds(230, 380, 130, 30);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setBounds(330, 250, 470, 450);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateButton) {
            // Obținerea valorilor introduse de utilizator
            String roomnumber = tfroom.getText();
            String roomId = tfId.getText();
            String bedType = (String) typecombo.getSelectedItem();
            String cleaningStatus = (String) cleancombo.getSelectedItem();
            String price = tfPrice.getText();

            try {
                // Actualizarea în baza de date
                Conn con = new Conn();
                String query = "UPDATE room SET roomnumber ='" +roomnumber+ "' ,  room_type = '" + bedType + "', cleaning_status = '" + cleaningStatus + "', price = '" + price + "' WHERE id = " + roomId;
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Room Updated Successfully");

                setVisible(false);
                new Room();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to update room. Please try again.");
            }
        } else if (ae.getSource() == cancelButton) {
            setVisible(false);
            new Room();
        }
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
