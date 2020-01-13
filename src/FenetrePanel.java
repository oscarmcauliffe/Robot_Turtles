import javax.swing.*;
import java.awt.*;

public class FenetrePanel extends JFrame{
    public void fenetrePanel(){

        // debut panel lié au plateau de jeux
    //tortue rouge orientation
        JLabel tortueRougeE = new JLabel();
        Icon rougeE = new ImageIcon("/images/tortues/rougeE.png" );
        tortueRougeE.setIcon(rougeE);
        tortueRougeE.setSize(62, 62);

        JLabel tortueRougeS = new JLabel();
        Icon rougeS = new ImageIcon("/images/tortues/rougeS.png" );
        tortueRougeS.setIcon(rougeS);
        tortueRougeS.setSize(62, 62);

        JLabel tortueRougeW = new JLabel();
        Icon rougeW = new ImageIcon("/images/tortues/rougeW.png" );
        tortueRougeW.setIcon(rougeW);
        tortueRougeW.setSize(62, 62);

        JLabel tortueRougeN = new JLabel();
        Icon rougeN = new ImageIcon("/images/tortues/rougeN.png" );
        tortueRougeN.setIcon(rougeN);
        tortueRougeN.setSize(62, 62);

//tortue BLeu orientation
        JLabel tortueBleuE = new JLabel();
        Icon bleuE = new ImageIcon("/images/tortues/bleuE.png" );
        tortueBleuE.setIcon(bleuE);
        tortueBleuE.setSize(62, 62);

        JLabel tortueBleuS = new JLabel();
        Icon bleuS = new ImageIcon("/images/tortues/bleuS.png" );
        tortueBleuS.setIcon(bleuS);
        tortueBleuS.setSize(62, 62);

        JLabel tortueBleuW = new JLabel();
        Icon bleuW = new ImageIcon("/images/tortues/bleuW.png" );
        tortueBleuW.setIcon(bleuW);
        tortueBleuW.setSize(62, 62);

        JLabel tortueBleuN = new JLabel();
        Icon bleuN = new ImageIcon("/images/tortues/bleuN.png" );
        tortueBleuN.setIcon(bleuN);
        tortueBleuN.setSize(62, 62);

//tortue verte orientation
        JLabel tortueVerteE = new JLabel();
        Icon verteE = new ImageIcon("/images/tortues/verteE.png" );
        tortueVerteE.setIcon(verteE);
        tortueVerteE.setSize(62, 62);

        JLabel tortueVerteS = new JLabel();
        Icon verteS = new ImageIcon("/images/tortues/verteS.png" );
        tortueVerteS.setIcon(verteS);
        tortueVerteS.setSize(62, 62);

        JLabel tortueVerteW = new JLabel();
        Icon verteW = new ImageIcon("/images/tortues/verteW.png" );
        tortueVerteW.setIcon(verteE);
        tortueVerteW.setSize(62, 62);

        JLabel tortueVerteN = new JLabel();
        Icon verteN = new ImageIcon("/images/tortues/verteN.png" );
        tortueVerteN.setIcon(verteN);
        tortueVerteN.setSize(62, 62);

 // tortue violette orientation
        JLabel tortueVioletE = new JLabel();
        Icon violetE = new ImageIcon("/images/tortues/violetE.png" );
        tortueVioletE.setIcon(violetE);
        tortueVioletE.setSize(62, 62);

        JLabel tortueVioletS = new JLabel();
        Icon violetS = new ImageIcon("/images/tortues/violetS.png" );
        tortueVioletS.setIcon(violetS);
        tortueVioletS.setSize(62, 62);

        JLabel tortueVioletW = new JLabel();
        Icon violetW = new ImageIcon("/images/tortues/violetW.png" );
        tortueVioletW.setIcon(violetW);
        tortueVioletW.setSize(62, 62);

        JLabel tortueVioletN = new JLabel();
        Icon violetN = new ImageIcon("/images/tortues/violetN.png" );
        tortueVioletN.setIcon(violetN);
        tortueVioletN.setSize(62, 62);

//Fin tortue

        JLabel murPierre = new JLabel();
        murPierre.setSize(62, 62);


        JLabel murGlace = new JLabel();
        murGlace.setSize(62, 62);


        JLabel Joyau = new JLabel();
        Joyau.setSize(62, 62);


        JPanel caseVide = new JPanel();
        caseVide.setLayout( null );
        caseVide.setSize(62, 62);

        // fin panel lie au plateau

        //debut panel lie a la main

        JLabel carteBleu = new JLabel();
        carteBleu.setSize(88, 125);

        JLabel carteViolette = new JLabel();
        carteViolette.setSize(88, 125);

        JLabel carteJaune = new JLabel();
        carteJaune.setSize(88, 125);

        JLabel carteLaser = new JLabel();
        carteLaser.setSize(88, 125);

        //fin panel lie a la main
    }
}
