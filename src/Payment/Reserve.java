/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment;

import java.io.File;
import java.time.LocalDate;

import RealEstate.Block;
import RealEstate.ConcreteHouseFactory;
import RealEstate.Lot;
import User.Admin;
import User.FileManager;

/**
 *
 * @author Joseph Rey
 */
public class Reserve implements IPayment {
    Admin admin = new Admin("Master", "Master");
    float deductedAmount;
    
    public Reserve(float deductedAmount) {
        admin.setReFm(new FileManager(new File("./src/TextFiles/realestate.txt")));
        admin.setHouseFacatory(new ConcreteHouseFactory());
        admin.refreshBlocks();
        this.deductedAmount = deductedAmount;
    }
    
    public Invoice pay(int blockNo, Lot lot) {
        
        Invoice invoice = new Invoice(lot);
        invoice.setDataIssued(LocalDate.now());
        invoice.setDeductibles(lot.getPrice() * 0.5f);
        
        for(Block block : admin.getBlocks()) {
            for(Lot xlot: block.getLots()) {
                if(xlot.getLotNo() == lot.getLotNo()) {
                    admin.updateLot(blockNo, xlot.getLotNo(), "status", "reserved" );
                    break;
                }
            }
        }
        
        return invoice;
    }
}
