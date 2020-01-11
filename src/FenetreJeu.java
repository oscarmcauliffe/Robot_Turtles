import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class FenetreJeu extends JFrame {

        public FenetreJeu() {

            super("Robot Turtles");       // initialise le titre de le fenetre
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //arrete le programme lorsque toutes les fenetres sont fermées
            this.setSize(1300,681);
            //this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);       //permet de gerer la taille de la fenetre
            this.setLocationRelativeTo(null);         //place la fenetre par rapport a une autre fenetre, la valeur nulle correspond au bureau
            this.getContentPane().setLayout(null);


            JPanel plateau = new JPanel();
            plateau.setLayout( null );
            plateau.setBounds(434, 530, 434, 150);
            plateau.setBackground(Color.BLACK);
            this.add(plateau);
        }

        public static void main (String[] args) throws Exception {
        // Applique un look and feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Create my windows
        FenetreJeu myWindow = new FenetreJeu();  //creation de le fenetre
        myWindow.setVisible(true);
        }
    }

