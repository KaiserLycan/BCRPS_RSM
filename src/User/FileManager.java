package User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrei Samarita
 */
public class FileManager {
    private File file; // File reference
    private ArrayList<String[]> data;
    
    //////////////////////////////////////////////////////////////////////////
    ///Constructor
    public FileManager (File file) {
        this.file = file;
    }
    
    
    //////////////////////////////////////////////////////////////////////////
    ///User-defined methods
    public ArrayList<String[]> extractData() {
       data = new ArrayList<>();
       String[] header;
       int id;
       try(Scanner reader = new Scanner(file)) {
           while(reader.hasNext()) {
               data.add(reader.nextLine().split((",")));
           }
       }
       catch(IOException ex) {
           ex.printStackTrace();
       }
       
       return data;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    private void rewriteFile(ArrayList<String[]> data) {
        try (FileWriter writer = new FileWriter(file)) {
            for(String[] row: data) {
                writer.append(String.join(",", row) + "\n");
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    //////////////////////////////////////////////////////////////////////////
    public void setHeader(String[] header) {
        data = this.extractData();
        int id;
        
        try{
            if(!data.isEmpty()) {
                id = Integer.parseInt(data.get(0)[0]);
            }
            data.addFirst(header);
        }
        catch(NumberFormatException ex) {
            data.remove(0);
            data.addFirst(header);
        }
        
        this.rewriteFile(data);
        System.out.println("Header {" + String.join(" ", header) + "}, has been set");
    }
    
   ////////////////////////////////////////////////////////////////////////////
    private boolean IDexists(int id) {
        data = this.extractData();
        boolean exists = false;
        int recordedId;
        
        for(String[] row : data) {
            if(data.get(0).equals(row)) {
                continue;
            }
            
            recordedId = Integer.parseInt(row[0]);
            if(recordedId == id) {
                exists = true;
                break;
            }
        }
        
        return exists;
    }
    
    //////////////////////////////////////////////////////////////////////////
    public void addData(String[] newData) {
        data = this.extractData();
        int id;
        
        if(file.length() == 0) {
            String[] header = new String[newData.length];
            header[0] = "ID";
            this.setHeader(header);
        }
        
        try{
            id = Integer.parseInt(newData[0]);
            
            if(!this.IDexists(id)) {
                data.add(newData);
                this.rewriteFile(data);
            }
        }
        catch(NumberFormatException ex) {
            System.out.println("Error: Data does not have an id");
            ex.printStackTrace();
        }
        
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public void removeData(int id) {
        data = this.extractData();
        int recordedId;
        
        for(String[] row: data) {
            if(data.get(0).equals(row)) {
                continue;
            }
            
            recordedId = Integer.parseInt(row[0]);
            if(id == recordedId) {
                data.remove(row);
                this.rewriteFile(data);
                break;
            }
        }
        
    }
 
    
    public void updateData(int id, String category, String newData) {
        data = this.extractData();
        boolean firstRun = true;
        ArrayList<String[]> updatedData = data;
        String[] header = data.get(0);
        
        String[] recordedData;
        int recordedId;
        int columnNo = 0;
        
        for(int i = 0; i < header.length; i++) {
            if(header[i].equals(category)) {
                columnNo = i; 
                break;
            }
        }
        
        for(String[] row : data) {
            if(firstRun) {
                firstRun = false;
                continue;
            }
            
            recordedData = row;
            recordedId = Integer.parseInt(row[0]);
            if(recordedId == id) {
                recordedData[columnNo] = newData;
                updatedData.remove(row);
                updatedData.add(recordedData);
                this.rewriteFile(updatedData);
            }
        }
    }
}
