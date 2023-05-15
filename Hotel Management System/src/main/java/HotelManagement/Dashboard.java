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

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        JMenuItem addRooms = new JMenuItem("ADD ROOMS");
        addRooms.addActionListener(this);
        admin.add(addRooms);

        JMenuItem addDriver = new JMenuItem("ADD DRIVERS");
        addDriver.addActionListener(this);
        admin.add(addDriver);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        //daca aceasta e actiunea cream o noua instanta a clasei
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms();
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
