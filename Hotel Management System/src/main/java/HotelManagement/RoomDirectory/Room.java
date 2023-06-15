package HotelManagement.RoomDirectory;

import HotelManagement.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Room extends JFrame implements ActionListener {
    JButton addRoom, displayRoom, updateRoom, back;

    public Room(){
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        // Buton pentru adăugarea unei camere
        addRoom = new JButton("Add room");
        addRoom.setBounds(10, 30,200, 30);
        addRoom.setBackground(Color.BLACK);
        addRoom.setForeground(Color.WHITE);
        addRoom.addActionListener(this);
        add(addRoom);

        // Buton pentru afișarea tuturor camerelor
        displayRoom = new JButton("All rooms");
        displayRoom.setBounds(10, 70,200, 30);
        displayRoom.setBackground(Color.BLACK);
        displayRoom.setForeground(Color.WHITE);
        displayRoom.addActionListener(this);
        add(displayRoom);

        // Buton pentru actualizarea unei camere
        updateRoom = new JButton("Update room");
        updateRoom.setBounds(10, 110,200, 30);
        updateRoom.setBackground(Color.BLACK);
        updateRoom.setForeground(Color.WHITE);
        updateRoom.addActionListener(this);
        add(updateRoom);

        // Buton pentru a reveni la fereastra de administrare
        back = new JButton("Back");
        back.setBounds(10, 430,200, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(350,200,800,570);
        setVisible(true);
    }

    //In functie de apasarea fiecarui buton suntem trimisi in diferite pagini
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addRoom){
            setVisible(false);
            new AddRooms();
        }else if(ae.getSource() == displayRoom){
            setVisible(false);
            new SearchRoom();
        }else if(ae.getSource() == updateRoom){
            setVisible(false);
            new UpdateRoom();
        }else if(ae.getSource() == back){
            setVisible(false);
            new Admin();
        }
    }

    public static void main(String[] args) {
        new HotelManagement.RoomDirectory.Room();
    }
}