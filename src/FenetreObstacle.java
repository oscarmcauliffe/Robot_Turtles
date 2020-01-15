import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FenetreObstacle extends JFrame {
    public FenetreObstacle(){
        super("Placer Obstacle");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(470, 200);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);

        JLabel texte= new JLabel("Sélectionnez un type de mur : ", SwingConstants.CENTER);
        texte.setBounds(20, 0, 420, 40);
        this.add(texte);

        String[] obstacles = new String[] {"Pierre", "Glace", "Caisse"};
        JComboBox<String> comboOb = new JComboBox<String>(obstacles);
        comboOb.setBounds(20, 40, 420, 40);
        this.add(comboOb);

        JButton btn = new JButton("Placer");
        btn.setBounds(20, 90, 420, 40);
        this.add(btn);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FenetreJeu.btnPlacer.setEnabled(true);
            }

        });
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        FenetreObstacle myWindow = new FenetreObstacle();  //creation de le fenetre
        myWindow.setVisible(true);
    }
}
