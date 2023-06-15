package HotelManagement;

import javax.swing.*;
import java.awt.*;


public class Cleaning extends JFrame{

    Cleaning() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);


        setBounds(350,200,800,570);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Cleaning();
    }

}
