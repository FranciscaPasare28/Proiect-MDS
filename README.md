# Hotel Management System
</hr>
&ensp;&ensp;&ensp;This application is a hotel management system and offers the essential services for carrying out its activities.</br>
&ensp;&ensp;&ensp;After you have passed the initial screen and logged in with the credentials generated by the manager within the application, you will be directed to the menu that offers you the possibility to carry out the activity. The services are divided into 3 categories: management, reception and cleaning.</br>
&ensp;&ensp;&ensp;The manager deals with the management of the employees and the hotel rooms. It also has access to all other services offered by the application for flexibility.</br>
The reception can make reservations for customers, through which the room becomes unavailable for a certain period. Other services are the check-in and checkout service and placing a request for room cleaning at the request of the customers.</br>
&ensp;&ensp;&ensp;The cleaning part has access to an interactive menu through which they can select the rooms they have cleaned and in which they can view the clean rooms.</br>
&ensp;&ensp;&ensp;The application offers an intuitive interface, so that the staff can successfully carry out their work without technical impediments.:smiley:</br>

## [Application demo](https://youtu.be/4fbnvrg93LQ)
Here you can find the offline demo of the application. (Link is in the header)
## Technical Requirments
Oracle database service express 11g minimum and JDK 19 (Java machine)</br>
Jars required:
<ul>
  <li>javax.activation-api-1.2.0-javadoc</li>
  <li>javax.mail-1.6.2</li>
  <li>jdatepicker-1.3.4</li>
  <li>ojdbc11</li>
</ul>

## Application features
### 1. User stories
1. As a Manager, I want to manage my employees easily.
2. As a Manager, I want to manage the hotel's assets(rooms) efficiently.
3. As a Manager, I want to be able to make changes in case of emergency.
4. As a Manager, I would like to find a convenient method for emailing my employees to enhance communication.
5. As a Receptionist, I want to make reservations for the customers, so that the hotel is working at full capacity.
6. As a Receptionist, I want to confirm when a client arrives.
7. As a Receptionist, I want to be able to update the room when a client is leaving. 
8. As a Receptionist, I want to help the customers with cleaning requests when it is necessary.
9. As a Receptionist, I want to communicate to the manager when we have no more rooms available.
10. As a Housekeeper, I want to keep track of the rooms that I have cleaned up.

### 2. Backlog
We have managed the projects tasks using jira and here is the backlog:  https://mdshotelmanagement.atlassian.net/jira/software/projects/HOT/boards/1/backlog<br></br>
<img src="https://img.freepik.com/free-photo/puppy-that-is-walking-snow_1340-37228.jpg?w=2000" alt="Image" width="900" height="450"></br>

### 3. Features
1. Add, update, delete, display employees.
2. Add, update, display rooms.
3. Send emails to the employees after they've been added to the application.
4. Custom login for the specific job that an employee have.
5. Add, update customer reservation by the front desk clerks.
6. Checkin, checkout clients.
7. Create cleaning requests by the front desk clerks.
8. Manage dirty rooms by the housekeeping personal.
9. Connection to the oracle sql database.

### 4. Application Description
&ensp;&ensp;&ensp;The hotel management system is designed to streamline operations and enhance communication within the hotel. It offers a range of essential services that facilitate efficient activities throughout the organization.</br>

&ensp;&ensp;&ensp;The application provides a user-friendly interface, ensuring smooth navigation and eliminating technical barriers. Employees can easily carry out their tasks without encountering any impediments.</br>

&ensp;&ensp;&ensp;With the hotel management system, managers can effectively oversee employee and hotel room management. They have access to comprehensive features, enabling them to handle various tasks with flexibility and ease.</br>

&ensp;&ensp;&ensp;Receptionists benefit from functionalities that simplify customer reservations. They can make bookings, mark rooms as unavailable for specific time periods, and manage check-in and checkout processes seamlessly. Additionally, they can submit room cleaning requests based on customer preferences to ensure a pleasant stay.</br>

&ensp;&ensp;&ensp;The system also caters to the needs of the housekeeping staff. They have access to an interactive menu where they can select and view rooms they have cleaned. This feature improves efficiency and helps maintain an organized cleaning process.</br>

&ensp;&ensp;&ensp;Other notable features of the application include customizable login options based on specific job roles, automated email notifications to keep employees informed, and integration with an Oracle SQL database for reliable data storage.</br>

&ensp;&ensp;&ensp;Overall, the hotel management system offers an intuitive interface, allowing staff members to carry out their work efficiently. It optimizes operations, enhances communication, and contributes to a seamless hotel management experience.</br>

### 5. Application interface.
### 6. UML diagrams.
### 7. Source Control.
Branches:</br>
1. main - full project structure
2. Admin-Services---Room-/-CRUD  -earlier project version, manager functionality
3. Restructurare/FrontDesk-Services  - second biggest update, front desk functionality
4. Cleaning-Services-Interface  - latest version update, cleaning personal functionality
</br>
Pull requests:</br>
<a href="https://github.com/ccazacu13/Proiect-MDS/pull/6">login + new customer #6</a> - pull request for adding the login system and customer addition to the database, Merged on June 9
<a href="https://github.com/ccazacu13/Proiect-MDS/pull/9">Checkin/Checkout + Cleaning call #9 </a> - pull request for front desk functionality: checkin/checkout system and the posibility to request cleaning of the room.
</br>

