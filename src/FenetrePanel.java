import javax.swing.*;
import java.awt.*;

public class FenetrePanel {
    public void fenetrePanel(){

        // debut panel lié au plateau de jeux

        JPanel tortueRouge = new JPanel();
        tortueRouge.setLayout( null );
        tortueRouge.setSize(62, 62);
        //tortueRouge.setBackground(Color.BLACK);
        //carte1.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel tortueJaune = new JPanel();
        tortueJaune.setLayout( null );
        tortueJaune.setSize(62, 62);
        //tortueRouge.setBackground(Color.BLACK);
        //carte1.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel tortueVert = new JPanel();
        tortueVert.setLayout( null );
        tortueVert.setSize(62, 62);
        //tortueRouge.setBackground(Color.BLACK);
        //carte1.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel tortueViolet = new JPanel();
        tortueViolet.setLayout( null );
        tortueViolet.setSize(62, 62);
        //tortueRouge.setBackground(Color.BLACK);
        //carte1.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel murPierre = new JPanel();
        murPierre.setLayout( null );
        murPierre.setSize(62, 62);
        //tortueRouge.setBackground(Color.BLACK);
        //carte1.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel murGlace = new JPanel();
        murGlace.setLayout( null );
        murGlace.setSize(62, 62);
        //        //tortueRouge.setBackground(Color.BLACK);
        //        //carte1.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel Joyau = new JPanel();
        Joyau.setLayout( null );
        Joyau.setSize(62, 62);
        //tortueRouge.setBackground(Color.BLACK);
        //carte1.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel caseVide = new JPanel();
        caseVide.setLayout( null );
        caseVide.setSize(62, 62);
        //tortueRouge.setBackground(Color.BLACK);
        //carte1.setBorder(BorderFactory.createLineBorder(Color.black));

        // fin panel lie au plateau

        //debut panel lie a la main

        JPanel carteBleu = new JPanel ();
        carteBleu.setLayout( null );
        carteBleu.setSize(88, 125);

        JPanel carteViolete = new JPanel();
        carteViolete.setLayout( null );
        carteViolete.setSize(88, 125);

        JPanel carteJaune = new JPanel();
        carteJaune.setLayout( null );
        carteJaune.setSize(88, 125);

        JPanel carteLaser = new JPanel();
        carteLaser.setLayout( null );
        carteLaser.setSize(88, 125);

        //fin panel lie a la main
    }
}
