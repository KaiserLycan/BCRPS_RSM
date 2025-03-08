/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealEstate;

import java.util.ArrayList;

/**
 *
 * @author Joseph Rey
 */
public class Block {
    private int blockNo;
    private ArrayList<Lot> lots = new ArrayList<>();

    
    /////////////////////////////////////////////////////////////////////
    /// Getters and Setters
    public int getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(int blockNo) {
        this.blockNo = blockNo;
    }

    public ArrayList<Lot> getLots() {
        return lots;
    }

    public void setLots(ArrayList<Lot> lots) {
        this.lots = lots;
    }
    
    
    
    
}
