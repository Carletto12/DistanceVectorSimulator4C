package gui_proj;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;

class Log {
    File log;
    
    class Obj {
        String timeStamp;
        String title, description;
        Obj (String t, String d){ 
            title = t;
            description = d;
            timeStamp = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new java.util.Date());
        }
        
        @Override 
        public String toString (){
            return timeStamp +" " + title + " " + description;
        }
    }
    
    Log (){
        log = new File ("log.txt");
        try{
            PrintWriter writer = new PrintWriter("log.txt");
            writer.print("");
            writer.close(); 
        } catch (Exception e){
            System.out.println ("Qualcosa è andato storto");
        }
    }
    
    public void update (String s, String t){
        Obj j = new Obj (t, s);
        try{
            Files.write(Paths.get("log.txt"), j.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException  e){
            System.out.println ("Failed to write on file");
        } 
    }
}