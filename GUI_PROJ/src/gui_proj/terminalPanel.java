/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_proj;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author User
 */
class terminalPanel extends JPanel{
    
    //private static Network network;
    
    public terminalPanel(/*Network network*/) {
        setBackground(Color.BLACK);
        setVisible(false);
        
    }
    
    public void changeVisibility(Boolean vis){
        setVisible(vis);
    }
    
    
}
