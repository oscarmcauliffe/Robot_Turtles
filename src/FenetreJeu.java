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


            JPanel hand = new JPanel();
            hand.setLayout( null );
            hand.setBounds(368, 510, 500, 130);
            hand.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(hand);

            JPanel plateau = new JPanel();
            plateau.setLayout( null );
            plateau.setBounds(368, 0, 500, 500);
            plateau.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(plateau);

            JPanel items = new JPanel();
            items.setLayout( null );
            items.setBounds(932, 0, 338, 640);
            items.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(items);

            JPanel actions = new JPanel();
            actions.setLayout( null );
            actions.setBounds(0, 220, 320, 420);
            actions.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(actions);
        }

        public static void main (String[] args) throws Exception {
        // Applique un look and feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Create my windows
        FenetreJeu myWindow = new FenetreJeu();  //creation de le fenetre
        myWindow.setVisible(true);
        }
    }

