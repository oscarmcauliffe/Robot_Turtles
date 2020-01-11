import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class FenetreJeu extends JFrame {

        public FenetreJeu() {

            super("Robot Turtles");       // initialise le titre de le fenetre
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);         //arrete le programme lorsque toutes les fenetres sont fermées
            this.setSize(1920, 1080);         //permet de gerer la taille de la fenetre
            this.setLocationRelativeTo(null);         //place la fenetre par rapport a une autre fenetre, la valeur nulle correspond au bureau
            this.getContentPane().setLayout(null);

            JPanel Hand = new JPanel();
            Hand.setLayout( null );
            Hand.setBounds(0, 0, 600, 400);

            this.add(Hand);
        }

        public static void main (String[] args) throws Exception {
        // Applique un look and feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Create my windows
        FenetreJeu myWindow = new FenetreJeu();  //creation de le fenetre
        myWindow.setVisible(true);
        }
    }

