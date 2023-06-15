package HotelManagement.EmployeeDirectory;
import HotelManagement.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField salaryField;
    private JTextField phoneField;
    private JTextField emailField;

    public UpdateEmployee() {
        setTitle("Update Employee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(778, 486));
        setResizable(false); // Nu permiteți redimensionarea ferestrei

        // Panou principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(8, 2, 10, 10)); // Spațiere între componentele adiacente

        // Label-uri și câmpuri pentru introducerea datelor
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Birth Date:");
        ageField = new JTextField();
        JLabel salaryLabel = new JLabel("Salary:");
        salaryField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        // Buton pentru actualizare
        JButton updateButton = new JButton("Update");
        JButton backButton = new JButton("Back");

        // Adăugarea componentelor în panoul principal
        mainPanel.add(idLabel);
        mainPanel.add(idField);
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(ageLabel);
        mainPanel.add(ageField);
        mainPanel.add(salaryLabel);
        mainPanel.add(salaryField);
        mainPanel.add(phoneLabel);
        mainPanel.add(phoneField);
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);
        mainPanel.add(backButton);
        mainPanel.add(updateButton);

        // Adăugarea panoului principal în fereastră
        setContentPane(mainPanel);

        // Acțiunea de actualizare
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String age = ageField.getText();
                String salary = salaryField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();

                // Actualizarea în baza de date
                try {
                    Conn connection = new Conn();
                    Connection conn = connection.c;
                    String query = "UPDATE employee SET name=?, birth_date=?, salary=?, phone=?, email=? WHERE id=?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, name);
                    stmt.setString(2, age);
                    stmt.setString(3, salary);
                    stmt.setString(4, phone);
                    stmt.setString(5, email);
                    stmt.setInt(6, id);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Employee updated successfully!");
                    setVisible(false);

                    new Employee();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        // Acțiunea de back
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Închide fereastra curentă
                Employee adminPage = new Employee();
                adminPage.setVisible(true); // Deschide fereastra Admin
            }
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateEmployee();
    }
}
