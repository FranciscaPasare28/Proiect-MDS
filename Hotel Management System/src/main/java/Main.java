import HotelManagement.HotelManagementSystem;

public class Main {
    public static void main(String[] args) {
        // Obține instanța singleton a sistemului de gestionare a hotelului
        HotelManagementSystem h = HotelManagementSystem.getInstance();

        // Construiește interfața grafică a sistemului de gestionare a hotelului
        h.build();

        // Face fereastra vizibilă
        h.setVisible(true);
    }
}