### 8. Issue fixing.
Three of the problems we encoutered during the development process:
- Freed rooms are not updated in the database.
- Rooms were reserved by the clients even when none were available.
- Radio buttons in the reservation for where not interacting with each other.</br>
We resolved this issues in <a href="https://github.com/ccazacu13/Proiect-MDS/pull/13">"Version with the majority of features" #13</a> pull request on 15 June.

### 9. Refactoring, code standards.
&ensp;&ensp;&ensp;We respected the code standards presented by java, the division of classes into packages based on functionalities, the rules for naming classes and creating them in a way that corresponds to the purpose they serve. Another main change is the change of the login interface to provide the possibility to change the password and facilitate access to the interface intended for each specific type of employee.
- <a href="https://github.com/ccazacu13/Proiect-MDS/commit/ffdc92016b599f292290e4a7aee69e16535ed132#diff-ac3188dbdbd4c7c43448c6fc3125a807630e4bdb8058e5c0e77c03454f421ee6">Changing login interface.</a>
- <a href="https://github.com/ccazacu13/Proiect-MDS/commit/a153aa741909b109917caac667277619475aafcc">Reception restructure.</a> (we have reconsidered the facilities that the reception should have).
- <a href="https://github.com/ccazacu13/Proiect-MDS/commit/03c546803b510c9a93649a45f563fe1ea1177065">Room attributes update and customer management.</a>

### 10. Code comments.
&ensp;&ensp;&ensp;To make the code more accesible for future changes we commented the most important functions and explained what they are supposed to do and the bits that are not very intuitive.</br>
Here is an example:</br>
```java
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
```
### 11. Design Patterns.
&ensp;&ensp;&ensp;In the application for the main class that start the whole process "HotelManagementSystem.java" we opted for the idea of using a singleton design pattern. This class doens't necessitate multiple instances and the instance provided can serve it's functionality in the entire app.</br>
&ensp;&ensp;&ensp;The Singleton design pattern is a creational design pattern that restricts the instantiation of a class to a single object. It ensures that only one instance of the class exists throughout the application and provides a global point of access to that instance.</br>

```java
    
    public class HotelManagementSystem extends JFrame implements ActionListener {

    // Instanța singleton
    private static HotelManagementSystem instance;

    // Constructor privat pentru a preveni instantierea directa
    private HotelManagementSystem() {}

    public static HotelManagementSystem getInstance() {
        if (instance == null) {
            // Creează o nouă instanță dacă nu există nicio instanță
            instance = new HotelManagementSystem();
        }
        return instance;
    }

    public void build(){
        // Configurarea JFrame
        setBounds(150, 50, 1100, 700);
        setLayout(null);

        // Adăugarea imaginii hotelului
        ImageIcon image_hotel = new ImageIcon("src/main/java/images/hotel.jpg");
        JLabel image = new JLabel(image_hotel);
        image.setBounds(0, 0, 1100, 700);
        add(image);
        
        ....
        
```

### 12. The usage of an AI tool.
&ensp;&ensp;&ensp;AI tools have proven to be highly beneficial for software development in numerous ways. Here are some reasons why AI tools are considered valuable in the software development process. We have used ChatGPT made by OpenAI for debugging purposes, here is a snipped of code that resolved in errors and the implementation that the AI recommanded and resolved the bug.</br>

```java
// bugged code that was fixed by ChatGPT afterwards.


        table = new JTable();
                table.setBounds(0, 40, 500, 400);

                try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from room");
                // afisare a rezultatelor interogarii in tabel
////             table.setModel(DbUtils.resultSetToTableModel(rs));

                String[] columnNames = {"Room number", "Availability", "Status", "Price", "Bed Type"};
                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(columnNames);

                table = new JTable();
                table.setModel(model);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                table.setFillsViewportHeight(true);
                JScrollPane scroll = new JScrollPane(table);
                scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                if (rs.next()) {
                String RoomNumber = rs.getString("ROOMNUMBER");
                String Availability = rs.getString("AVAILABILITY");
                String Status = rs.getString("CLEANING_STATUS");
                String Price = rs.getString("PRICE");
                String BedType = rs.getString("BED_TYPE");
                model.addRow(new Object[]{RoomNumber, Availability, Status, Price, BedType});
                }
                }
                catch (Exception e) {
                e.printStackTrace();
                }

                add(table);
```

```java
    // Fixed version generated by the AI.
    public class Room extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Room(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        ImageIcon i1 = new ImageIcon("src/main/java/images/double_room2.jpg");
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);


        String[] columnNames = {"Room Number", "Availability", "Status", "Price", "Bed Type"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(10, 40, 480, 400);
        add(scroll);

        try {
            // Establishing a connection to the database
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "password");
//            Statement stmt = con.createStatement();

            // modificare cod generat de chat gpt
            Conn c = new Conn();

            // Query to retrieve all rows from the room table
            String sql = "SELECT * FROM room";

            // Executing the query and storing the result in a ResultSet object
            ResultSet rs = c.s.executeQuery(sql);  // stmt.executeQuery(sql);

            // Iterating through the ResultSet and adding each row to the table model
            while (rs.next()) {
                String roomNumber = rs.getString("ROOMNUMBER");
                String availability = rs.getString("AVAILABILITY");
                String status = rs.getString("CLEANING_STATUS");
                String price = rs.getString("PRICE");
                String bedType = rs.getString("BED_TYPE");
                model.addRow(new Object[]{roomNumber, availability, status, price, bedType});
            }

            // Closing the connection and statement objects
            rs.close();
            c.s.close();  // stmt.close();
                          // con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200, 500, 120, 30);
        add(back);


        setBounds(300,200,1050, 600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new Room();
    }
}
```