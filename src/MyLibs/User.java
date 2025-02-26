/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Andrei Samarita and Busano
 */
public class User implements IGenerateID{
    private long id;
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
    public boolean verifyLogin(String username1, String password1){
        return this.username.equals(username) && this.password.equals(password);
    }
    
    
    @Override
    public long generateId() {
        return 0l;
    }
    ///////////////////////////////////////////////////////////////
    /// Gettes and Setters
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    
    
}
