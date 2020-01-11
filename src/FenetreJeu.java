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

            JButton btnPlacer = new JButton( "Placer" );
            btnPlacer.setBounds(85,15,150,64);

            JButton btnAjouter = new JButton( "Ajouter" );
            btnAjouter.setBounds(85,99,150,64);

            JButton btnExecuter = new JButton( "Executer" );
            btnExecuter.setBounds(85,183,150,64);

            JButton btnDefausser = new JButton( "Defausser" );
            btnDefausser.setBounds(85,267,150,64);

            JButton btnPasser = new JButton( "Passer" );
            btnPasser.setBounds(85,351,150,64);

            actions.add(btnPlacer);
            actions.add(btnAjouter);
            actions.add(btnExecuter);
            actions.add(btnDefausser);
            actions.add(btnPasser);
        }

        public static void main (String[] args) throws Exception {
        // Applique un look and feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Create my windows
        FenetreJeu myWindow = new FenetreJeu();  //creation de le fenetre
        myWindow.setVisible(true);
        }
    }

