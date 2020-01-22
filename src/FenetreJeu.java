import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//cree la fenetre de jeu
public class FenetreJeu extends JFrame {

    public static Joueur joueurActuel;
    public static JLabel plateauImg;
    public static JPanel hand;
    public static JPanel joueur;
    public static JPanel items;
    public static JButton btnPlacer;
    public static JButton btnAjouter;
    public static JButton btnExecuter;
    public static JButton btnDefausser;
    public static JButton btnFinir;

    public static boolean actionValide = false;

    public static JLabel compteurPierre = new JLabel("");
    public static JLabel compteurGlace = new JLabel("");
    public static JLabel compteurCaisse = new JLabel("");
    public static JLabel compteurProgramme = new JLabel("");
    public static JLabel compteurDefausse = new JLabel("");

    public FenetreJeu() {

        super("Robot Turtles");       // initialise le titre de le fenetre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1300, 725);
        //permet de gerer la taille de la fenetre
        this.setLocationRelativeTo(null);         //place la fenetre par rapport a une autre fenetre, la valeur nulle correspond au bureau
        this.getContentPane().setLayout(null);

        hand = new JPanel();
        hand.setLayout(null);
        hand.setBounds(368, 553, 500, 130);
        this.add(hand);

        //panel permettant de numeroter les cartes
        JPanel bandeauHand = new JPanel();
        bandeauHand.setLayout(null);
        bandeauHand.setBounds(378, 533, 480, 20);
        this.add(bandeauHand);

        for (int i = 0; i < 5; i++) {
            JLabel numeroHand = new JLabel(Integer.toString(i));
            numeroHand.setBounds(i * 98, 0, 88, 20);
            numeroHand.setHorizontalAlignment(JLabel.CENTER);
            bandeauHand.add(numeroHand);
        }

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("images/plateau.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(496, 496, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        plateauImg = new JLabel(icon);
        plateauImg.setLayout(null);
        plateauImg.setBounds(368, 23, 496, 496);
        this.add(plateauImg);

        JPanel bandeauN = new JPanel();
        bandeauN.setLayout(null);
        bandeauN.setBounds(368, 3, 496, 20);
        this.add(bandeauN);

        JPanel bandeauW = new JPanel();
        bandeauW.setLayout(null);
        bandeauW.setBounds(348, 23, 476, 496);
        this.add(bandeauW);

        for (int i = 0; i < 8; i++) {
            JLabel numeroN = new JLabel(Integer.toString(i));
            numeroN.setBounds(i * 62, 0, 62, 20);
            numeroN.setHorizontalAlignment(JLabel.CENTER);
            bandeauN.add(numeroN);
        }

        for (int i = 0; i < 8; i++) {
            JLabel numeroW = new JLabel(Integer.toString(i));
            numeroW.setBounds(0, i * 62, 20, 62);
            numeroW.setVerticalAlignment(JLabel.CENTER);
            bandeauW.add(numeroW);
        }

        items = new JPanel();
        items.setLayout(null);
        items.setBounds(932, 43, 338, 640);
        this.add(items);

        JPanel actions = new JPanel();
        actions.setLayout(null);
        actions.setBounds(0, 263, 320, 420);
        actions.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(actions);

        //Creation de tous les boutons d'action
        btnPlacer = new JButton("Placer Obstacle");
        btnPlacer.setBounds(85, 15, 200, 64);

        btnAjouter = new JButton("Ajouter au Programme");
        btnAjouter.setBounds(85, 99, 200, 64);

        btnExecuter = new JButton("Executer le Programme");
        btnExecuter.setBounds(85, 183, 200, 64);

        btnDefausser = new JButton("Defausser Carte");
        btnDefausser.setBounds(85, 267, 200, 64);

        btnFinir = new JButton("Finir Tour");
        btnFinir.setBounds(85, 351, 200, 64);

        joueur = new JPanel();
        joueur.setLayout(null);
        joueur.setBounds(0, 80, 250, 100);
        joueur.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(joueur);

        actions.add(btnPlacer);
        actions.add(btnAjouter);
        actions.add(btnExecuter);
        actions.add(btnDefausser);
        actions.add(btnFinir);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                MenuAcceuil myWindow = new MenuAcceuil();
                myWindow.setVisible(true);
            }
        });

        //creation des évenements liés aux boutons
        btnPlacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlacer.setEnabled(false);
                btnAjouter.setEnabled(false);
                btnExecuter.setEnabled(false);
                btnDefausser.setEnabled(false);
                FenetreObstacle myWindow = new FenetreObstacle();
                myWindow.setVisible(true);
            }
        });

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlacer.setEnabled(false);
                btnAjouter.setEnabled(false);
                btnExecuter.setEnabled(false);
                btnDefausser.setEnabled(false);

                FenetreAjouter myWindow = new FenetreAjouter();
                myWindow.setVisible(true);
            }
        });

        btnDefausser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlacer.setEnabled(false);
                btnAjouter.setEnabled(false);
                btnExecuter.setEnabled(false);
                btnDefausser.setEnabled(false);

                FenetreDefausser myWindow = new FenetreDefausser();
                myWindow.setVisible(true);
            }
        });

        btnExecuter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlacer.setEnabled(false);
                btnAjouter.setEnabled(false);
                btnExecuter.setEnabled(false);
                btnDefausser.setEnabled(true);
                FenetreJeu.actionValide = true;

                Jeu.executerProgramme(joueurActuel);
            }
        });

        btnFinir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAjouter.setEnabled(true);
                btnExecuter.setEnabled(true);
                btnPlacer.setEnabled(true);
                btnDefausser.setEnabled(true);

                Jeu.nextJoueur();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        // Applique un look and feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Create my windows
        FenetreJeu myWindow = new FenetreJeu();  //creation de le fenetre
        myWindow.setVisible(true);
    }

    //met a jours les elements dynamiques de la fenetre comme les cartes dans la main, le nom du joueurs...
    public static void updateFenetre() {
        updatePlateau(Plateau.plateau);
        updateMain();
        updateJoueur();
        updateItems();
    }

    public static void updateJoueur() { //met a jour et affiche le nom du jour actuel
        joueur.removeAll();
        joueur.setVisible(false);
        joueur.setVisible(true);

        JLabel nomJoueur = new JLabel("Tour du " + joueurActuel.nom, SwingConstants.CENTER);
        nomJoueur.setLayout(null);
        nomJoueur.setBounds(0, 0, 250, 100);
        joueur.add(nomJoueur);
    }

    public static void updatePlateau(Tuile[][] p) { //met a jour et affiche le plateau
        plateauImg.removeAll();
        plateauImg.setVisible(false);
        plateauImg.setVisible(true);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tuile t = p[i][j];
                switch (t.nom) {
                    case "pierre": {
                        BufferedImage image = null;
                        try {
                            image = ImageIO.read(new File("images/obstacles/pierre.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Image dimage = image.getScaledInstance(62, 62, Image.SCALE_SMOOTH);
                        ImageIcon icone = new ImageIcon(dimage);
                        JLabel pierre = new JLabel(icone);
                        pierre.setLayout(null);
                        pierre.setBounds(j * 62, i * 62, 62, 62);
                        plateauImg.add(pierre);
                        break;
                    }
                    case "glace": {
                        BufferedImage image = null;
                        try {
                            image = ImageIO.read(new File("images/obstacles/glace.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Image dimage = image.getScaledInstance(62, 62, Image.SCALE_SMOOTH);
                        ImageIcon icone = new ImageIcon(dimage);
                        JLabel glace = new JLabel(icone);
                        glace.setLayout(null);
                        glace.setBounds(j * 62, i * 62, 62, 62);
                        plateauImg.add(glace);
                        break;
                    }
                    case "caisse": {
                        BufferedImage image = null;
                        try {
                            image = ImageIO.read(new File("images/obstacles/caisse.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Image dimage = image.getScaledInstance(62, 62, Image.SCALE_SMOOTH);
                        ImageIcon icone = new ImageIcon(dimage);
                        JLabel caisse = new JLabel(icone);
                        caisse.setLayout(null);
                        caisse.setBounds(j * 62, i * 62, 62, 62);
                        plateauImg.add(caisse);
                        break;
                    }
                    case "joyau": {
                        if (t instanceof Joyau) {
                            switch (((Joyau) t).nbr) {
                                case 1: {
                                    BufferedImage image = null;
                                    try {
                                        image = ImageIO.read(new File("images/joyaux/jrouge.png"));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Image dimage = image.getScaledInstance(62, 62, Image.SCALE_SMOOTH);
                                    ImageIcon icone = new ImageIcon(dimage);
                                    JLabel joyau = new JLabel(icone);
                                    joyau.setLayout(null);
                                    joyau.setBounds(j * 62, i * 62, 62, 62);
                                    plateauImg.add(joyau);
                                    break;
                                }
                                case 2: {
                                    BufferedImage image = null;
                                    try {
                                        image = ImageIO.read(new File("images/joyaux/jvert.png"));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Image dimage = image.getScaledInstance(62, 62, Image.SCALE_SMOOTH);
                                    ImageIcon icone = new ImageIcon(dimage);
                                    JLabel joyau = new JLabel(icone);
                                    joyau.setLayout(null);
                                    joyau.setBounds(j * 62, i * 62, 62, 62);
                                    plateauImg.add(joyau);
                                    break;
                                }
                                case 3: {
                                    BufferedImage image = null;
                                    try {
                                        image = ImageIO.read(new File("images/joyaux/jbleu.png"));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Image dimage = image.getScaledInstance(62, 62, Image.SCALE_SMOOTH);
                                    ImageIcon icone = new ImageIcon(dimage);
                                    JLabel joyau = new JLabel(icone);
                                    joyau.setLayout(null);
                                    joyau.setBounds(j * 62, i * 62, 62, 62);
                                    plateauImg.add(joyau);
                                    break;
                                }
                            }
                        }
                    }
                    default:
                        if (t instanceof Tortue) {
                            switch (((Tortue) t).orientation) {
                                case 1: {
                                    BufferedImage image = null;
                                    try {
                                        image = ImageIO.read(new File("images/tortues/" + t.nom + "N.png"));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Image dimage = image.getScaledInstance(62, 62, Image.SCALE_SMOOTH);
                                    ImageIcon icone = new ImageIcon(dimage);
                                    JLabel tortue = new JLabel(icone);
                                    tortue.setLayout(null);
                                    tortue.setBounds(j * 62, i * 62, 62, 62);
                                    plateauImg.add(tortue);
                                    break;
                                }
                                case 2: {
                                    BufferedImage image = null;
                                    try {
                                        image = ImageIO.read(new File("images/tortues/" + t.nom + "E.png"));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Image dimage = image.getScaledInstance(62, 62, Image.SCALE_SMOOTH);
                                    ImageIcon icone = new ImageIcon(dimage);
                                    JLabel tortue = new JLabel(icone);
                                    tortue.setLayout(null);
                                    tortue.setBounds(j * 62, i * 62, 62, 62);
                                    plateauImg.add(tortue);
                                    break;
                                }
                                case 3: {
                                    BufferedImage image = null;
                                    try {
                                        image = ImageIO.read(new File("images/tortues/" + t.nom + "S.png"));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Image dimage = image.getScaledInstance(62, 62, Image.SCALE_SMOOTH);
                                    ImageIcon icone = new ImageIcon(dimage);
                                    JLabel tortue = new JLabel(icone);
                                    tortue.setLayout(null);
                                    tortue.setBounds(j * 62, i * 62, 62, 62);
                                    plateauImg.add(tortue);
                                    break;
                                }
                                case 4: {
                                    BufferedImage image = null;
                                    try {
                                        image = ImageIO.read(new File("images/tortues/" + t.nom + "W.png"));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Image dimage = image.getScaledInstance(62, 62, Image.SCALE_SMOOTH);
                                    ImageIcon icone = new ImageIcon(dimage);
                                    JLabel tortue = new JLabel(icone);
                                    tortue.setLayout(null);
                                    tortue.setBounds(j * 62, i * 62, 62, 62);
                                    plateauImg.add(tortue);
                                    break;
                                }
                            }
                        }
                }
            }
        }
    }

    public static void updateMain() { //met a jour et affiche la main du joueur
        hand.removeAll();
        hand.setVisible(false);
        hand.setVisible(true);

        Joueur j = joueurActuel;

        for (int i = 0; i < j.main.size(); i++) {
            switch (j.main.get(i).type) {
                case "bleu": {
                    BufferedImage image = null;
                    try {
                        image = ImageIO.read(new File("images/cartes/carteBleu.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Image dimage = image.getScaledInstance(88, 125, Image.SCALE_SMOOTH);
                    ImageIcon icone = new ImageIcon(dimage);
                    JLabel bleu = new JLabel(icone);
                    bleu.setLayout(null);
                    switch (i) {
                        case 0: {
                            bleu.setBounds(10, 5, 88, 125);
                            hand.add(bleu);
                            break;
                        }
                        case 1: {
                            bleu.setBounds(108, 5, 88, 125);
                            hand.add(bleu);
                            break;
                        }
                        case 2: {
                            bleu.setBounds(206, 5, 88, 125);
                            hand.add(bleu);
                            break;
                        }
                        case 3: {
                            bleu.setBounds(304, 5, 88, 125);
                            hand.add(bleu);
                            break;
                        }
                        case 4: {
                            bleu.setBounds(402, 5, 88, 125);
                            hand.add(bleu);
                            break;
                        }
                    }
                    break;
                }
                case "jaune": {
                    BufferedImage image = null;
                    try {
                        image = ImageIO.read(new File("images/cartes/carteJaune.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Image dimage = image.getScaledInstance(88, 125, Image.SCALE_SMOOTH);
                    ImageIcon icone = new ImageIcon(dimage);
                    JLabel jaune = new JLabel(icone);
                    jaune.setLayout(null);
                    jaune.setBounds(0, 0, 88, 125);

                    switch (i) {
                        case 0: {
                            jaune.setBounds(10, 5, 88, 125);
                            hand.add(jaune);
                            break;
                        }
                        case 1: {
                            jaune.setBounds(108, 5, 88, 125);
                            hand.add(jaune);
                            break;
                        }
                        case 2: {
                            jaune.setBounds(206, 5, 88, 125);
                            hand.add(jaune);
                            break;
                        }
                        case 3: {
                            jaune.setBounds(304, 5, 88, 125);
                            hand.add(jaune);
                            break;
                        }
                        case 4: {
                            jaune.setBounds(402, 5, 88, 125);
                            hand.add(jaune);
                            break;
                        }
                    }
                    break;
                }
                case "violette": {
                    BufferedImage image = null;
                    try {
                        image = ImageIO.read(new File("images/cartes/carteViolet.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Image dimage = image.getScaledInstance(88, 125, Image.SCALE_SMOOTH);
                    ImageIcon icone = new ImageIcon(dimage);
                    JLabel violet = new JLabel(icone);
                    violet.setLayout(null);
                    violet.setBounds(0, 0, 88, 125);

                    switch (i) {
                        case 0: {
                            violet.setBounds(10, 5, 88, 125);
                            hand.add(violet);
                            break;
                        }
                        case 1: {
                            violet.setBounds(108, 5, 88, 125);
                            hand.add(violet);
                            break;
                        }
                        case 2: {
                            violet.setBounds(206, 5, 88, 125);
                            hand.add(violet);
                            break;
                        }
                        case 3: {
                            violet.setBounds(304, 5, 88, 125);
                            hand.add(violet);
                            break;
                        }
                        case 4: {
                            violet.setBounds(402, 5, 88, 125);
                            hand.add(violet);
                            break;
                        }
                    }
                }
                case "laser": {
                    BufferedImage image = null;
                    try {
                        image = ImageIO.read(new File("images/cartes/carteLaser.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Image dimage = image.getScaledInstance(88, 125, Image.SCALE_SMOOTH);
                    ImageIcon icone = new ImageIcon(dimage);
                    JLabel laser = new JLabel(icone);
                    laser.setLayout(null);
                    laser.setBounds(0, 0, 88, 125);

                    switch (i) {
                        case 0: {
                            laser.setBounds(10, 5, 88, 125);
                            hand.add(laser);
                            break;
                        }
                        case 1: {
                            laser.setBounds(108, 5, 88, 125);
                            hand.add(laser);
                            break;
                        }
                        case 2: {
                            laser.setBounds(206, 5, 88, 125);
                            hand.add(laser);
                            break;
                        }
                        case 3: {
                            laser.setBounds(304, 5, 88, 125);
                            hand.add(laser);
                            break;
                        }
                        case 4: {
                            laser.setBounds(402, 5, 88, 125);
                            hand.add(laser);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void updateItems() { //met a jour et affiche les compteurs des murs
        items.removeAll();
        items.setVisible(false);
        items.setVisible(true);

        Joueur.countItems(joueurActuel);

        BufferedImage imgPierre = null;
        try {
            imgPierre = ImageIO.read(new File("images/obstacles/pierre.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgPierre = imgPierre.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon iconPierre = new ImageIcon(dimgPierre);
        JLabel pilePierre = new JLabel(iconPierre);
        pilePierre.setLayout(null);
        pilePierre.setBounds(10, 10, 100, 100);
        items.add(pilePierre);

        compteurPierre.setLayout(null);
        compteurPierre.setBounds(120, 40, 40, 40);
        items.add(compteurPierre);

        BufferedImage imgGlace = null;
        try {
            imgGlace = ImageIO.read(new File("images/obstacles/glace.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgGlace = imgGlace.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon iconGlace = new ImageIcon(dimgGlace);
        JLabel pileGlace = new JLabel(iconGlace);
        pileGlace.setLayout(null);
        pileGlace.setBounds(10, 120, 100, 100);
        items.add(pileGlace);

        compteurGlace.setLayout(null);
        compteurGlace.setBounds(120, 150, 40, 40);
        items.add(compteurGlace);

        BufferedImage imgCaisse = null;
        try {
            imgCaisse = ImageIO.read(new File("images/obstacles/caisse.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgCaisse = imgCaisse.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon iconCaisse = new ImageIcon(dimgCaisse);
        JLabel pileCaisse = new JLabel(iconCaisse);
        pileCaisse.setBounds(10, 230, 100, 100);
        items.add(pileCaisse);

        compteurCaisse.setLayout(null);
        compteurCaisse.setBounds(120, 260, 40, 40);
        items.add(compteurCaisse);

        BufferedImage imgCarte = null;
        try {
            imgCarte = ImageIO.read(new File("images/cartes/carteDos.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgCarte = imgCarte.getScaledInstance(100, 137, Image.SCALE_SMOOTH);
        ImageIcon iconCarte = new ImageIcon(dimgCarte);
        JLabel pileProgramme = new JLabel(iconCarte);
        pileProgramme.setBounds(10, 340, 100, 137);
        items.add(pileProgramme);

        compteurProgramme.setLayout(null);
        compteurProgramme.setBounds(120, 390, 40, 40);
        compteurProgramme.setBackground(Color.BLACK);
        items.add(compteurProgramme);

        BufferedImage imgDefausse = null;
        try {
            imgDefausse = ImageIO.read(new File("images/cartes/carteDefausse.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgDefausse = imgDefausse.getScaledInstance(100, 137, Image.SCALE_SMOOTH);
        ImageIcon iconDefausse = new ImageIcon(dimgDefausse);
        JLabel defausse = new JLabel(iconDefausse);
        defausse.setBounds(10, 487, 100, 137);
        items.add(defausse);

        compteurDefausse.setLayout(null);
        compteurDefausse.setBounds(120, 537, 40, 40);
        compteurDefausse.setBackground(Color.BLACK);
        items.add(compteurDefausse);
    }
}

