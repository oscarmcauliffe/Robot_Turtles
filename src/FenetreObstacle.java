import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FenetreObstacle extends JFrame {
    public JComboBox<String> comboOb;
    public JComboBox<String> comboLigne;
    public JComboBox<String> comboColonne;
    public JButton btnPlacer;
    public JLabel erreur;
    public boolean valide = false;

    public FenetreObstacle(){
        super("Placer Obstacle");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(470, 370);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);

        JLabel type= new JLabel("Sélectionnez un type de mur : ", SwingConstants.CENTER);
        type.setBounds(20, 0, 420, 40);
        this.add(type);

        String[] obstacles = new String[] {"Pierre", "Glace", "Caisse"};
        comboOb = new JComboBox<String>(obstacles);
        comboOb.setBounds(20, 40, 420, 40);
        this.add(comboOb);

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
                    FenetreJeu.btnPlacer.setEnabled(false);
                    FenetreJeu.btnAjouter.setEnabled(false);
                    FenetreJeu.btnExecuter.setEnabled(false);
                }
                else {
                    FenetreJeu.btnPlacer.setEnabled(true);
                    FenetreJeu.btnAjouter.setEnabled(true);
                    FenetreJeu.btnExecuter.setEnabled(true);
                }
                FenetreJeu.updateFenetre();
            }
        });

        btnPlacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placerObstacle(FenetreJeu.joueurActuel,comboOb.getSelectedItem().toString());
            }
        });
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        FenetreObstacle myWindow = new FenetreObstacle();  //creation de le fenetre
        myWindow.setVisible(true);
    }

    private void placerObstacle(Joueur j, String choix) {
        erreur.setText("");
        Obstacle obstacle = containsObstacle(j.piocheObstacle, choix.toLowerCase());

        if(obstacle == null){
            erreur.setText("Cet obstacle n'est pas disponible!");
        }
        else{
            int x = Integer.parseInt(comboLigne.getSelectedItem().toString());
            int y = Integer.parseInt(comboColonne.getSelectedItem().toString());

            if (Plateau.getTuile(x, y).nom == "vide") {
                j.piocheObstacle.remove(obstacle);
                Plateau.ajoutTuile(obstacle, x, y);
                valide = true;
                dispose();
            } else {
                erreur.setText("Cette case est occupée!");
            }
        }
    }

    private Obstacle containsObstacle(ArrayList<Obstacle> pioche, String type) {
        for (Obstacle o : pioche) {
            if (o.nom.equals(type)) {
                return o;
            }
        }
        return null;
    }
}
