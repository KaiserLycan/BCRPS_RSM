package Payment;

import java.time.LocalDate;

import RealEstate.Lot;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrei Samarita
 */
public class Invoice {
    private Lot lot;
    private float deductibles;
    private LocalDate dataIssued;
 
    public Invoice(Lot lot) {
        this.lot = lot;

    }

    ////////////////////////////////////////////////////////////////////////
    ///Getters and Setters
    public LocalDate getDataIssued() {
        return dataIssued;
    }

    public void setDataIssued(LocalDate dataIssued) {
        this.dataIssued = dataIssued;
    }

    public float getDeductibles() {
        return deductibles;
    }

    public void setDeductibles(float deductibles) {
        this.deductibles = deductibles;
    }

    public Lot getLot() {
        return lot;
    }

    
    
    
}
