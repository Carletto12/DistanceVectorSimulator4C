package gui_proj;

//import java.awt.FlowLayout;
//import java.awt.GridLayout;

import java.awt.Rectangle;

//import java.awt.GridLayout;
import javax.swing.JFrame;

///import javax.swing.JInternalFrame;

public class GUI_PROJ {

    public static void main(String[] args) {
        JFrame pr = new JFrame();
        int w = 1500;
        int h = 1000;
        Rectangle bounds = new Rectangle(0, 0, w, h);
        pr.setBounds(bounds);
        pr.setResizable(true);
        pr.add(new MainPanel(bounds));
        pr.setVisible(true);
        pr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
