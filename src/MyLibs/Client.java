/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

import java.util.ArrayList;

/**
 *
 * @author Andrei Samarita
 */

 public class Client extends User{
     private String FirstName;
     private String LastName;
     private String mobileNumber;
     private String email;
     private ArrayList<RealEstate> purchases = new ArrayList<>();

    public Client(String username, String password) {
        super(username, password, "CLIENT");
    }

    public void buyRealEstate(RealEstate re) {
    }

    public void reserveRealEstate(RealEstate re) {
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<RealEstate> getPurchases() {
        return purchases;
    }
    
}