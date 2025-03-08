package Payment;

import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrei Samarita
 */
public class Invoice {
    private float lotPrice;
    private float housePrice;
    private float deductibles;
    private LocalDate dataIssued;
 
    ////////////////////////////////////////////////////////////////////////
    ///Getters and Setters

    public float getLotPrice() {
        return lotPrice;
    }

    public void setLotPrice(float lotPrice) {
        this.lotPrice = lotPrice;
    }

    public float getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(float housePrice) {
        this.housePrice = housePrice;
    }

    public LocalDate getDataIssued() {
        return dataIssued;
    }

    public void setDataIssued(LocalDate dataIssued) {
        this.dataIssued = dataIssued;
    }
    public float computeTotalPrice () {
        return housePrice + lotPrice; 
    }

    public float getDeductibles() {
        return deductibles;
    }

    public void setDeductibles(float deductibles) {
        this.deductibles = deductibles;
    }
    
    
}
