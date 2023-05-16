/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_proj;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
class BoxPanel extends JPanel implements ActionListener{
    private Network network;
    Button matrixB = new Button("matrix");
    Button stepB = new Button("step");     //button avanzamento
    Button checkB = new Button("check");
    
    public BoxPanel(Network n) {
      network = n;
      BoxLayout bl1 = new BoxLayout(this, BoxLayout.Y_AXIS);
      this.setLayout(bl1);
      matrixB.addActionListener(this);
      stepB.addActionListener(this);
      checkB.addActionListener(this);
      this.setBackground(Color.LIGHT_GRAY);
      this.add(matrixB);
      this.add(stepB);
      this.add(checkB); 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==matrixB){
            System.out.println("MatrixB");
            MainPanel.matriceDiAdiacenza.changeVisibility(true);
            MainPanel.vettoriDistanza.changeVisibility(false);
        }
        
        if(ae.getSource()==stepB){
            System.out.println("StepB");
            if(MainPanel.matriceDiAdiacenza.isVisible()){
                network.unlock();
            }
            
        }
        if(ae.getSource()==checkB){
            System.out.println("checkB");
            MainPanel.vettoriDistanza.changeVisibility(true);
            //MainPanel.terminal.changeVisibility(false);
            MainPanel.matriceDiAdiacenza.changeVisibility(false);
        }
   
        
    }

    
    
    
}
