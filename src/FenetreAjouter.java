import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class FenetreAjouter extends JFrame {

    private JComboBox<String> comboAjouter;
    private JLabel erreur;
    private JLabel texte;
    private JButton btnConfirmer;
    private JButton btnAjouterAutre;
    private JButton btnConfirmerAjout;
    private static boolean valide = false;

    //Cree la fenetre d'ajout de carte dans la file d'instructions
    public FenetreAjouter() {
        super("Ajouter au Programme");       // initialise le titre de le fenetre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);         //arrete le programme lorsque toutes les fenetres sont fermées
        this.setSize(470, 200);         //permet de gerer la taille de la fenetre
        this.setLocationRelativeTo(null);         //place la fenetre par rapport a une autre fenetre, la valeur nulle correspond au bureau
        this.getContentPane().setLayout(null);

        //début de la creation des élements s'affichant sur la fenetre
        texte = new JLabel("Veuillez entrer votre choix", SwingConstants.CENTER);
        texte.setBounds(20, 0, 420, 40);
        this.add(texte);

        //combobx permettant de choisir quel carte ajouter a la pile
        String[] listeAjouter = {"0", "1", "2", "3", "4"};
        comboAjouter = new JComboBox(listeAjouter);
        comboAjouter.setBounds(20, 40, 420, 40);
        this.add(comboAjouter);

        //bouton de confirmation
        btnConfirmer = new JButton("Confirmer");
        btnConfirmer.setBounds(20, 90, 420, 40);
        this.add(btnConfirmer);

        //bouton servant a revenir en arrière si l'on veut rajouter d'autres cartes
        btnAjouterAutre = new JButton("Ajouter une autre carte");
        btnAjouterAutre.setBounds(20, 40, 420, 40);
        this.add(btnAjouterAutre);
        btnAjouterAutre.setVisible(false);

        erreur = new JLabel("", SwingConstants.CENTER);
        erreur.setBounds(20, 130, 420, 40);
        this.add(erreur);

        //bouton confirmant totalement l'ajout a la pile et fermant la fenetre
        btnConfirmerAjout = new JButton("Confirmer les ajouts");
        btnConfirmerAjout.setBounds(20, 90, 420, 40);
        this.add(btnConfirmerAjout);
        btnConfirmerAjout.setVisible(false);
        //fin de la creation des élements s'affichant sur la fenetre

        //permet de désactiver temporairement les boutons d'action tant que la fenetre d'ajout est ouverte
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("test");
                if (valide) {
                    FenetreJeu.actionValide = true;
                    FenetreJeu.btnPlacer.setEnabled(false);
                    FenetreJeu.btnExecuter.setEnabled(false);

                } else {
                    FenetreJeu.btnPlacer.setEnabled(true);
                    FenetreJeu.btnExecuter.setEnabled(true);

                }
                FenetreJeu.btnAjouter.setEnabled(true);
                FenetreJeu.btnDefausser.setEnabled(true);
                FenetreJeu.updateFenetre();
            }
        });

        // création des events liés aux boutons
        btnConfirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterProgramme(FenetreJeu.joueurActuel);
            }
        });

        btnAjouterAutre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAjouterAutre.setVisible(false);
                btnConfirmerAjout.setVisible(false);
                texte.setVisible(true);
                btnConfirmer.setVisible(true);
                comboAjouter.setVisible(true);
            }
        });

        btnConfirmerAjout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (valide) {
                    FenetreJeu.actionValide = true;
                    FenetreJeu.btnPlacer.setEnabled(false);
                    FenetreJeu.btnExecuter.setEnabled(false);

                } else {
                    FenetreJeu.btnPlacer.setEnabled(true);
                    FenetreJeu.btnExecuter.setEnabled(true);

                }
                FenetreJeu.btnAjouter.setEnabled(true);
                FenetreJeu.btnDefausser.setEnabled(true);
                FenetreJeu.updateFenetre();

                dispose();
            }
        });
    }

    //méthode permettant d'ajouter les cartes et de vérifier s'il existe une carte a l'index donné
    private void ajouterProgramme(Joueur j) {
        if (j.main.size() > 0) {
            if (comboAjouter.getSelectedIndex() >= j.main.size()) {
                erreur.setText("Pas de carte à cet index dans la main.");
            } else {
                j.instructions.add(j.getCarteMain(comboAjouter.getSelectedIndex())); // ajoute la carte et "reactive les autres bouton"
                j.main.remove(j.getCarteMain(comboAjouter.getSelectedIndex()));

                valide = true;
                erreur.setText("");
                btnAjouterAutre.setVisible(true);
                btnConfirmerAjout.setVisible(true);
                texte.setVisible(false);
                btnConfirmer.setVisible(false);
                comboAjouter.setVisible(false);
            }
        } else {
            erreur.setText("Votre main est vide.");
        }
        FenetreJeu.updateFenetre();
    }
}
