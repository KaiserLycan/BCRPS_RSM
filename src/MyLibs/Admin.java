/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;
import Managers.*;
/**
 *
 * @author Andrei Samarita and Busano
 */
public class Admin extends User implements IGenerateID{
    private UserManager um;
    private RealEstateManager rem;

    //////////////////////////////////////////////////////////////////
    /// Constructors
    public Admin(String username, String password) {
        super(username, password, "ADMIN");
    }


    ////////////////////////////////////////////////////////////////
    /// User defined functoins
    public void addRealEsate(RealEstate re) {
        rem.addRealEstate(re);
    }
    
    public void deleteRealEstate(RealEstate re) {
        rem.removeRealEstate(re);
    }
    
    public void registerNewAdmin(String username, String password, String confirmPassword) {
        um.registerUser(username, password, this, confirmPassword);
    }
    
    
    @Override
    public long generateId() {
        return 0l;
    }
    

    ///////////////////////////////////////////////////////////////////////////////////////
    /// Getters and Setters

    
}
