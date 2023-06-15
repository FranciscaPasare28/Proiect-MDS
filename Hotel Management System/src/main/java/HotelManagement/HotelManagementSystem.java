package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    // Instanța singleton
    private static HotelManagementSystem instance;

    // Constructor privat pentru a preveni instantierea directa
    private HotelManagementSystem() {}

    public static HotelManagementSystem getInstance() {
        if (instance == null) {
            // Creează o nouă instanță dacă nu există nicio instanță
            instance = new HotelManagementSystem();
        }
        return instance;
    }

    public void build(){
        // Configurarea JFrame
        setBounds(150, 50, 1100, 700);
        setLayout(null);

        // Adăugarea imaginii hotelului
        ImageIcon image_hotel = new ImageIcon("src/main/java/images/hotel.jpg");
        JLabel image = new JLabel(image_hotel);
        image.setBounds(0, 0, 1100, 700);
        add(image);

        // Adăugarea textului de bun venit
        JLabel text = new JLabel("Welcome!");
        text.setBounds(100, 40, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 70));
        image.add(text);

        // Adăugarea butonului "Next"
        JButton next = new JButton("Next");
        next.setBounds(850, 550, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);
    }

    public static void main(String[] args) {
        // Obține instanța singleton
        HotelManagementSystem hotelManagementSystem = HotelManagementSystem.getInstance();
        hotelManagementSystem.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }
}