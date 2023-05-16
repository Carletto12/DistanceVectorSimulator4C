/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_proj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;


class MaPanel extends JPanel{
    private Network network;
    
    public MaPanel(Network n) {
        network = n;
        setVisible(true);
        String b = "Matrix";
        Border border1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED , 2), b);
        this.setBorder(border1);
    }
    
    public void changeVisibility(Boolean vis){
        setVisible(vis);
    }
    
    public void dis(int[][] ma , Graphics g){
        Font f = new Font ("Arial", Font.BOLD, 18);
        g.setFont(f);
        int w = ma.length*50; 
        int x = getWidth()/2;
        int y = getHeight()/2;
        for(int i=0; i<ma.length;i++){
            int nx=x-w/2, ny=y-w/2+50*i;
            for(int j=0; j<ma[i].length; j++){
                g.drawString(ma[i][j]+"", nx+50*j, ny);
            }
        }
    }
    
    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        dis(network.nma, g);
    }
}
