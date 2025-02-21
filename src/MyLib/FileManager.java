/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLib;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joseph Rey
 */
public class FileManager {
    private File file = null;
    private FileWriter writer = null;
    private Scanner scan = null;
    private boolean ignoreHeader;
    
    private char getChoice(String prompt) {
        char choice;
        scan = new Scanner(System.in);
        do {
            System.out.print(prompt);
            choice = scan.next().toLowerCase().charAt(0);
            
            if(choice != 'y' && choice != 'n') {
                System.out.println("Invalid Input. Try again...");
            }
        } while(choice != 'y' && choice != 'n');
        
        return choice;
    }
    
    public boolean openFile(String filename) {
        scan = new Scanner(System.in);
        char choice; 
        file = new File("./src/TextFiles/" + filename + ".txt");
        
        if(!file.exists()) {
            choice = getChoice("Do you want to create " + filename + ".txt?[y/n]: "); 
            if(choice == 'y') {
                this.createFile(file);
            }
            else {
                return false;
            }
        }
        
        return true;   
    }
    
    public void createFile(File file) {
        try{
            file.createNewFile();
            System.out.println( file.getName() + " has been created.");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    public void deleteFile() {
        if (file.delete()) {
            System.out.println(file.getName() + " has been deleted.");
        }
        else {
            System.out.println("Cannot delete file");
        }
    }
    
    public ArrayList<String[]> extractData(Boolean ignoreHeader) {
        ArrayList<String[]> table = new ArrayList<String[]>();
        this.ignoreHeader = ignoreHeader;
        
        
        try {
            scan = new Scanner(file);
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        while(scan.hasNextLine()) {
            if(this.ignoreHeader) {
                this.ignoreHeader = false;
                scan.nextLine();
                continue;
            }
            
            table.add(scan.nextLine().split("\t*\s"));
        }
        
        return table;
    }
    
    public void addData(Object object) {
        try {
            writer = new FileWriter(file, true);
            writer.append(object.toString());
            writer.close();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void removeData(Object object) {
        ArrayList<String[]> table = this.extractData(false);
        if(table.remove(object.toString().split("\t*\s"))) {
            System.out.println("Data '" + object.toString() + "' has been removed from " + file.getName());
        }
        else {
            System.out.println("Data '" + object.toString() + "' cannot be removed");
        }
    }
    
    public boolean dataExists(Object Object) {
        boolean exists = false;
        long objectID = Long.parseLong(Object.toString().split("\t*\s")[0]);
        ArrayList<String[]> table = this.extractData(false);
        
        for(String[] row : table) {
            if(row[0].equals(objectID)) {
                exists = true;
                break;
            }
        }
        
        return exists;
    }
    
    
    
}
