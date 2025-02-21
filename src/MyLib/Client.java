/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLib;

import java.util.Date;

/**
 *
 * @author Joseph Rey
 */
public class Client extends User{
    private String firstName;
    private String lastName;
    private long id;
    private String mobileNumber;
    private String email;
    
    public Client (String firstName, String lastName, String username, String password, String mobileNumber, String email) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.id = generateID();
    }
    
    private long generateID() {
        Date date = new Date();
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        int seconds = date.getSeconds();
        return Long.parseLong(day + "" + month + "" + year + "" + hours + "" + minutes + "" + seconds);
    }
    
}
