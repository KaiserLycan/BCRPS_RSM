/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import RealEstate.Block;
import RealEstate.Lot;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joseph Rey
 */
public class Browser {
    private ArrayList<Block> listings;
    private FilterSearch filter;

    public void viewListings(DefaultTableModel table, boolean filtered) {
        table.setRowCount(0);

        if(filtered) {
            for(Block block : filter.getFilteredList()) {
                for(Lot lot : block.getLots()) {
                table.addRow(new Object[] { String.valueOf(lot.getRealEstateID()), String.format("%.2f", lot.getPrice()), String.format("%.2f", lot.getSize()), String.valueOf(block.getBlockNo()), String.valueOf(lot.getLotNo()), lot.getStatus().toUpperCase(), lot.getType().toUpperCase(), lot.getHouse().getClass().getSimpleName()  });
                }
            }
        }
        else {
            for(Block block : listings) {
                for(Lot lot : block.getLots()) {
                    table.addRow(new Object[] { String.valueOf(lot.getRealEstateID()), String.format("%.2f", lot.getPrice()), String.format("%.2f", lot.getSize()), String.valueOf(block.getBlockNo()), String.valueOf(lot.getLotNo()), lot.getStatus().toUpperCase(), lot.getType().toUpperCase(), lot.getHouse().getClass().getSimpleName() });
                }
            }
        }
    }

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
