/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author busan
 */
public class Main {
    
}
public class Main {
    public static void main(String[] args) {
        User user = new User("johndoe", "password");
        Client client = new Client("janedoe", "secret");
        Admin admin = new Admin("admin", "admin123");

        RealEstate property = new RealEstate(123, "123 Main St", 1500, 300000, "Available");
    }
}