package gui_proj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

class VdPanel extends JPanel {
    private Network network;
    private ArrayList<Node> nodes;

    public VdPanel(Network n) {
        network = n;
        setVisible(false);
        String b = "VectorDistance";
        Border border1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2), b);
        this.setBorder(border1);
        nodes = network.getNodes();
    }

    public void changeVisibility(Boolean vis) {
        setVisible(vis);
    }

    public void drawDV(Graphics g) {
        Font f = new Font("Arial", Font.BOLD, 18);
        g.setFont(f);
        int w = 100;
        int [][] m = network.nma;
        for (int i = 0 ;i<m.length; i++){
            for (int j = 0; j< m[i].length; j++){
                char p = (char) (i+ 'A');
                char d = (char) (j+ 'A');
                g.drawString (p+"->"+ d + ":" + m[i][j] , 150+100*j, 300+50*i);
            }
        }
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDV(g);
    }
}