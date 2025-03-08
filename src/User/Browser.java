/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import RealEstate.Block;
import java.util.ArrayList;

/**
 *
 * @author Joseph Rey
 */
public class Browser {
    private ArrayList<Block> listings;
    private FilterSearch filter;

    public ArrayList<Block> getListings() {
        return listings;
    }

    public void setListings(ArrayList<Block> listings) {
        this.listings = listings;
    }

    public FilterSearch getFilter() {
        return filter;
    }

    public void setFilter(FilterSearch filter) {
        this.filter = filter;
    }
    
    
}
