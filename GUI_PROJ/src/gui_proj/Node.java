package gui_proj;

import java.util.ArrayList;
public class Node extends Thread {
    char tag;
    int id;

    Vector DV;
    Network network;

    Node(int id, Network n) {
        this.id=id;
        this.tag = (char) (id + 65);
        DV = n.getVector(id);
        network = n;
    }
    
    String getDV() {
        return DV.toString();
    }

    @Override
    public void run() {
        
        //per non far partire tutti i nodi insieme
        //attendo un tempo causale tra 1 e 4 secondi

        while(true){
            boolean posso = true;
            while (!network.canProceed()){
                if (posso) network.log.update("waiting\n", "Network status");
                posso = false;
                System.out.println ("waitin");
            }
            
            network.lock();
            network.log.update("working\n", "Network status");
            System.out.println ("");
            //chiedi a tutti i vicini il loro DV
            //li ricevo gia' aumentati del costo per arrivarci
            ArrayList<Vector> dvv=network.getDVV(id);

            boolean changed = false;
            for(Vector dv: dvv) {
                //aggiorna il tuo DV
                for(int i=0;i<dv.size();i++) {
                    if( (DV.get(i).archCost > dv.get(i).archCost ||
                        DV.get(i).archCost < 0) && 
                        dv.get(i).archCost > 0) {
                        DV.set(i,dv.get(i));
                        changed = true;
                    }
                }
            }
            if(changed) {
                //invia il tuo DV a tutti i vicini
                network.sendDV(id,DV);
            }
            
        }
    }
    private void attendi(double n) {
        attendi( (int)n );
    }
    private void attendi(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) { }
    }
}
