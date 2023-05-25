
package gui_proj;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

class BoxPanel extends JPanel implements ActionListener {
    private Network network;
    Button matrixB = new Button("matrix");
    Button stepB = new Button("step");
    Button checkB = new Button("check");

    public BoxPanel(Network n) {
        network = n;
        BoxLayout bl1 = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(bl1);
        stepB.setFont(new Font("Arial", Font.PLAIN, 40));
        stepB.setFont(new Font("Arial", Font.PLAIN, 40));
        checkB.setFont(new Font("Arial", Font.PLAIN, 40));

        matrixB.addActionListener(this);
        stepB.addActionListener(this);
        checkB.addActionListener(this);

        setBackground(Color.LIGHT_GRAY);

        add(matrixB);
        add(stepB);
        add(checkB);
    }

    public void resizeButtonFont(int w, int h) {
        matrixB.setFont(new Font("Arial", Font.PLAIN, (w / 50) - (h / 200)));
        stepB.setFont(new Font("Arial", Font.PLAIN, (w / 50) - (h / 200)));
        checkB.setFont(new Font("Arial", Font.PLAIN, (w / 50) - (h / 200)));
    }

    @Override

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == matrixB) {
            System.out.println("MatrixB");
            MainPanel.matriceDiAdiacenza.changeVisibility(true);
            MainPanel.vettoriDistanza.changeVisibility(false);
        }

        if (ae.getSource() == stepB) {
            System.out.println("StepB");
            // if (MainPanel.matriceDiAdiacenza.isVisible()) {
            network.unlock();
            // }
        }

        if (ae.getSource() == checkB)

        {
            System.out.println("checkB");
            MainPanel.vettoriDistanza.changeVisibility(true);
            MainPanel.matriceDiAdiacenza.changeVisibility(false);
        }
    }
}