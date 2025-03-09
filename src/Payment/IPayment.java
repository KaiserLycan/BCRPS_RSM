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
public interface IPayment {
    public Invoice pay(Lot lot);
}
