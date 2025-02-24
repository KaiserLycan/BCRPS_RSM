/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realestate;

import java.util.ArrayList;

/**
 *
 * @author Andrei Samarita
 */
import java.util.ArrayList;

/**
 *
 * @author Andrei Samarita
 */
public class Client {
    private String FirstName;
    private String LastName;
    private String mobileNumber;
    private String email;
    private ArrayList<RealEstate> purchases;

    public Client(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
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