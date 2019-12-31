import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Jeu {
    public static Joueur[] listeJoueurs;
    public static ArrayList<Obstacle> piocheObstacle;

    public static void nouvellePartie(int nombreJoueurs){
        switch (nombreJoueurs){
            case 2: {
                Plateau.initialisation();
                Plateau.adapterPlateau();

                Tortue rouge = new Tortue("rouge", 0, 1);
                Tortue bleu = new Tortue("bleu", 0, 5);

                Joyau joyau = new Joyau(7, 3);

                listeJoueurs = new Joueur[nombreJoueurs];
                Joueur joueur1 = new Joueur("Oscar", rouge);
                Joueur joueur2 = new Joueur("Thomas", bleu);
                listeJoueurs[0] = joueur1; listeJoueurs[1] = joueur2;

                piocheObstacle = Obstacle.listeObstacles();

                Plateau.affichage();

                tourJoueur();
                break;
            }
            case 3: {
                Plateau.initialisation();
                Plateau.adapterPlateau();

                Tortue rouge = new Tortue("rouge", 0, 0);
                Tortue bleu = new Tortue("bleu", 0, 3);
                Tortue violet = new Tortue("violet", 0, 6);

                Joyau joyau1 = new Joyau(7, 0);
                Joyau joyau2 = new Joyau(7, 3);
                Joyau joyau3 = new Joyau(7, 6);

                listeJoueurs = new Joueur[nombreJoueurs];

                Plateau.affichage();
                break;
            }
            case 4: {
                Plateau.initialisation();

                Tortue rouge = new Tortue("rouge", 0, 0);
                Tortue bleu = new Tortue("bleu", 0, 2);
                Tortue violet = new Tortue("violet", 0, 5);
                Tortue vert = new Tortue("vert", 0, 7);

                Joyau joyau1 = new Joyau(7, 1);
                Joyau joyau2 = new Joyau(7, 6);

                listeJoueurs = new Joueur[nombreJoueurs];

                Plateau.affichage();
                break;
            }
        }
    }

    public static void tourJoueur(){
        while (listeJoueurs.length != 0){
            for (Joueur j : listeJoueurs){
                System.out.println("\nTour de "+j.nom);

                countListeObstacle();

                System.out.println("\nPioche : " + j.pioche.size() + " cartes.");

                j.completerMain();

                System.out.println("\nMain : ");
                for (Carte c : j.main){
                    System.out.println(c.type);
                }


                System.out.println("\n1. Ajouter au programme\n2. Executer le programme\n3. Placer un obstacle");
                Scanner scanner = new Scanner(System.in);
                switch (scanner.nextInt()){
                    case 1: {
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3:{
                        placerObstacle();
                        break;
                    }
                }
            }
        }
    }

    public static void countListeObstacle(){
        int p=0;int g=0;int c=0;
        for (Obstacle o : piocheObstacle){
            switch (o.type){
                case "pierre": {
                    p++;
                    break;
                }
                case "glace": {
                    g++;
                    break;
                }
                case "caisse":{
                    c++;
                    break;
                }
            }
        }
        System.out.println("\nPierre : "+p);
        System.out.println("Glace : "+g);
        System.out.println("Caisse : "+c);
    }

    public static void placerObstacle(){
        System.out.println("\nQuel type d'obstacle? (pierre/glace/caisse)");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        if (containsObstacle(piocheObstacle, choix) == null){
            System.out.println("\nAucun obstacle de ce type disponible.");
        }
        else{
            System.out.println("\nOù le placer?\nLigne?");
            int x = scanner.nextInt();
            System.out.println("\nColonne?");
            int y = scanner.nextInt();

            if(Plateau.getTuile(x,y).nom.equals(null)){

            }
        }
    }

    public static Obstacle containsObstacle(ArrayList<Obstacle> pioche, String type){
        for (Obstacle o : pioche){
            if (o.type.equals(type)){
                return o;
            }
        }
        return null;
    }
}
