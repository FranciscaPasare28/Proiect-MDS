package HotelManagement.EmployeeDirectory;
import HotelManagement.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class DeleteEmployee extends JFrame {
    JButton Delete, Cancel;
    JTextField textField;

    public DeleteEmployee() {
        // Configurarea aspectului frame-ului
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.decode("#fae5c3"));
        setTitle("Delete Employee");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        // Eticheta și câmpul pentru introducerea ID-ului Angajatului
        JLabel label = new JLabel("Enter Employee ID:");
        label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label.setBounds(60, 90, 200, 27);
        add(label);

        textField = new JTextField();
        textField.setBounds(250, 90, 150, 27);
        add(textField);

        // Butonul pentru ștergere
        Delete = new JButton("Delete");
        Delete.setBounds(240, 220, 150, 30);
        Delete.setBackground(Color.BLACK);
        Delete.setForeground(Color.WHITE);
        add(Delete);

        // Butonul pentru anulare
        Cancel = new JButton("Cancel");
        Cancel.setForeground(Color.WHITE);
        Cancel.setBackground(Color.black);
        Cancel.setBounds(100, 220, 130, 30);
        add(Cancel);

        // Acțiunea butonului de anulare
        Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Employee();
            }
        });

        // Acțiunea butonului de ștergere
        Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int employeeId = Integer.parseInt(textField.getText());

                try {
                    Conn con = new Conn();
                    String query = "DELETE FROM employee WHERE id = ?";
                    PreparedStatement stmt = con.c.prepareStatement(query);
                    stmt.setInt(1, employeeId);
                    int rowsAffected = stmt.executeUpdate();

                    setVisible(false);
                    new Employee();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Employee Deleted");
                setVisible(false);
                //new Admin();
            }
        });
        // Setarea dimensiunilor și vizibilității frame-ului
        setBounds(450, 200, 600, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DeleteEmployee();
    }
}
