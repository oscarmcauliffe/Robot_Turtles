import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuAcceuil extends JFrame {

        public MenuAcceuil() {
            super("Robot Turtles");       // initialise le titre de le fenetre
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);         //arrete le programme lorsque toutes les fenetres sont fermées
            this.setSize(620, 802);         //permet de gerer la taille de la fenetre
            this.setLocationRelativeTo(null);         //place la fenetre par rapport a une autre fenetre, la valeur nulle correspond au bureau
            this.getContentPane().setLayout(null);

            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("images/menu.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimg = img.getScaledInstance(620, 802, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(dimg);
            JLabel fond = new JLabel(icon);
            fond.setLayout(null);
            fond.setBounds(-10, -20, 620, 802);
            this.add(fond);

            JButton btnJouer = new JButton( "Jouer" );
            btnJouer.setBounds(260,450,100,50);

            JButton btn2joueurs = new JButton( "2 joueurs" );
            btn2joueurs.setBounds(260,380,100,50);

            JButton btn3joueurs = new JButton( "3 Joueurs" );
            btn3joueurs.setBounds(260,450,100,50);

            JButton btn4joueurs = new JButton( "4 Joueurs" );
            btn4joueurs.setBounds(260,520,100,50);


            //contentPane.add( Title );
            fond.add(btnJouer);
            fond.add(btn2joueurs);
            fond.add(btn3joueurs);
            fond.add(btn4joueurs);

            btn2joueurs.setVisible(false);
            btn3joueurs.setVisible(false);
            btn4joueurs.setVisible(false);

            btnJouer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnJouer.setVisible(false);
                    btn2joueurs.setVisible(true);
                    btn3joueurs.setVisible(true);
                    btn4joueurs.setVisible(true);                }
            });

            btn2joueurs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    FenetreJeu myWindow = new FenetreJeu();
                    myWindow.setVisible(true);

                    Jeu.fenetre = myWindow;
                    Jeu.nouvellePartie(2);
                }
            });

            btn3joueurs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    FenetreJeu myWindow = new FenetreJeu();
                    myWindow.setVisible(true);

                    Jeu.fenetre = myWindow;
                    Jeu.nouvellePartie(3);
                }
            });

            btn4joueurs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    FenetreJeu myWindow = new FenetreJeu();
                    myWindow.setVisible(true);

                    Jeu.fenetre = myWindow;
                    Jeu.nouvellePartie(4);
                }
            });
        }

        public static void main(String[] args) throws Exception{
            // Applique un look and feel
            UIManager.setLookAndFeel( new NimbusLookAndFeel());
            // Create my windows
            MenuAcceuil myWindow = new MenuAcceuil();  //creation de le fenetre
            myWindow.setVisible( true );
        }
    }

