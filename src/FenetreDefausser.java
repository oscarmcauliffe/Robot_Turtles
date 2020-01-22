import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class FenetreDefausser extends JFrame {

    private JComboBox<String> comboDefausser;
    private JLabel erreur;
    private JLabel texte;
    private JButton btnConfirmer;
    private JButton btnDefausserAutre;
    private JButton btnConfirmerDefausser;
    private static boolean valide = false;

    public FenetreDefausser() {
        super("Defausser une Carte");       // initialise le titre de le fenetre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);         //arrete le programme lorsque toutes les fenetres sont fermées
        this.setSize(470, 200);         //permet de gerer la taille de la fenetre
        this.setLocationRelativeTo(null);         //place la fenetre par rapport a une autre fenetre, la valeur nulle correspond au bureau
        this.getContentPane().setLayout(null);

        texte = new JLabel("Veuillez entrer votre choix", SwingConstants.CENTER);
        texte.setBounds(20, 0, 420, 40);
        this.add(texte);

        String[] listeDefausser = {"0", "1", "2", "3", "4"};
        comboDefausser = new JComboBox(listeDefausser);
        comboDefausser.setBounds(20, 40, 420, 40);
        this.add(comboDefausser);

        btnConfirmer = new JButton("Confirmer");
        btnConfirmer.setBounds(20, 90, 420, 40);
        this.add(btnConfirmer);

        btnDefausserAutre = new JButton("Defausser une autre carte");
        btnDefausserAutre.setBounds(20, 40, 420, 40);
        this.add(btnDefausserAutre);
        btnDefausserAutre.setVisible(false);

        erreur = new JLabel("", SwingConstants.CENTER);
        erreur.setBounds(20, 130, 420, 40);
        this.add(erreur);

        btnConfirmerDefausser = new JButton("Confirmer les defausses");
        btnConfirmerDefausser.setBounds(20, 90, 420, 40);
        this.add(btnConfirmerDefausser);
        btnConfirmerDefausser.setVisible(false);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (FenetreJeu.actionValide == false){
                    FenetreJeu.btnPlacer.setEnabled(true);
                    FenetreJeu.btnExecuter.setEnabled(true);
                    FenetreJeu.btnAjouter.setEnabled(true);
                }
                FenetreJeu.btnDefausser.setEnabled(true);
                FenetreJeu.updateFenetre();
            }
        });

        btnConfirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defausser(FenetreJeu.joueurActuel);
            }
        });

        btnDefausserAutre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDefausserAutre.setVisible(false);
                btnConfirmerDefausser.setVisible(false);
                texte.setVisible(true);
                btnConfirmer.setVisible(true);
                comboDefausser.setVisible(true);
            }
        });

        btnConfirmerDefausser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void defausser(Joueur j) {
        if (j.main.size() > 0) {
            if (comboDefausser.getSelectedIndex() >= j.main.size()) {
                erreur.setText("Pas de carte à cet index dans la main.");
            } else {
                j.defausse.add(j.getCarteMain(comboDefausser.getSelectedIndex()));
                j.main.remove(j.getCarteMain(comboDefausser.getSelectedIndex()));

                valide = true;
                erreur.setText("");
                btnDefausserAutre.setVisible(true);
                btnConfirmerDefausser.setVisible(true);
                texte.setVisible(false);
                btnConfirmer.setVisible(false);
                comboDefausser.setVisible(false);
            }
        }
        else {
            erreur.setText("Votre main est vide.");
        }
        FenetreJeu.updateFenetre();
    }
}
