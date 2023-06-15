package HotelManagement.EmployeeDirectory;

import HotelManagement.Conn;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DisplayEmployee extends JFrame {
    private JTable table;

    public DisplayEmployee() {
        setTitle("Employee Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurarea layout-ului pentru fereastra
        setLayout(new BorderLayout());

        // Obținerea datelor din baza de date și crearea modelului pentru tabel
        try {
            Conn connection = new Conn();
            Connection conn = connection.c;
            String query = "SELECT * FROM employee";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Crearea unui obiect DefaultTableModel și adăugarea datelor din ResultSet
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(new Object[]{"ID", "Name", "Birth Date", "Gender", "Job", "Salary", "Phone", "Email", "Insert Date"});
            while (rs.next()) {
                Object[] rowData = new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("birth_date"),
                        rs.getString("gender"),
                        rs.getString("job"),
                        rs.getString("salary"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getTimestamp("insert_date")
                };
                tableModel.addRow(rowData);
            }

            // Crearea tabelului și adăugarea acestuia într-un JScrollPane
            table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);

            // Adăugarea JScrollPane în fereastra
            add(scrollPane, BorderLayout.CENTER);

            // Crearea butonului "Back"
            JButton backButton = new JButton("Back");
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose(); // Închide fereastra curentă
                    Employee employeePage = new Employee();
                    employeePage.setVisible(true); // Deschide fereastra Employee
                }
            });

            // Adăugarea butonului "Back" în partea de jos a ferestrei
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(backButton);
            add(buttonPanel, BorderLayout.SOUTH);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Afișarea ferestrei
        setBounds(400, 200, 900, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DisplayEmployee();
    }
}
