import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class MenuAcceuil extends JFrame {

        public MenuAcceuil() {
            super("Robot Turtles");       // initialise le titre de le fenetre
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);         //arrete le programme lorsque toutes les fenetres sont fermées
            this.setSize(600, 400);         //permet de gerer la taille de la fenetre
            this.setLocationRelativeTo(null);         //place la fenetre par rapport a une autre fenetre, la valeur nulle correpsond au bureau
            this.getContentPane().setLayout(null);

            JPanel pageAcceuil = new JPanel() ;     // permet d'acceder a la zone principal de la fenetre
            pageAcceuil.setLayout( null );

            pageAcceuil.setBackground(Color.BLACK);
            pageAcceuil.setBounds(0, 0, 600, 400);

            this.add(pageAcceuil);

            JPanel pageNbrJ = new JPanel();
            pageNbrJ.setLayout( null );
            pageNbrJ.setBounds(0, 0, 600, 400);
            pageAcceuil.setBackground(Color.white);

            this.add(pageNbrJ);

            JButton btnJouer = new JButton( "Jouer" );
            btnJouer.setBounds(250,150,100,50);

            JButton btn2joueurs = new JButton( "2 joueurs" );
            btn2joueurs.setBounds(250,50,100,50);

            JButton btn3joueurs = new JButton( "3 Joueurs" );
            btn3joueurs.setBounds(250,150,100,50);

            JButton btn4joueurs = new JButton( "4 Joueurs" );
            btn4joueurs.setBounds(250,250,100,50);


            ImageIcon iconTitre = new ImageIcon("images/RoboTurtleTitre.jpg");
            JLabel Title = new JLabel();
            Title.setIcon(iconTitre);
            Title.setBounds(20,32,320,118);

            //contentPane.add( Title );
            pageAcceuil.add(btnJouer);
            pageNbrJ.add(btn2joueurs);
            pageNbrJ.add(btn3joueurs);
            pageNbrJ.add(btn4joueurs);
            pageNbrJ.setVisible(false);


            btnJouer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pageAcceuil.setVisible(false);
                    pageNbrJ.setVisible(true);
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

