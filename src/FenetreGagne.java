import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class FenetreGagne extends JFrame {

    private JLabel texteGagne;
    private JLabel textePerdre;
    private JButton btnConfirmer;

    //Cree la fenetre qui affiche si un joueur gagne ou perd
    public FenetreGagne(Joueur j, boolean g) {
        super("");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(470, 200);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);

        texteGagne = new JLabel(j.nom + " a gagné!", SwingConstants.CENTER);
        texteGagne.setBounds(20, 0, 420, 40);
        this.add(texteGagne);
        texteGagne.setVisible(false);

        textePerdre = new JLabel(j.nom + " a perdu!", SwingConstants.CENTER);
        textePerdre.setBounds(20, 0, 420, 40);
        this.add(textePerdre);
        textePerdre.setVisible(false);

        btnConfirmer = new JButton("Ok");
        btnConfirmer.setBounds(20, 90, 420, 40);
        this.add(btnConfirmer);

        if (g){
            texteGagne.setVisible(true);
        }
        else {
            textePerdre.setVisible(true);
        }

        btnConfirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
