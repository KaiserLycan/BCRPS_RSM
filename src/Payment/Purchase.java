/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment;

import RealEstate.Block;
import RealEstate.ConcreteHouseFactory;
import RealEstate.Lot;
import User.Admin;
import User.FileManager;

import java.io.File;
import java.time.LocalDate;

/**
 *
 * @author Joseph Rey
 */

public class Purchase implements IPayment{
    Admin admin = new Admin("Master", "Master");

    public Purchase() {
        admin.setReFm(new FileManager(new File("./src/TextFiles/realestate.txt")));
        admin.setHouseFacatory(new ConcreteHouseFactory());
        admin.refreshBlocks();
    }

    @Override
    public Invoice pay(int blockNo, Lot lot) {
        Invoice invoice = new Invoice(lot);
        invoice.setDataIssued(LocalDate.now());
        invoice.setDeductibles(0);
        
        for(Block block : admin.getBlocks()) {
            for(Lot xlot: block.getLots()) {
                if(xlot.getLotNo() == lot.getLotNo()) {
                    admin.updateLot(blockNo, xlot.getLotNo(), "status", "sold" );
                    break;
                }
            }
        }
        
        return invoice;
    }
    
}
