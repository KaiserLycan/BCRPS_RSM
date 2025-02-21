/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLib;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joseph Rey
 */
public class RealEstateManager {
    private ArrayList<RealEstate> listings;
    
    public boolean realEstateExists(RealEstate re) {
        return listings.contains(re);
    }
    
    public ArrayList<RealEstate> getListings() {
        return this.listings;
    }
    
    public void setListings(ArrayList<RealEstate> res) {
        this.listings = res;
    }
}
