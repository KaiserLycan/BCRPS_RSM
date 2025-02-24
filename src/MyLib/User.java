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
public class User implements IGenerateID{
    private long id;
    private String username;
    private String password;
    protected String type = "USER";
    
    protected User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = this.generateID();
    }
    
    //////////////////////////////////////////////////////////////////////////
    //User-defined methods
    
    public boolean verifyLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    @Override
    public String toString() {
        return this.username + "\t\t\t" + this.password + "\t\t\t" + this.type;
    }
    
    
    @Override
    public long generateID() {
        Date date = new Date();
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        int seconds = date.getSeconds();
        return Long.parseLong(day + "" + month + "" + year + "" + hours + "" + minutes + "" + seconds);
    }
    ////////////////////////////////////////////////////////////////////////////
    //Getters and Setters
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    public void setID(long id) {
        this.id = id;
    }
    
    public String getPassword () {
        return password;
    }
    
    
    public String getUsername () {
        return username;
    }


    @Override
    public long getID() {
        return id;
    }
    
    
    
}
