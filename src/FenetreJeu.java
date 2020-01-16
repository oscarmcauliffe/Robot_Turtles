import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

public class FenetreJeu extends JFrame {

    public static Joueur joueurActuel;
    public static JLabel plateauImg;
    public static JPanel hand;
    public static JPanel joueur;
    public static JPanel items;
    public static JButton btnPlacer;
    public static JLabel compteurPierre = new JLabel("");
    public static JLabel compteurGlace = new JLabel("");
    public static JLabel compteurCaisse = new JLabel("");

    public FenetreJeu() {

        super("Robot Turtles");       // initialise le titre de le fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //arrete le programme lorsque toutes les fenetres sont fermées
        this.setSize(1300, 725);
        //this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);       //permet de gerer la taille de la fenetre
        this.setLocationRelativeTo(null);         //place la fenetre par rapport a une autre fenetre, la valeur nulle correspond au bureau
        this.getContentPane().setLayout(null);

        hand = new JPanel();
        hand.setLayout(null);
        hand.setBounds(368, 553, 500, 130);
        //hand.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(hand);

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
        items.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(items);

        JPanel pileProgramme = new JPanel();
        pileProgramme.setLayout(null);
        pileProgramme.setBounds(25, 513, 100, 150);
        pileProgramme.setBackground(Color.BLACK);
        //carte1.setBorder(BorderFactory.createLineBorder(Color.black));
        items.add(pileProgramme);

        JPanel compteurProgramme = new JPanel();
        compteurProgramme.setLayout(null);
        compteurProgramme.setBounds(140, 573, 50, 30);
        compteurProgramme.setBackground(Color.BLACK);
        items.add(compteurProgramme);

        JPanel actions = new JPanel();
        actions.setLayout(null);
        actions.setBounds(0, 263, 320, 420);
        actions.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(actions);

        btnPlacer = new JButton("Placer");
        btnPlacer.setBounds(85, 15, 150, 64);

        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.setBounds(85, 99, 150, 64);

        JButton btnExecuter = new JButton("Executer");
        btnExecuter.setBounds(85, 183, 150, 64);

        JButton btnDefausser = new JButton("Defausser");
        btnDefausser.setBounds(85, 267, 150, 64);

        JButton btnPasser = new JButton("Passer");
        btnPasser.setBounds(85, 351, 150, 64);

        joueur = new JPanel();
        joueur.setLayout(null);
        joueur.setBounds(0, 80, 250, 100);
        joueur.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(joueur);


        actions.add(btnPlacer);
        actions.add(btnAjouter);
        actions.add(btnExecuter);
        actions.add(btnDefausser);
        actions.add(btnPasser);

        btnPlacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlacer.setEnabled(false);
                FenetreObstacle myWindow = new FenetreObstacle();
                myWindow.setVisible(true);
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

    public static void updateFenetre() {
        updatePlateau(Plateau.plateau);
        updateMain();
        updateJoueur();
        updateItems();
    }

    public static void updateJoueur() {
        joueur.removeAll();
        joueur.setVisible(false);
        joueur.setVisible(true);

        JLabel nomJoueur = new JLabel("Tour du " + joueurActuel.nom);
        nomJoueur.setLayout(null);
        nomJoueur.setBounds(0, 0, 250, 100);
        joueur.add(nomJoueur);
    }

    public static void updatePlateau(Tuile[][] p) {
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

    public static void updateMain() {
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

    public static void updateItems(){
        items.removeAll();
        items.setVisible(false);
        items.setVisible(true);

        Jeu.countListeObstacle(joueurActuel);

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
    }
}

