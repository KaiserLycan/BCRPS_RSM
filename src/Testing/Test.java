/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testing;

import Database.FileManager;
import Admin.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Joseph Rey
 */
public class Test {
    public static void main(String[] args) throws IOException {  
        FileManager fm = new FileManager();
        Admin kai = new Admin("Kaiser", "1234");
        kai.setFmanager(fm);
        kai.retrieveRestateData("realEstateTable");
        for (RealEstate re : kai.getListing()) {
            re.printInfo();
            System.out.println("");
        }
        
        for (RealEstate re : kai.getListing()) {
            re.printInfo();
            System.out.println("");
        }
        
        fm.addUserData("UsersTable", kai);
        
    }
}
