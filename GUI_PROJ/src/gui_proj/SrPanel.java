package gui_proj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

class SrPanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener{
    private Network network;
    int[][] ma;
    ArrayList<Nodo> nodi;
    private int x, y;
    private Nodo selectedNode;
    
    public SrPanel(Network n) {
        network = n;
        ma = network.getMA();
        nodi = new ArrayList <>();
        for (int i = 0; i<ma.length; i++){
            char c = (char)('A'+i);
            Nodo x = new Nodo (c+"",0, 0, i);
            nodi.add(x);
        }
        tryLoadNodePos("nodePos.csv");
        setBounds(550, 250, 550, 1000);
        setVisible(true);
        selectedNode=null;
        addMouseListener(this);
        addMouseMotionListener(this);
        
        String b = "SchemaRete";
        Border border1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE , 2), b);
        this.setBorder(border1); 
    }
    
    private void tryLoadNodePos(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            int n;
            String riga = br.readLine();
            n = Integer.parseInt(riga);
            for(int i=0;i<n;i++) {
                riga = br.readLine();
                String[] p = riga.split(",");
                int x= Integer.parseInt(p[0].trim());
                int y= Integer.parseInt(p[1].trim());
                nodi.get(i).x=x;
                nodi.get(i).y=y;
            }
        }catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void changeVisibility(Boolean vis){
        setVisible(vis);
    }
    
    void disegnaArco(Graphics g, int i, int j) {
        g.drawLine(nodi.get(i).x, nodi.get(i).y, 
                nodi.get(j).x, nodi.get(j).y);
        int x = (nodi.get(i).x+nodi.get(j).x)/2;
        int y = (nodi.get(i).y+nodi.get(j).y)/2;
        g.drawString(ma[i][j]+"", x, y);
    }
    
    void disegna(Graphics g) {
        Font font = new Font("Arial", Font.PLAIN, Nodo.R*3/4);
        g.setFont(font);
        for(int i=0;i<ma.length;i++)
            for(int j=i+1;j<ma[i].length; j++)
                if(ma[i][j]>-1)
                    disegnaArco(g, i,j);
        
        font = new Font("Arial", Font.PLAIN, Nodo.R);
        g.setFont(font);
        
        for(Nodo nodo : nodi)
            nodo.disegna(g);
    }
    
    private void saveNodePos(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.write(ma.length+"\n");
            for(int i=0;i<ma.length;i++) {
                Nodo n = nodi.get(i);
                fw.write(n.x+","+n.y+"\n");
            }
            bw.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    void pressed(int x, int y) {
        for(Nodo nodo : nodi)
            if(nodo.contiene(x,y))
                selectedNode = nodo;
        if(selectedNode!=null) {
            this.x=x;
            this.y=y;
        }
    }

    void released(int x, int y) {
        if(selectedNode!=null)
            saveNodePos("nodePos.csv");
        selectedNode=null;
    }

    void dragged(int x, int y) {
        if(selectedNode==null) return;
        int dx = x-this.x;
        int dy = y-this.y;
        selectedNode.x += dx;
        selectedNode.y += dy;
        this.x=x;
        this.y=y;
    }
    
    @Override 
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        disegna(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed(e.getX(),e.getY());
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        released(e.getX(),e.getY());
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dragged(e.getX(),e.getY());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
