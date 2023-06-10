package controllers;

import java.io.FileWriter;
import java.io.IOException;

import model.Toy;

public class WriteFile {

    public static void WrFile (String fName, Toy toy) {
        
        try(FileWriter writer = new FileWriter(fName, true))
        {
            String text = toy.toString();
            writer.write(text);
            writer.append('\n');
                         
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 

    }
}
