/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realestate;

/**
 *
 * @author Andrei Samarita
 */
public class User {
    private String username;
    private String password;
    private Long id;
    private String Type;

    public User(String username, String password, Long id, String Type) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.Type = Type;
    }
    
    private boolean verifyLogin(){
    return true;
}
}
