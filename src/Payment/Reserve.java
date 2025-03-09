/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment;

import RealEstate.Lot;

/**
 *
 * @author Joseph Rey
 */
public class Reserve implements IPayment {
    float deductedAmount;
    
    public Reserve(float deductedAmount) {
        this.deductedAmount = deductedAmount;
    }
    
    public Invoice pay(Lot lot) {
        Invoice invoice = new Invoice();
        invoice.setLotPrice(lot.getPrice());
        invoice.setHousePrice(lot.getHouse().getHousePrice());
        invoice.setDeductibles(0);
        
        return invoice;
    }
}
