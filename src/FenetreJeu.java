import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

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

                    //debut des panels contenus dans hand
                    JPanel carte1 = new JPanel();
                    carte1.setLayout( null );
                    carte1.setBounds(10, 5, 88, 125);
                    carte1.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    hand.add(carte1);

                    JPanel carte2 = new JPanel();
                    carte2.setLayout( null );
                    carte2.setBounds(108, 5, 88, 125);
                    carte2.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    hand.add(carte2);

                    JPanel carte3 = new JPanel();
                    carte3.setLayout( null );
                    carte3.setBounds(206, 5, 88, 125);
                    carte3.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    hand.add(carte3);

                    JPanel carte4 = new JPanel();
                    carte4.setLayout( null );
                    carte4.setBounds(304, 5, 88, 125);
                    carte4.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    hand.add(carte4);

                    JPanel carte5 = new JPanel();
                    carte5.setLayout( null );
                    carte5.setBounds(402, 5, 88, 125);
                    carte5.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    hand.add(carte5);
                    //fin des panels contenus dans hand


            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("images/plateau.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(dimg);
            JLabel plateau = new JLabel(icon);
            plateau.setLayout( null );
            plateau.setBounds(368, 0, 496,  496);
            plateau.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(plateau);




            JPanel items = new JPanel();
            items.setLayout( null );
            items.setBounds(932, 0, 338, 640);
            items.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(items);

                    JPanel pileProgramme = new JPanel();
                    pileProgramme.setLayout( null );
                    pileProgramme.setBounds(25, 470, 100, 150);
                    pileProgramme.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    items.add(pileProgramme);

                    JPanel compteurProgramme = new JPanel();
                    compteurProgramme.setLayout( null );
                    compteurProgramme.setBounds(140, 530, 50, 30);
                    compteurProgramme.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    items.add(compteurProgramme);

                    JPanel pilePierre = new JPanel();
                    pilePierre.setLayout( null );
                    pilePierre.setBounds(25, 40, 100, 50);
                    pilePierre.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    items.add(pilePierre);

                    JPanel compteurPierre = new JPanel();
                    compteurPierre.setLayout( null );
                    compteurPierre.setBounds(140, 50, 50, 30);
                    compteurPierre.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    items.add(compteurPierre);

                    JPanel pileGlace = new JPanel();
                    pileGlace.setLayout( null );
                    pileGlace.setBounds(25, 130, 100, 50);
                    pileGlace.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    items.add(pileGlace);

                    JPanel compteurGlace = new JPanel();
                    compteurGlace.setLayout( null );
                    compteurGlace.setBounds(140, 140, 50, 30);
                    compteurGlace.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    items.add(compteurGlace);

                    JPanel pileCaisse= new JPanel();
                    pileCaisse.setLayout( null );
                    pileCaisse.setBounds(25, 220, 100, 50);
                    pileCaisse.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    items.add(pileCaisse);

                    JPanel compteurCaisse = new JPanel();
                    compteurCaisse.setLayout( null );
                    compteurCaisse.setBounds(140, 230, 50, 30);
                    compteurCaisse.setBackground(Color.BLACK);
                    //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
                    items.add(compteurCaisse);


            JPanel actions = new JPanel();
            actions.setLayout( null );
            actions.setBounds(0, 220, 320, 420);
            actions.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(actions);

                    JButton btnPlacer = new JButton( "Placer" );
                    btnPlacer.setBounds(85,15 ,150,64);

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

