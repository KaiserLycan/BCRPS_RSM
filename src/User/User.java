package User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrei Samarita
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String type;
 
    ///////////////////////////////////////////////////////////////////////////
    ///Constructor
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    ///////////////////////////////////////////////////////////////////////
    ///User-defined Methods
    public boolean verifyLogin(String userName, String password) {
        return this.userName.equals(userName) && this.password.equals(password);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ///Gtters and Setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
    
    
}
