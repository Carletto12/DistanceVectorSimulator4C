package gui_proj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


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
    }
    
    
    
    public void update (String s, String t){
        /*try {
            FileWriter myWriter = new FileWriter("log.txt");
            myWriter.append(j.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/
        Obj j = new Obj (t, s);
        try{
            Files.write(Paths.get("log.txt"), j.toString().getBytes(), StandardOpenOption.APPEND);

        } catch (IOException  e){
            
        }
         
    }
    
   
}
