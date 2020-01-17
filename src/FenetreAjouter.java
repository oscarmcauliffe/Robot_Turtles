import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FenetreAjouter extends JFrame {

    public FenetreAjouter(){
        super("Robot Turtles");       // initialise le titre de le fenetre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);         //arrete le programme lorsque toutes les fenetres sont fermées
        this.setSize(470, 200);         //permet de gerer la taille de la fenetre
        this.setLocationRelativeTo(null);         //place la fenetre par rapport a une autre fenetre, la valeur nulle correspond au bureau
        this.getContentPane().setLayout(null);

        JLabel texte = new JLabel("Veuillez entrer votre choix", SwingConstants.CENTER);
        texte.setBounds(20,0,420,40);
        this.add(texte);

        String[] listeAjouter = {"0","1","2","3","4"};
        JComboBox listAjouter = new JComboBox(listeAjouter);
        listAjouter.setBounds(20,40,420,40);
        this.add(listAjouter);

        JButton btnConfirmer = new JButton("Confirmer");
        btnConfirmer.setBounds(20,90,420,40);
        this.add(btnConfirmer);

        JButton btnAjouterAutre = new JButton("Ajouter une autre carte");
        btnAjouterAutre.setBounds(20,40,420,40);
        this.add(btnAjouterAutre);
        btnAjouterAutre.setVisible(false);

        JButton btnConfirmerAjout = new JButton("Confirmer les ajouts");
        btnConfirmerAjout.setBounds(20,90,420,40);
        this.add(btnConfirmerAjout);
        btnConfirmerAjout.setVisible(false);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FenetreJeu.btnAjouter.setEnabled(true);
            }
        });

        btnConfirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAjouterAutre.setVisible(true);
                btnConfirmerAjout.setVisible(true);
                texte.setVisible(false);
                btnConfirmer.setVisible(false);
                listAjouter.setVisible(false);
            }
        });

        btnAjouterAutre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAjouterAutre.setVisible(false);
                btnConfirmerAjout.setVisible(false);
                texte.setVisible(true);
                btnConfirmer.setVisible(true);
                listAjouter.setVisible(true);
            }
        });

        btnConfirmerAjout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });

        btnAjouterAutre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAjouterAutre.setVisible( false );
                btnConfirmerAjout.setVisible( false );
                texte.setVisible( true );
                btnConfirmer.setVisible( true );
                listAjouter.setVisible( true );
            }
        });
    }

    public static void main(String[] args) throws Exception{
        // Applique un look and feel
        UIManager.setLookAndFeel( new NimbusLookAndFeel());
        // Create my windows
        FenetreAjouter FenetreAjouterWindow = new FenetreAjouter();
        FenetreAjouterWindow.setVisible( true );
    }
}
