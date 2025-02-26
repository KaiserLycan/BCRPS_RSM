/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Andrei Samarita and Busano
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private String Type;

    /////////////////////////////////////////////////////////////
    /// Constructors
    public User(String username, String password, String Type) {
        this.username = username;
        this.password = password;
        this.Type = Type;
    }

    //////////////////////////////////////////////////////////////
    /// User-defined functions 
    private boolean verifyLogin(){
        return this.username.equals(username) && this.password.equals(password);
    }
    
    ///////////////////////////////////////////////////////////////
    /// Gettes and Setters
    public void setId(long id) {
        this.id = id;
    }
    
}
