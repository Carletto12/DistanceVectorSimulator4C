package gui_proj;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUI_PROJ {
    public static void main(String[] args) {
        ImageIcon img = new ImageIcon("logo.png");
        JFrame pr = new JFrame("Distance Vector Simulator");
        pr.setIconImage(img.getImage());
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
