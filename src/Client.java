/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author busan
 */
public class Client {
    
}
public class Client extends User {
    public List<RealEstate> realEstate;

    public Client(String username, String password) {
        super(username, password);
        realEstate = new ArrayList<>();
    }
    public void buyRealEstate(RealEstate re) {
    }
    public void reserveRealEstate(RealEstate re) {
    }
}