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

/**
 * This class handles access or any modifications done to a text files stored in the TextFiles folder.
 * 
 */
public class FileManager {
    //This value is not allowed to change in any part 
    //of the program aside from the instantiation.
    private final File file;    
    //This is used to ignore the header of the 
    //table stored in the textfile.
    private boolean ignoreHeader; 
    
    ////////////////////////////////////////////////////////////////////////////
    //Constructor
    /**
     * @param file Requires an existing file.
     */
    public FileManager(File file) {
        this.file = file;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // User-Define Methods
    
    /**
     * Extracts/Access the data stored in the text file.
     * @param ignoreHeader  If TRUE extract file content. If FALSE extract file content and header.
     * @return ArrayList<String[]>  List of rows containing columns of data extracted from the file
     */
    public ArrayList<String[]> extractData(boolean ignoreHeader) {
        ArrayList<String[]> table = new ArrayList<>(); //List to return
        this.ignoreHeader = ignoreHeader;
        
        try (Scanner scan = new Scanner(file)) {
            while(scan.hasNextLine()) {
            if(this.ignoreHeader) {
                this.ignoreHeader = false;
                scan.nextLine();
                continue;
            }
            table.add(scan.nextLine().split("\\t+\\s"));
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        return table;
    }
    
    /**
     * Checks if the data exists in the file.
     * If the textFile consist of only header the method will automatically
     * return FALSE.
     * @param data An instance of a class that implements IGenerateID inteface.
     * @return Boolean  TRUE if the ID of the data exist or a copy of the conent
     *                  of the data exist in the text file. FALSE if both are
     *                  not true.
     */
    
    public boolean dataExists(IGenerateID data) {
        ArrayList<String[]> table = this.extractData(true);
        boolean exists = false;
        long contentID;
        String[] content;
        
        if(table.isEmpty()) {
            return false;
        }

        content = new String[table.get(0).length - 1];
        
        for(String[] row : table) {
            
            //Convert the content ID from String to Long
            try{
                contentID = Long.parseLong(row[0]);
            }
            catch(NumberFormatException ex) {
                System.out.println(ex.getMessage());
                break;
            }
            
            //Checkes if user exist based on ID if not then check if the content
            //has existing copies.
            if(contentID == data.getID()) {
                exists = true;
                break;
            }
            else {
                /*
                How does this work?
                Ignoring the id, this program will make a copy of the conent
                of the current row. Which later will be turned into a string
                and compared to the cotnent of the data parameter.
                
                Essentially the code below is the better implementation of this:
                for(int i = 1; i < row.length; i++) {
                    dataConent = dataConent + row[i];
                    if(!(i == row.length-1)) {
                     dataConent = dataConent + "\t\t\t";
                    }
                }
                if(content.equals(data.toString())) {
                    exists = true;
                    break;
                }
                */
                System.arraycopy(row, 1, content, 0, row.length-1);
                if(data.toString().equals(String.join("\t\t\t", content))) {
                    exists = true;
                    break;
                }
                
            }
        }
        
        return exists;
    }
    
    /**
     * Appends data onto the file but only if the data doesn't already exist.
     * @param  data an instance of a class that implements IGenerateID interface
     */
    public void addData(IGenerateID data) {
        if(!this.dataExists(data)) {
            /*
            How does this work?
            Objects like FileWriter and Scanner needs to be closed to avoid
            data leakage and sometimes require exception handling. 
            This syntax. also known as try-with-resources, automatically closes
            the resources (e.g. FileWriter), while also handling exceptions.
            */
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.append( data.getID() + "\t\t\t"+ data.toString() + '\n');
            }
            catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Data has been added");
        }
        else {
            System.out.println("Cannot add existing data.");
        }
    }
    
    /**
     * Changes the values of data in the file but only if it exist.
     * @param data an instance of a class that implements IGenerateID interface.
     */
    public void updateData(IGenerateID data) {
        ArrayList<String[]> table = this.extractData(false);
        String[] content = data.toString().split("\\t+\\s");
        long contentID = 0l;
        
        if(this.dataExists(data)) {
            ignoreHeader = true;
            for(String[] row : table) {
                if(ignoreHeader) {
                    ignoreHeader = false;
                    continue;
                }
                
                try {
                    contentID = Long.parseLong(row[0]);
                }
                catch(NumberFormatException ex) {
                    ex.printStackTrace();
                }
                
                if(contentID == data.getID()) {
                    /*
                    This code below essentially copies the components of from 
                    conent array starting at it's first to last componets 
                    onto the array[] that matches the ID of the data.
                    
                    Essentially it is the better implmentation of this code:
                    for(int j = 0; j < content.size; j++) {
                        row[j+1] = content[0];
                    }
                    */
                    System.arraycopy(content, 0, row, 1, content.length);
                }
            }
            
            // Re-write the entire file but with the udpated data.
            try (FileWriter writer = new FileWriter(file)) {
                for(String[] row: table) {
                    writer.append(String.join("\t\t\t", row) + '\n');
                }
            }
            catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("File Updated");
            
        }
        else {
            System.out.println("Cannot udpate non-existing data.");
        }
    }
    
    /**
     * Removes data from the file but only if it has not have already been removed.
     * @param data an instance of a class that implements IGeneratedID
     */
    public void removeData(IGenerateID data) {
        ArrayList<String[]> table = this.extractData(false);
        long contentID = 0l;
        ignoreHeader = true;
        if(this.dataExists(data)) {
            //Remove the data from the extracted data.
            for(int i = 1; i < table.size(); i++) {
                try{
                    contentID = Long.parseLong(table.get(i)[0]);
                }
                catch(NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
                
                if(contentID == data.getID()) {
                    table.remove(i);
                    break;
                }
            }
            
            
            //Re-write the file but without the removed data.
            try (FileWriter writer = new FileWriter(file)) {
                for(String[] row : table) {
                    writer.append(String.join("\t\t\t", row) + '\n');
                }
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
            System.out.println("Data has been removed");
        }
        else {
            System.out.println("Data has already been removed.");
        }
    }
}// end of FileManager Class
