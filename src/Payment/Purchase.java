/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment;

import RealEstate.Lot;
import java.time.LocalDate;

/**
 *
 * @author Joseph Rey
 */
public class Purchase implements IPayment{

    @Override
    public Invoice pay(Lot lot) {
        Invoice invoice = new Invoice();
        invoice.setDataIssued(LocalDate.now());
        invoice.setLotPrice(lot.getPrice());
        if(lot.getHouse() != null) {
            invoice.setHousePrice(lot.getHouse().getHousePrice());
        }
        else {
            invoice.setHousePrice(0);
        }
        invoice.setDeductibles(0);
        
        return invoice;
    }
    
}
