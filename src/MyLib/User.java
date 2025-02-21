/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLib;

/**
 *
 * @author Joseph Rey
 */
public class User {
    private String username;
    private String password;
    
    protected User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean verifyLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public String getUsername () {
        return username;
    }
    
    public String password () {
        return password;
    }
}
