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
    private ArrayList<Block> unfilteredList;
    
    public FilterSearch(ArrayList<Block> unfilteredList) {
        this.filteredList = unfilteredList;
        this.unfilteredList = unfilteredList;
    }
    
    
    
    public FilterSearch filterStatus(String status) {
        ArrayList<Block> filteringList = new ArrayList<>();

        if(status.equals("all")) {
            return this;
        }
        
        for(Block block : filteredList) {
            filteringList.add(new Block());
            for(Lot lot: block.getLots()) {
                if(lot.getStatus().toLowerCase().equals(status)) {
                    filteringList.getLast().setBlockNo(block.getBlockNo());
                    filteringList.getLast().getLots().add(lot);                }
            }
        }
        
        filteredList = filteringList;
        return this;
    }
    
    public FilterSearch filterLotType(String type) {
        ArrayList<Block> filteringList = new ArrayList<>();
        
        if(type.equals("all")) {
            return this;
        }
        
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
    
    public FilterSearch filterValues(String category, float min, float max) {
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
    
    public FilterSearch filterByHouse(int house) {
        ArrayList<Block> filteringList = new ArrayList<>();

        if(house == 0) {
            return this;
        }
        
        for(Block block: filteredList) {
            filteringList.add(new Block());

            for(Lot lot: block.getLots()) {
                if(lot.getHouse() != null) {
                    if(lot.getHouse().getType() == house) {
                    filteringList.getLast().setBlockNo(block.getBlockNo());
                    filteringList.getLast().getLots().add(lot);
                    }
                }
            }
        }

        
        filteredList = filteringList;
        return this;
    }

    

    
    public void resetFilter () {
        filteredList = unfilteredList;
    }
    
    public ArrayList<Block> getFilteredList() {
        return filteredList;
    }
}
