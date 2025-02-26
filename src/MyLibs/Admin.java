/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realestate;

/**
 *
 * @author Andrei Samarita and Busano
 */
public class Admin extends User{
    private UserManager um;
    private RealEstateManager rem;

    public Admin(String username, String password) {
        super(username, password);
    }

    public void addRealEstate(RealEstate re){}
    
    public void removeRealEstate(RealEstate re){}

    public void changeRealEstatePrice(Long RealEstateID, float price){}

    public void viewUsersInformation(){}
    
    public void registerNewAdmin(String username, String password, String confirmpassword){}
    
    
}
