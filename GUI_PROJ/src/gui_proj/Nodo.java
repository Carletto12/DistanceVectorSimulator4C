package gui_proj;

import java.awt.Color;
import java.awt.Graphics;

class Nodo {
    String nome;
    int x, y;
    int n;

    static int R=30;
    Nodo(String nome, int x, int y, int n) {
        this.nome = nome;
        this.x=x;
        this.y=y;
        this.n=n;

    }
    void disegna(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x-R, y-R, R*2, R*2);
        g.setColor(Color.black);
        g.drawOval(x-R, y-R, R*2, R*2);
        g.drawString(nome, x-R/2, y+4*R/10);        
    }

    private double dist2(int x, int y) {
        return (this.x-x)*(this.x-x) + (this.y-y)*(this.y-y);
    }
    
    boolean contiene(int x, int y) {
        return dist2(x,y)<=R*R;
    }
    
}
