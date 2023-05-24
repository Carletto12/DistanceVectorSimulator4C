package gui_proj;

import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements ComponentListener{
    private Log log;
    private BoxPanel toolbar; 
    static SrPanel schemaDiRete;
    static MaPanel matriceDiAdiacenza;  
    static VdPanel vettoriDistanza;
    
    private Network network;
    
    MainPanel(Rectangle bounds) {
        super();
        log = new Log ();
        network = new Network ();
        
        schemaDiRete = new SrPanel(network);             
        matriceDiAdiacenza = new MaPanel(network);             
        vettoriDistanza = new VdPanel(network);       
        toolbar = new BoxPanel(network);
        
        setLayout(null);
        setBounds(bounds);
        
        updateSize(bounds);
        
        add(toolbar);
        add(schemaDiRete);
        add(matriceDiAdiacenza);
        add(vettoriDistanza);
        
        addComponentListener(this);
    }
    
    private void updateSize(Rectangle b) {
        final int h = b.height;
        final int w = b.width;
        final int l = (w-200)/2;
        toolbar.setBounds(0, 0, 200, h);
        schemaDiRete.setBounds(200, 0, l, h);
        matriceDiAdiacenza.setBounds(200+l, 0, l, h);
        vettoriDistanza.setBounds(200+l, 0, l, h);   
    }
    

    @Override
    public void componentResized(ComponentEvent ce) {
        updateSize(getBounds());
    }

    @Override
    public void componentMoved(ComponentEvent ce) {}

    @Override
    public void componentShown(ComponentEvent ce) {}

    @Override
    public void componentHidden(ComponentEvent ce) {}
    
}
