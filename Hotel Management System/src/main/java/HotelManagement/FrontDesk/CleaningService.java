package HotelManagement.FrontDesk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CleaningService extends JFrame implements ActionListener {

    JTextField roomInput;
    JButton done, back;
    public CleaningService()  // daca clientul vrea curatenie in camera in timpul sejurului
    {
        getContentPane().setBackground(Color.decode("#fae5c3"));
        setLayout(null);

        JLabel room = new JLabel("Room to be cleaned: ");
        room.setBounds(20, 30, 190, 20);
        room.setFont(new Font("Raieway",Font.PLAIN, 20));
        add(room);

        roomInput= new JTextField();
        roomInput.setBounds(230,30,75,25);
        add(roomInput);

        done = new JButton("Done");
        done.setBounds(340, 30,100, 30);
        done.setBackground(Color.BLACK);
        done.setForeground(Color.WHITE);
        done.addActionListener(this);
        add(done);

        back = new JButton("Back");
        back.setBounds(470, 30,100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(400, 300, 600, 150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == done){
            String room = roomInput.getText();
            try {
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##mdsuser", "password");
                PreparedStatement ps = con.prepareStatement("UPDATE ROOM SET CLEANING_STATUS = 'Dirty' WHERE ROOMNUMBER = '"+ room + "' ");
                ps.executeUpdate();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            setVisible(false);
            new Reception();

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new CleaningService();
    }
}
