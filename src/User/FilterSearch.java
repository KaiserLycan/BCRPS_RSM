/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import RealEstate.Block;
import RealEstate.Lot;
import java.util.ArrayList;

/**
 *
 * @author Joseph Rey
 */
public class FilterSearch {
    private ArrayList<Block> filteredList;

    public FilterSearch(ArrayList<Block> filteredList) {
        this.filteredList = filteredList;
    }
    
    public FilterSearch filterByValues(String category, float min, float max) {
        ArrayList<Block> filteringList = new ArrayList<>();
        
        if(category.equals("price")) {
            for(Block block: filteredList) {
                filteringList.add(new Block());
                
                for(Lot lot: block.getLots()) {
                    if(lot.getPrice() >= min && lot.getPrice()  <= max) {
                        filteringList.getLast().setBlockNo(block.getBlockNo());
                        filteringList.getLast().getLots().add(lot);
                    }
                }
            }
        }
        else if(category.equals("size")) {
            for(Block block: filteredList) {
                filteringList.add(new Block());
                
                for(Lot lot: block.getLots()) {
                    if(lot.getSize() >= min && lot.getSize()  <= max) {
                        filteringList.getLast().setBlockNo(block.getBlockNo());
                        filteringList.getLast().getLots().add(lot);
                    }
                }
            }
        }
        
        filteredList = filteringList;
        
        return this;
    }
    
    public FilterSearch filterByLotType(String type) {
        ArrayList<Block> filteringList = new ArrayList<>();
        
        
        for(Block block: filteredList) {
            filteringList.add(new Block());

            for(Lot lot: block.getLots()) {
                if(lot.getType().equals(type)) {
                    filteringList.getLast().setBlockNo(block.getBlockNo());
                    filteringList.getLast().getLots().add(lot);
                }
            }
        }
        
        filteredList = filteringList;
            
        return this;
    }
    
    public FilterSearch filterByLotStatus(String status) {
        ArrayList<Block> filteringList = new ArrayList<>();
        
        
        for(Block block: filteredList) {
            filteringList.add(new Block());

            for(Lot lot: block.getLots()) {
                if(lot.getStatus().equals(status)) {
                    filteringList.getLast().setBlockNo(block.getBlockNo());
                    filteringList.getLast().getLots().add(lot);
                }
            }
        }
        
        filteredList = filteringList;
            
        return this;
    }

    public ArrayList<Block> getFilteredList() {
        return filteredList;
    }
    
}
