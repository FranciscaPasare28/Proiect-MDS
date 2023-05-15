
package HotelManagement;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {

    JButton add,cancel;
    JTextField tfname, tfcompany, tfage, tfmodel,tflocation;
    JComboBox typecombo, availablecombo, gendercombo;

    public AddDriver() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        heading.setBounds(150, 10, 200, 20);
        add(heading);

        JLabel ldlroomno = new JLabel("Name");
        ldlroomno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ldlroomno.setBounds(60, 70, 120, 20);
        add(ldlroomno);

        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);

        JLabel ldage = new JLabel("Age");
        ldage.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ldage.setBounds(60, 110, 120, 20);
        add(ldage);

        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);

        JLabel ldclean = new JLabel("Gender");
        ldclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ldclean.setBounds(60, 150, 120, 30);
        add(ldclean);

        String cleanOptions[] = {"Male", "Female"};
        gendercombo = new JComboBox(cleanOptions);
        gendercombo.setBounds(200, 150, 150, 30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        JLabel ldprice = new JLabel("Car Company");
        ldprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ldprice.setBounds(60, 190, 120, 30);
        add(ldprice);

        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);

        JLabel ldtype = new JLabel("Car model");
        ldtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ldtype.setBounds(60, 230, 120, 30);
        add(ldtype);

        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);

        JLabel ldavailable = new JLabel("Available");
        ldavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ldavailable.setBounds(60, 270, 120, 30);
        add(ldavailable);

        String driverOptions[] = {"Available", "Busy"};
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(200, 270, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel ldlocation = new JLabel("Location");
        ldlocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ldlocation.setBounds(60, 310, 120, 30);
        add(ldlocation);

        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);

        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.setBounds(60, 370, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.black);
        cancel.setBounds(230, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon("src/main/java/images/driver.jpg");
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400, 30, 500, 370);
        add(l15);


        setBounds(300, 200, 980, 470);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfmodel.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();

            try{
                Conn con = new Conn();
                String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"', '"+available+"', '"+location+"')";

                con.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");

                setVisible(false);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddDriver();
    }
}