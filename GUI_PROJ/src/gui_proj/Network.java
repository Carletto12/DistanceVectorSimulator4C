package gui_proj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Network {
    private ArrayList<Node> nodes; 
    private int[][] ma; 
    int NODE_QUANTITY;
    int nma [][]; 
    private String csvFileName;
    private boolean daiOra;
    public String status;
    Log log;

    private void init() {
        lock();
        nodes = new ArrayList<>();
        initMA();                                               
        initNodes();
        nma = new int [NODE_QUANTITY][NODE_QUANTITY];
        
        for (int i = 0; i<NODE_QUANTITY; i++)
            for(int j=0;j<NODE_QUANTITY;j++)
                nma[i][j]=ma[i][j];
        
        printMatrix();
        
        for (Node n : nodes)
            n.start();
    }

    public Network() {
        log = new Log ();
        csvFileName = "matS.csv";
        init();
    }
    public Network(String csvFileName) {
        this.csvFileName = csvFileName;
        init();
    }

    private void initMA() {
        try {
            FileReader fr = new FileReader("coCazz.csv");
            BufferedReader br = new BufferedReader(fr);
            String riga = br.readLine();
            NODE_QUANTITY = Integer.parseInt(riga);
            ma = new int[NODE_QUANTITY][NODE_QUANTITY];
            for (int i = 0; i < NODE_QUANTITY; i++) {
                riga = br.readLine();
                String[] p = riga.split(",");
                for (int j = 0; j < NODE_QUANTITY; j++)
                    ma[i][j] = Integer.parseInt(p[j].trim());
            }


        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public boolean canProceed (){
        return daiOra;
    }

    public void unlock (){
        daiOra = true;
    }

    public void lock (){
        daiOra = false;
    }


    private void initNodes() {
        for (int i = 0; i < NODE_QUANTITY; i++)
            nodes.add(new Node(i, this));
    }

    public synchronized Vector getVector(int id) {
        Vector dv = new Vector();
        for (int i = 0; i < ma[id].length; i++)
            dv.add(ma[id][i], id);
        return dv;
    }

    public synchronized void sendDV(int id,Vector dv) {
        System.out.println("Nodo "+(char)(id+'A')+" invia il suo DV: "+dv);
        for (int i = 0; i < nma[id].length; i++)
            nma[id][i] = dv.get(i).archCost;
        status = printMatrix();
        MainPanel.matriceDiAdiacenza.repaint();
        log.update("" + printMatrix(), "Network update\n");
        MainPanel.vettoriDistanza.repaint();
    }
    
    public synchronized ArrayList<Vector> getDVV(int id) {
        ArrayList<Vector> dvv = new ArrayList<>();
        for (int i = 0; i < ma[id].length; i++) {
            if(ma[id][i] < 1)
                continue;
            Vector dv = new Vector();
            for (int j = 0; j < nma[id].length; j++) {
                int costo_aggiuto = nma[i][j]+nma[id][i];
                if(nma[i][j]<0 || nma[id][i]<0)
                    costo_aggiuto = -1;
                if(id==j)
                    costo_aggiuto = 0;
                dv.add(costo_aggiuto, i);
            }
            dvv.add(dv);
        }
        return dvv;
    }
    
    public String printMatrix (){
        String s = "";
        for (int i = 0; i<nma.length; i++){
            s+= "\t"+(char) (i+65);
        }
        s+= "\n";
        for (int i = 0; i<nma.length; i++){
            s+= (char) (i+65)+"\t";
            for (int h = 0; h<nma[i].length; h++){
                s+= nma[i][h] + "\t";
            }
            s+= "\n";
        }
        s+= "\n";
        return s;
    }
    
    public int [][] getMA (){
        return ma;
    }
    
    public ArrayList <Node> getNodes (){
        ArrayList <Node> nl = new ArrayList ();
        for (Node n : nodes){
            nl.add(n);
        }
        return nl;
    }
}