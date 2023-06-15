package HotelManagement.EmployeeDirectory;


import HotelManagement.Conn;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class AddEmployee extends JFrame{

    JButton Next, cancel;
    JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
    JComboBox c1;

    // Metodă pentru generarea unui ID unic pentru angajat
    private static int generateUniqueId(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    // Metodă pentru trimiterea unui email cu datele de autentificare către angajat
    private void sendCredentialsEmail(String recipientEmail, String generatedPassword) {
        // Adresa de e-mail și parola expeditorului
        String fromEmail = "marianita162460@gmail.com";
        String fromPassword = "qwpkwwnlrnpbskqm";


        // Configurarea proprietăților pentru trimiterea e-mailului
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // Crearea sesiunii pentru trimiterea e-mailului
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, fromPassword);
            }
        });

        try {
            // Crearea mesajului de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Creare cont nou");
            message.setText("Bună ziua,\n\n" +
                    "Vă mulțumim pentru înregistrarea dumneavoastră. Ați creat cu succes un cont în sistemul nostru.\n" +
                    "Vă furnizăm credențialele de autentificare:\n\n" +
                    "Utilizator: " + recipientEmail + "\n" +
                    "Parolă: " + generatedPassword + "\n\n" +
                    "Vă recomandăm să vă autentificați cât mai curând posibil și să vă schimbați parola.\n" +
                    "Cu stimă,\n" +
                    "Echipa noastră");

            // Trimiterea mesajului de e-mail
            Transport.send(message);

            System.out.println("E-mail trimis cu succes la adresa " + recipientEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    // Metodă pentru generarea unei parole aleatoare
    private String generateRandomPassword() {
        // Implementați logica de generare a parolei aleatorii
        // Aici puteți folosi orice metodă preferată pentru generarea parolei
        // În exemplu, vom folosi o parolă formată dintr-un șir de caractere aleatorii de lungime fixă
        int length = 8;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            password.append(characters.charAt(randomIndex));
        }
        return password.toString();
    }
    public AddEmployee(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.decode("#fae5c3"));
        setTitle("ADD EMPLOYEE DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);

        JLabel Passportno = new JLabel("NAME");
        Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Passportno.setBounds(60, 30, 150, 27);
        add(Passportno);

        // Câmpul de introducere pentru nume
        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);

        JLabel Pnrno = new JLabel("Birth Date");
        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Pnrno.setBounds(60, 80, 150, 27);
        add(Pnrno);

        // Câmpul de introducere pentru data nașterii
        textField_1 = new JTextField();
        textField_1.setBounds(200, 80, 150, 27);
        add(textField_1);

        JLabel Gender = new JLabel("GENDER");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 120, 150, 27);
        add(Gender);

        // Butonul radio pentru selecția genului MALE
        JRadioButton NewRadioButton = new JRadioButton("MALE");
        NewRadioButton.setBackground(Color.decode("#fae5c3"));
        NewRadioButton.setBounds(200, 120, 70, 27);
        add(NewRadioButton);

        // Butonul radio pentru selecția genului FEMALE
        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.decode("#fae5c3"));
        Female.setBounds(280, 120, 85, 27);
        add(Female);


        JLabel Address = new JLabel("JOB");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 170, 150, 27);
        add(Address);

        // Lista derulantă pentru selectarea ocupației
        String course[] = {"Receptionist","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,170,150,30);
        add(c1);

        JLabel Nationality = new JLabel("SALARY");
        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Nationality.setBounds(60, 220, 150, 27);
        add(Nationality);

        // Câmpul de introducere pentru salariu
        textField_3 = new JTextField();
        textField_3.setBounds(200, 220, 150, 27);
        add(textField_3);

        JLabel Name = new JLabel("PHONE");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 270, 150, 27);
        add(Name);

        // Câmpul de introducere pentru numărul de telefon
        textField_4 = new JTextField();
        textField_4.setBounds(200, 270, 150, 27);
        add(textField_4);

        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 320, 150, 27);
        add(email);

        // Câmpul de introducere pentru adresa de email
        textField_6 = new JTextField();
        textField_6.setBounds(200, 320, 150, 27);
        add(textField_6);

        setVisible(true);

        JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
        AddPassengers.setForeground(Color.black);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        add(AddPassengers);

        //Introducere imagine
        ImageIcon i1 = new ImageIcon("src/main/java/images/emp.png");
        Image i3 = i1.getImage().getScaledInstance(681, 382,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410,80,480,410);
        add(image);

        Next = new JButton("ADD");
        Next.setBounds(200, 420, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.black);
        cancel.setBounds(60, 420, 130, 30);
        add(cancel);

        // Acțiunea butonului de anulare
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
                new Employee();
            }
        });

        // Acțiunea butonului de salvare
        Next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String name = textField.getText();
                String age = textField_1.getText();
                String salary = textField_3.getText();
                String phone = textField_4.getText();
                String email = textField_6.getText();
                int id = generateUniqueId(1, 9999);
                String gender = null;

                if(NewRadioButton.isSelected()){
                    gender = "male";

                }else if(Female.isSelected()){
                    gender = "female";
                }


                String job = (String)c1.getSelectedItem();

                try {
                    String generatedPassword = generateRandomPassword();

                    Conn c = new Conn();
                    String str = "INSERT INTO employee values( "+id+",'"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+ generatedPassword+"', CURRENT_TIMESTAMP)";
                    c.s.executeUpdate(str);

                    JOptionPane.showMessageDialog(null,"Employee Added");
                    String recipientEmail = c.getEmailFromDatabase();


                    sendCredentialsEmail(recipientEmail, generatedPassword);
                    // Funcția pentru trimiterea e-mailului cu credențialele

                    setVisible(false);
                    new Employee();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

//        setSize(900,600);
        setBounds(300, 100, 920, 580);
        setVisible(true);
//        setLocation(530,200);

    }

    public static void main(String[] args){
        new AddEmployee();
    }
}