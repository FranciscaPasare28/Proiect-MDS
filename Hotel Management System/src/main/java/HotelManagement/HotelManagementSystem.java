package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem(){

        setBounds(150,50,1100,700);
        setLayout(null);

        ImageIcon image_hotel = new ImageIcon("src/main/java/images/hotel.jpg");
        JLabel image = new JLabel(image_hotel);
        image.setBounds(0,0,1100,700);
        add(image);

        JLabel text = new JLabel("Welcome!");
        text.setBounds(100,40,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 70));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(850, 550, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);

        setVisible(true);

    }


    public static void main(String[] args) {
        new HotelManagementSystem();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Dashboard();
    }
}
