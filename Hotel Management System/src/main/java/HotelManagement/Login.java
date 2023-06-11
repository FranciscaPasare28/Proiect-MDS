package HotelManagement;

import HotelManagement.FrontDesk.Reception;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class
Login extends JFrame implements ActionListener {

    JTextField username, password, newpassword;
    JButton login, cancel, changePassword, update;
//    JLabel newpass;

    public Login(){
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        password = new JTextField();
        password.setBounds(150, 70, 150, 30);
        add(password);

        changePassword = new JButton("I want to change the password");
        changePassword.setBounds(40, 180, 300, 30);
        changePassword.setBackground(Color.BLACK);
        changePassword.setForeground(Color.WHITE);
        changePassword.addActionListener(this);
        add(changePassword);


        login = new JButton("Login");
        login.setBounds(40, 120, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 120, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon image_login = new ImageIcon("src/main/java/images/login.png");
        Image i2 = image_login.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setBounds(500, 200, 600, 350);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();
            try {
                Conn c = new Conn();
                String job = "select * from employee where email = '" + user + "' and password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(job);

                if (rs.next()) {
                    if (rs.getString("JOB").equals("Manager")) {
                        setVisible(false);
                        new Admin();

                    } else if (rs.getString("JOB").equals("Receptionist")) {
                        setVisible(false);
                        new Reception();

                    } else if (rs.getString("JOB").equals("Housekeeping")) {
                        setVisible(false);
                        new Cleaning();
                    } else {
                        JOptionPane.showMessageDialog(null, "Access denied!");
                        setVisible(false);

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                    new Login();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(ac.getSource() == changePassword) {   // daca credentialele introduse sunt corecte, putem schimba parola

            String user = username.getText();
            String pass = password.getText();
            try{
                Conn c = new Conn();
                String job = "select * from employee where email = '" + user + "' and password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(job);

                if(rs.next())
                {
                    JLabel newpass = new JLabel("New Password");
                    newpass.setBounds(40, 240, 100, 30);
                    add(newpass);

                    newpassword = new JTextField();
                    newpassword.setBounds(150, 240, 150, 30);
                    add(newpassword);

                    update = new JButton("Update");
                    update.setBounds(320, 240, 120, 30);
                    update.setBackground(Color.BLACK);
                    update.setForeground(Color.WHITE);
                    update.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String newpass = newpassword.getText();
                            try {
                                Conn c = new Conn();
                                String update = "update employee set password = '" + newpass + "' where email = '" + user + "'";
                                c.s.executeQuery(update);
                                JOptionPane.showMessageDialog(null, "Update successful!");
                                setVisible(false);
                                new Login();

                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    add(update);
                    setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                    new Login();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        } else if(ac.getSource() == cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
