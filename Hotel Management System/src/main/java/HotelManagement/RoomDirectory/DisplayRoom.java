package HotelManagement.RoomDirectory;

import HotelManagement.Conn;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DisplayRoom extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    public DisplayRoom() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("src/main/java/images/double_room2.jpg");
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);

        // Creează un model de tabel și setează coloanele
        String[] columnNames = {"Room Number", "Cleaning Status", "Price", "Bed Type"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        // Crează un tabel și setează proprietățile acestuia
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(10, 40, 480, 400);
        add(scroll);

        try {
            // Realizează conexiunea la baza de date
            Conn connection = new Conn();
            Connection conn = connection.c;
            // Interogare pentru a obține datele camerei din tabelul "room"
            String query = "SELECT * FROM room";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Parcurge rezultatele interogării și adaugă rânduri în tabel
            while (rs.next()) {
                String roomNumber = rs.getString("roomnumber");
//                String availability = rs.getString("availability");
                String cleaningStatus = rs.getString("cleaning_status");
                String price = rs.getString("price");
                String bedType = rs.getString("bed_type");
                model.addRow(new Object[]{roomNumber, cleaningStatus, price, bedType});
            }

            // Închide resursele și conexiunea la baza de date
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Adaugă un buton "Back" pentru a reveni la fereastra de gestionare a camerelor
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200, 500, 120, 30);
        add(back);

        setBounds(300, 200, 1050, 600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Room();
    }

    public static void main(String[] args) {
        new DisplayRoom();
    }
}
