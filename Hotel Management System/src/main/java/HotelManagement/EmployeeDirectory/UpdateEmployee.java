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

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(778, 486));
        setResizable(false);

        // Panou principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#FFE0BA"));

        // Label-uri și câmpuri pentru introducerea datelor
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(60, 30, 150, 27);
        idField = new JTextField();
        idField.setBounds(200, 30, 150, 27);
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(60, 80, 150, 27);
        nameField = new JTextField();
        nameField.setBounds(200, 80, 150, 27);
        JLabel ageLabel = new JLabel("Birth Date:");
        ageLabel.setBounds(60, 130, 150, 27);
        ageField = new JTextField();
        ageField.setBounds(200, 130, 150, 27);
        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(60, 180, 150, 27);
        salaryField = new JTextField();
        salaryField.setBounds(200, 180, 150, 27);
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(60, 230, 150, 27);
        phoneField = new JTextField();
        phoneField.setBounds(200, 230, 150, 27);
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(60, 280, 150, 27);
        emailField = new JTextField();
        emailField.setBounds(200, 280, 150, 27);

        // Buton pentru actualizare
        JButton updateButton = new JButton("Update");
        updateButton.setForeground(Color.WHITE);
        updateButton.setBackground(Color.BLACK);
        updateButton.setBounds(60, 330, 130, 30);
        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
        backButton.setBounds(200, 330, 130, 30);

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

        // Acțiunea de revenire
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Employee adminPage = new Employee();
                adminPage.setVisible(true);
            }
        });

        pack();
        setBounds(400,150,700,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateEmployee();
    }
}
