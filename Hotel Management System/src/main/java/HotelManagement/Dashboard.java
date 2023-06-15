package HotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    Dashboard()
    {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("src/main/java/images/hotel_background.jpg");
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("THE HOTEL WELCOMES YOU!");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);

        JButton next = new JButton("Login");
        next.setBounds(650, 350, 150, 50);
        next.setBackground(Color.decode("#f5d29a"));
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        new Login();
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
