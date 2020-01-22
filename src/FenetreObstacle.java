import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FenetreObstacle extends JFrame {
    private JComboBox<String> comboOb;
    private JComboBox<String> comboLigne;
    private JComboBox<String> comboColonne;
    private JButton btnPlacer;
    private JLabel erreur;
    private boolean valide = false;

    public FenetreObstacle(){ // fenetre lié a l'action d'ajout d'obstacle
        super("Placer Obstacle");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(470, 370);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);

        JLabel type= new JLabel("Sélectionnez un type de mur : ", SwingConstants.CENTER);
        type.setBounds(20, 0, 420, 40);
        this.add(type);

        //permet de choisir l'obstacle a placer
        String[] obstacles = new String[] {"Pierre", "Glace", "Caisse"};
        comboOb = new JComboBox<String>(obstacles);
        comboOb.setBounds(20, 40, 420, 40);
        this.add(comboOb);

        //permet de selectionner la ligne et la colonne
        JLabel coord= new JLabel("Sélectionnez une ligne et une colonne : ", SwingConstants.CENTER);
        coord.setBounds(20, 90, 420, 40);
        this.add(coord);

        String[] ligne = new String[] {"0", "1", "2", "3", "4", "5", "6", "7"};
        comboLigne = new JComboBox<String>(ligne);
        comboLigne.setBounds(20, 140, 420, 40);
        this.add(comboLigne);

        String[] colonne = new String[] {"0", "1", "2", "3", "4", "5", "6", "7"};
        comboColonne = new JComboBox<String>(colonne);
        comboColonne.setBounds(20, 190, 420, 40);
        this.add(comboColonne);

        //bouton permettant de placer l'obstacle
        btnPlacer = new JButton("Placer");
        btnPlacer.setBounds(20, 240, 420, 40);
        this.add(btnPlacer);

        erreur= new JLabel("", SwingConstants.CENTER);
        erreur.setBounds(20, 280, 420, 40);
        this.add(erreur);


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (valide){
                    FenetreJeu.actionValide = true;
                    FenetreJeu.btnPlacer.setEnabled(false);
                    FenetreJeu.btnAjouter.setEnabled(false);
                    FenetreJeu.btnExecuter.setEnabled(false);
                }
                else {
                    FenetreJeu.btnPlacer.setEnabled(true);
                    FenetreJeu.btnAjouter.setEnabled(true);
                    FenetreJeu.btnExecuter.setEnabled(true);
                }
                FenetreJeu.btnDefausser.setEnabled(true);
                FenetreJeu.updateFenetre();
            }
        });

        //creation de l'evenement permettant de placer l'obstacle
        btnPlacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placerObstacle(FenetreJeu.joueurActuel,comboOb.getSelectedItem().toString());
            }
        });
    }

    public void placerObstacle(Joueur j, String choix) {
        erreur.setText("");
        Obstacle obstacle = containsObstacle(j.piocheObstacle, choix.toLowerCase());

        if(obstacle == null){
            erreur.setText("Cet obstacle n'est pas disponible!");
        }
        else{
            int x = Integer.parseInt(comboLigne.getSelectedItem().toString());
            int y = Integer.parseInt(comboColonne.getSelectedItem().toString());

            System.out.println(Plateau.placementValide(x,y));
            if (Plateau.getTuile(x,y).nom == "vide" && Plateau.placementValide(x,y)) {
                j.piocheObstacle.remove(obstacle);
                Plateau.ajoutTuile(obstacle, x, y);
                valide = true;
                dispose();
            } else {
                erreur.setText("Cette case est occupée ou cette case doit rester vide!");
            }
        }
    }

    //Methode permettant de verifier si l'obstale demandé est toujours disponible
    private Obstacle containsObstacle(ArrayList<Obstacle> pioche, String type) {
        for (Obstacle o : pioche) {
            if (o.nom.equals(type)) {
                return o;
            }
        }
        return null;
    }
}
