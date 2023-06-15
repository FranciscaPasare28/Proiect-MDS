package HotelManagement.FrontDesk;

import HotelManagement.Conn;
import org.jdatepicker.impl.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Date;

public class Reservation extends JFrame implements ActionListener {
    JComboBox comboid;
    JTextField tfnumber, tfname, tfcountry, tfdeposit;
    JRadioButton rsingle, rdouble, rtriple;
    JDatePickerImpl datecheckin, datecheckout;  // date picker
    Choice croom;
    JLabel checkintime;
    JButton add, back, check;
    static int attempts = 0;
    public Reservation(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // titlu
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raieway",Font.PLAIN, 20));
        add(text);


        // tip carte identitate
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35, 80, 100, 20);
        lblid.setFont(new Font("Raieway",Font.PLAIN, 20));
        add(lblid);

        String option[]={"Passport", "Driving License","Voted-id Card"};
        comboid= new JComboBox(option);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        // ID number
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35, 120, 100, 20);
        lblnumber.setFont(new Font("Raieway",Font.PLAIN, 20));
        add(lblnumber);

        tfnumber= new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);


        // Nume client
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Raieway",Font.PLAIN, 20));
        add(lblname);

        tfname= new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);


        // Tara client
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35, 200, 100, 20);
        lblcountry.setFont(new Font("Raieway",Font.PLAIN, 20));
        add(lblcountry);

        tfcountry= new JTextField();
        tfcountry.setBounds(200,200,150,25);
        add(tfcountry);


        // Tip camera : single, double, triple
        JLabel lblroomtype = new JLabel("Room type");
        lblroomtype.setBounds(35, 240, 100, 20);
        lblroomtype.setFont(new Font("Raieway",Font.PLAIN, 20));
        add(lblroomtype);

        rsingle = new JRadioButton("Single");
        rsingle.setBackground(Color.WHITE);
        rsingle.setBounds(200,240,70,25);
        add(rsingle);

        rdouble = new JRadioButton("Double");
        rdouble.setBackground(Color.WHITE);
        rdouble.setBounds(270,240,70,25);
        add(rdouble);

        rtriple = new JRadioButton("Triple");
        rtriple.setBackground(Color.WHITE);
        rtriple.setBounds(340,240,70,25);
        add(rtriple);

        ButtonGroup buttonGroup = new ButtonGroup();    // Adaugam radio butoanele in acelasi grup
        buttonGroup.add(rsingle);                       // ca sa se deselecteze automat atunci cand apasam altul.
        buttonGroup.add(rdouble);
        buttonGroup.add(rtriple);


        // Checkin time
        JLabel lbltime = new JLabel("Checkin time");
        lbltime.setBounds(35, 280, 150, 20);
        lbltime.setFont(new Font("Raieway",Font.PLAIN, 20));
        add(lbltime);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
        datecheckin = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        datecheckin.setBounds(200, 280, 150, 25);
        add(datecheckin);

        // check out time
        JLabel lblcheckout = new JLabel("Checkout time");
        lblcheckout.setBounds(35, 320, 150, 20);
        lblcheckout.setFont(new Font("Raieway",Font.PLAIN, 20));
        add(lblcheckout);

        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2,p2);
        datecheckout = new JDatePickerImpl(datePanel2, new DateLabelFormatter());

        datecheckout.setBounds(200, 320, 150, 25);
        add(datecheckout);

        check = new JButton("Check for rooms");
        check.setBackground(Color.black);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 370, 160, 30);
        check.addActionListener(this);
        add(check);

        add = new JButton("Add");
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.setBounds(50, 460, 120, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 460, 120, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon("src/main/java/images/customer.jpg");
        Image i3 = i1.getImage().getScaledInstance(696, 464, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400, 50, 300, 400);
        add(l15);

        setBounds(350, 200, 800, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==check){
            // Numar camere disponibile
            Reservation.attempts++;     //incrementam numarul de apasari a butonului de verificare

            if(attempts == 1)           // daca apasam pentru prima data butonul de check adaugam eticheta "Room number":
            {
                JLabel lblroom = new JLabel("Room number:");
                lblroom.setBounds(35, 420, 150, 20);
                lblroom.setFont(new Font("Raieway",Font.PLAIN, 20));
                add(lblroom);

                JLabel lbltotal = new JLabel("Total:");                    // Eticheta pentru pretul total
                lbltotal.setBounds(200, 370, 160, 30);
                lbltotal.setFont(new Font("Raieway",Font.PLAIN, 20));
                add(lbltotal);

            }

            if(attempts > 1)                                // daca a fost deja generata lista de camere o stergem
            {                                               // pentru a putea genera una noua adecvata interogarii noi

                Component[] components = getContentPane().getComponents();  // obtinem toate componentele din pagina
                for(Component comp: components)                             // stergem meniul cu camerele valabile
                {
                    if(comp instanceof Choice)                              //componenta = eticheta, button, meniu, etc..
                    {
                        remove(comp);
                    }
                }
            }

            croom = new Choice();
            String room_type = null;
            if(rsingle.isSelected()){
                room_type = "Single";
            }else if(rdouble.isSelected()){
                room_type = "Double";
            } else if (rtriple.isSelected()) {
                room_type = "Triple";
            }
            String date_checkin = datecheckin.getModel().getValue().toString();
            String date_checkout = datecheckout.getModel().getValue().toString();
            SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            try{
                Date date = inputFormat.parse(date_checkin);
                String checkin = outputFormat.format(date);
                Date date2 = inputFormat.parse(date_checkout);
                String checkout = outputFormat.format(date2);

                Conn conn = new Conn();
                // camere care au fost inchiriate, dar sunt libere in perioada introdusa
                String query = "select roomnumber, price from room join customer on room.roomnumber = customer.room" +
                        " where room_type = '"+ room_type +"'" +   // tipul camerei
                        " and (checkouttime <= '"+ checkin +"'" +   // daca este disponibila la intervalul dorit
                        "     or checkintime >= '"+ checkout +"')" +
                        " and cleaning_status = 'Cleaned'" +      // daca este curata
                        " union " +
                        " select roomnumber, price from room where ROOMNUMBER not in (select room from customer) " + // camerele care nu au fost niciodata inchiriate
                        " and room_type = '"+ room_type +"'" +
                        " and cleaning_status = 'Cleaned'";
                ResultSet rs = conn.s.executeQuery(query);
                while (rs.next()){
                    String val = "Nr. "+ rs.getString("roomnumber")+ " -- " + rs.getString("price") + " lei/noapte";
                    croom.add(val);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            croom.setBounds(200,420,150,25);
            add(croom);

            String room = croom.getSelectedItem().substring(4,7);
            date_checkin = datecheckin.getModel().getValue().toString();
            date_checkout = datecheckout.getModel().getValue().toString();
            float pret = getReservationPrice(room, date_checkin, date_checkout);

            Component[] components = getContentPane().getComponents();      // updatam pretul in functie de alegerea clientlui
            for(Component comp : components)
            {
                if(comp instanceof JLabel)
                {
                    try {
                        JLabel label = (JLabel) comp;
                        if (label.getText().startsWith("Total:"))       // cautam eticheta pentru Total
                        {
                            ((JLabel) comp).setText("Total: " + pret);           // ii modificam valoarea cu pretul actual
                        }
                    }
                    catch (Exception e)
                    {
                        continue;
                    }
                }
            }



        }else if(ae.getSource()==add) {

            String identity = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String country = tfcountry.getText();
            String room = croom.getSelectedItem().substring(4,7);
            String date_checkin = datecheckin.getModel().getValue().toString();
            String date_checkout = datecheckout.getModel().getValue().toString();

            float pret = getReservationPrice(room, date_checkin, date_checkout);

            try{
                SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                LocalDate checkout = null;
                LocalDate checkin = null;

                Date date = inputFormat.parse(date_checkin);
                String outputDate = outputFormat.format(date);
                Date date2 = inputFormat.parse(date_checkout);
                String outputDate2 = outputFormat.format(date2);

                checkin = LocalDate.parse(outputDate);
                checkout = LocalDate.parse(outputDate2);



                String query = "insert into Customer values('"+identity+"','"+number+"','"+name+"','"+country+"','"+room+"','"+checkin+"','"+checkout+"','"+ pret +"','false')";
//                String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";

                Conn conn = new Conn();
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "New customer added successfully!");

                setVisible(false);
                new Reception();

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new Reservation();
    }



    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }
    }

    public static float getReservationPrice(String room, String date_checkin, String date_checkout)
    {  // Functie care calculeaza pretul sederii unui client, primeste ca parametrii: nr camerei, data de intrare si data de iesire
        // calculare plata = pret * nr_nopti
        float camera_pret = 0;
        String pret_camera = "select price from room where roomnumber = '"+room+"'";
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(pret_camera);
            while (rs.next()) {
                camera_pret = Float.parseFloat(rs.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long nr_nopti = 0;
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate checkout = null;
        LocalDate checkin = null;
        try {
            // conversie
            Date date = inputFormat.parse(date_checkin);
            String outputDate = outputFormat.format(date);
            Date date2 = inputFormat.parse(date_checkout);
            String outputDate2 = outputFormat.format(date2);

            checkin = LocalDate.parse(outputDate);
            checkout = LocalDate.parse(outputDate2);

            long daysDifference = ChronoUnit.DAYS.between(checkin, checkout);
            nr_nopti = Math.abs(daysDifference);

        }
        catch (ParseException excep) {
            excep.printStackTrace();
        }

        float pret = camera_pret * nr_nopti;

        return pret;
    }
}
