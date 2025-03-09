/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import RealEstate.Block;
import RealEstate.Lot;
import java.text.DecimalFormat;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joseph Rey
 */
public class Browser {
    private ArrayList<Block> listings;
    private FilterSearch filter;

    
    public Browser(ArrayList<Block> listings, FilterSearch filter) {
        this.listings = listings;
        this.filter = filter;
    }
    
    public void viewListings(DefaultTableModel table, boolean filtered) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        
        if(listings.isEmpty()) {
            return;
        }

        table.setRowCount(0);
        
        if(filtered) {
            for(Block block : filter.getFilteredList()) {
                for(Lot lot : block.getLots()) {
                    table.addRow(new Object[] { String.valueOf(lot.getRealEstateID()), df.format(lot.getPrice()), df.format(lot.getSize()), String.valueOf(block.getBlockNo()), String.valueOf(lot.getLotNo()), lot.getStatus().toUpperCase(), lot.getType().toUpperCase(), String.join(" ", lot.getHouse().getClass().getSimpleName().split("(?=[A-Z])"))  });
                }
            }
        }
        else {
            for(Block block : listings) {
                for(Lot lot : block.getLots()) {
                    table.addRow(new Object[] { String.valueOf(lot.getRealEstateID()), df.format(lot.getPrice()), df.format(lot.getSize()), String.valueOf(block.getBlockNo()), String.valueOf(lot.getLotNo()), lot.getStatus().toUpperCase(), lot.getType().toUpperCase(), String.join(" ", lot.getHouse().getClass().getSimpleName().split("(?=[A-Z])"))  });
                }
            }
        }
    }

    public void setListings(ArrayList<Block> listings) {
        this.listings = listings;
    }


    public ArrayList<Block> getListings() {
        return listings;
    }

    public FilterSearch getFilter() {
        return filter;
    }
    

    
    
}
