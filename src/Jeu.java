import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Jeu {
    public static ArrayList<Joueur> listeJoueurs;
    public static Joueur joueurActuel;
    public static int joueurCompteur = 0;

    public static FenetreJeu fenetre;

    public static void nouvellePartie(int nombreJoueurs) {
        switch (nombreJoueurs) {
            case 2: {
                Plateau.initialisation();
                Plateau.adapterPlateau();

                Tortue rouge = new Tortue("rouge", 6, 3);
                Tortue bleu = new Tortue("bleu", 0, 5);

                Joyau joyau1 = new Joyau(1,7, 3);

                listeJoueurs = new ArrayList<>();

                String j1 = "Joueur 1";
                Joueur joueur1 = new Joueur(j1, rouge);

                String j2 = "Joueur 2";
                Joueur joueur2 = new Joueur(j2, bleu);
                listeJoueurs.add(joueur1);
                listeJoueurs.add(joueur2);

                tourJoueur(listeJoueurs.get(0));
                break;
            }
            case 3: {
                Plateau.initialisation();
                Plateau.adapterPlateau();

                Tortue rouge = new Tortue("rouge", 0, 0);
                Tortue bleu = new Tortue("bleu", 0, 3);
                Tortue violet = new Tortue("violet", 0, 6);

                Joyau joyau1 = new Joyau(1,7, 0);
                Joyau joyau2 = new Joyau(2,7, 3);
                Joyau joyau3 = new Joyau(3,7, 6);

                listeJoueurs = new ArrayList<>();

                String j1 = "Joueur 1";
                Joueur joueur1 = new Joueur(j1, rouge);

                String j2 = "Joueur 2";
                Joueur joueur2 = new Joueur(j2, bleu);

                String j3 = "Joueur 3";
                Joueur joueur3 = new Joueur(j3, violet);
                listeJoueurs.add(joueur1);
                listeJoueurs.add(joueur2);
                listeJoueurs.add(joueur3);

                tourJoueur(listeJoueurs.get(0));
                break;
            }
            case 4: {
                Plateau.initialisation();

                Tortue rouge = new Tortue("rouge", 0, 0);
                Tortue bleu = new Tortue("bleu", 0, 2);
                Tortue violet = new Tortue("violet", 0, 5);
                Tortue vert = new Tortue("vert", 0, 7);

                Joyau joyau1 = new Joyau(1,7, 1);
                Joyau joyau2 = new Joyau(2,7, 6);

                listeJoueurs = new ArrayList<>();

                String j1 = "Joueur 1";
                Joueur joueur1 = new Joueur(j1, rouge);

                String j2 = "Joueur 2";
                Joueur joueur2 = new Joueur(j2, bleu);

                String j3 = "Joueur 3";
                Joueur joueur3 = new Joueur(j3, violet);

                String j4 = "Joueur 4";
                Joueur joueur4 = new Joueur(j4, vert);
                listeJoueurs.add(joueur1);
                listeJoueurs.add(joueur2);
                listeJoueurs.add(joueur3);
                listeJoueurs.add(joueur4);

                tourJoueur(listeJoueurs.get(0));
                break;
            }
        }
    }

    public static void nextJoueur(){
        if (joueurCompteur == listeJoueurs.size()-1){
            joueurCompteur = 0;
        }
        else{
            joueurCompteur++;
        }
        System.out.println(listeJoueurs.get(joueurCompteur).nom);
        tourJoueur(listeJoueurs.get(joueurCompteur));
    }

    public static void tourJoueur(Joueur j) {
        joueurActuel = j;
        FenetreJeu.joueurActuel = j;

        countItems(j);
        j.completerMain();

        fenetre.updateFenetre();


        /*while (listeJoueurs.size() > 1) {
            for (Joueur h : listeJoueurs) {
                joueurActuel = j;

                Plateau.affichage();

                System.out.println("\nTour de " + j.nom);

                System.out.println("Tortue vers " + j.tortue.orientation);

                countListeObstacle(j);

                System.out.println("\nPioche : " + j.pioche.size() + " cartes.");

                j.completerMain();

                System.out.println("\nMain :");
                for (Carte c : j.main) {
                    System.out.println(c.type);
                }

                boolean error = false;
                while (!error) {
                    try {
                        System.out.println("\n1. Ajouter au programme\n2. Executer le programme\n3. Placer un obstacle\n4. Defausser une/des carte(s)\n5. Passer son tour");
                        Scanner scanner = new Scanner(System.in);
                        int choix = scanner.nextInt();
                        switch (choix) {
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
                            case 3: {
                                placerObstacle(j);
                                error = true;
                                break;
                            }
                            case 4: {
                                defausser(j);
                                error = true;
                                break;
                            }
                            case 5: {
                                error = true;
                                break;
                            }
                            default: {
                                throw new Exception();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Entrez 1, 2, 3 ou 4.");
                    }
                }
            }
        }*/
    }

    public static void countItems(Joueur j) {
        int p = 0;
        int g = 0;
        int c = 0;
        for (Obstacle o : j.piocheObstacle) {
            switch (o.nom) {
                case "pierre": {
                    p++;
                    break;
                }
                case "glace": {
                    g++;
                    break;
                }
                case "caisse": {
                    c++;
                    break;
                }
            }
        }
        FenetreJeu.compteurPierre.setText("x" + p);
        FenetreJeu.compteurGlace.setText("x" + g);
        FenetreJeu.compteurCaisse.setText("x" + c);

        int carte = 0;
        for(Carte i : j.instructions){
            carte++;
        }
        FenetreJeu.compteurProgramme.setText("x" + carte);

        int carteD = 0;
        for(Carte i : j.defausse){
            carteD++;
        }
        FenetreJeu.compteurDefausse.setText("x" + carteD);
    }
}
