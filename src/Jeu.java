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

                Scanner scanner = new Scanner(System.in);

                System.out.println("\nSaisissez le nom du Joueur 1 :");
                String j1 = scanner.next();
                Joueur joueur1 = new Joueur(j1, rouge);

                System.out.println("\nSaisissez le nom du Joueur 2 :");
                String j2 = scanner.next();
                Joueur joueur2 = new Joueur(j2, bleu);
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

                System.out.println("\nMain :");
                for (Carte c : j.main){
                    System.out.println(c.type);
                }

                boolean error = false;
                while (!error) {
                    try {
                        System.out.println("\n1. Ajouter au programme\n2. Executer le programme\n3. Placer un obstacle");
                        Scanner scanner = new Scanner(System.in);
                        int choix = scanner.nextInt();
                        switch (choix){
                            case 1: {
                                ajouterProgramme(j);
                                error = true;
                                break;
                            }
                            case 2: {
                                executerProgramme(j);
                                error = true;
                                break;
                            }
                            case 3:{
                                placerObstacle();
                                error = true;
                                break;
                            }
                            default:{
                                throw new Exception();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Entrez 1, 2 ou 3.");
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
        boolean error = false;
        while (!error){
            try {
                System.out.println("\nQuel type d'obstacle? (pierre/glace/caisse)");
                Scanner scanner = new Scanner(System.in);
                String choix = scanner.next();

                Obstacle obstacle = containsObstacle(piocheObstacle, choix);

                if (obstacle == null){
                    System.out.println("\nAucun obstacle de ce type disponible.");
                    throw new Exception();
                }
                else if (obstacle.nom.equals("pierre") || obstacle.nom.equals("glace") || obstacle.nom.equals("caisse")){
                    System.out.println("\nOù le placer?\nLigne?");
                    int x = scanner.nextInt();
                    System.out.println("\nColonne?");
                    int y = scanner.nextInt();

                    System.out.println(Plateau.getTuile(x,y).nom);

                    if(Plateau.getTuile(x,y).nom == null){
                        piocheObstacle.remove(obstacle);
                        Plateau.ajoutTuile(obstacle, x, y);
                        Plateau.affichage();
                        error = true;
                    }
                    else{
                        System.out.println("\nCase occupée!");
                        throw new Exception();
                    }
                }
                else{
                    throw new Exception();
                }
            } catch (Exception e){
                System.out.println("\nVeuillez réessayer.");
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

    public static void ajouterProgramme(Joueur j){
        boolean error = false;
        while (!error){
            try {
                if (j.main.size() > 0){
                    System.out.println("\nSélectionnez une carte de votre main.");
                    Scanner scanner = new Scanner(System.in);
                    int choix = scanner.nextInt();

                    if (choix == 0 || choix == 1 || choix == 2 || choix == 3 || choix == 4){
                        j.instructions.add(j.getCarteMain(choix));
                        j.main.remove(j.getCarteMain(choix));

                        System.out.println("\nMain :");
                        for (Carte c : j.main){
                            System.out.println(c.type);
                        }

                        boolean errorAjout = false;
                        while (!errorAjout){
                            try{
                                System.out.println("\nVoulez-vous ajouter une autre carte?");
                                String ajout = scanner.next();
                                if (ajout.equals("Oui")){
                                    errorAjout = true;
                                }
                                else if (ajout.equals("Non")){
                                    errorAjout = true;
                                    error = true;
                                }
                                else{
                                    throw new Exception();
                                }
                            } catch (Exception e){
                                System.out.println("\nVeuillez réessayer.");
                            }
                        }
                    }
                    else {
                        throw new Exception();
                    }
                }
                else{
                    System.out.println("\nVous n'avez plus de cartes.");
                    error = true;
                }
            } catch (Exception e){
                System.out.println("\nVeuillez réessayer.");
            }
        }
    }

    public static void executerProgramme(Joueur j){

    }
}
