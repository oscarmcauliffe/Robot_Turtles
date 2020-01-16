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

                Tortue rouge = new Tortue("rouge", 0, 1);
                Tortue bleu = new Tortue("bleu", 0, 5);

                Joyau joyau1 = new Joyau(1,7, 3);

                listeJoueurs = new ArrayList<>();

                Scanner scanner = new Scanner(System.in);

                //System.out.println("\nSaisissez le nom du Joueur 1 :");
                //String j1 = scanner.next();

                String j1 = "Joueur 1";
                Joueur joueur1 = new Joueur(j1, rouge);

                //System.out.println("\nSaisissez le nom du Joueur 2 :");
                //String j2 = scanner.next();

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

                Plateau.affichage();
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

                Plateau.affichage();
                break;
            }
        }
    }

    public static void nextJoueur(){
        if (joueurCompteur == 1){
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

        System.out.println("\nTour de " + j.nom);

        countListeObstacle(j);
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

    private static void countListeObstacle(Joueur j) {
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
        System.out.println("\nPierre : " + p);
        System.out.println("Glace : " + g);
        System.out.println("Caisse : " + c);
    }



    private static void ajouterProgramme(Joueur j) {
        Scanner scanner = new Scanner(System.in);

        boolean error = false;
        while (!error) {
            try {
                if (j.main.size() > 0) {
                    System.out.println("\nSélectionnez une carte de votre main.");
                    int choix = scanner.nextInt();

                    if (choix == 0 || choix == 1 || choix == 2 || choix == 3 || choix == 4) {
                        j.instructions.add(j.getCarteMain(choix));
                        j.main.remove(j.getCarteMain(choix));

                        System.out.println("\nMain :");
                        for (Carte c : j.main) {
                            System.out.println(c.type);
                        }

                        boolean errorAjout = false;
                        while (!errorAjout) {
                            try {
                                System.out.println("\nVoulez-vous ajouter une autre carte?");
                                String ajout = scanner.next();
                                if (ajout.equals("Oui")) {
                                    errorAjout = true;
                                } else if (ajout.equals("Non")) {
                                    errorAjout = true;
                                    error = true;
                                } else {
                                    throw new Exception();
                                }
                            } catch (Exception e) {
                                System.out.println("\nVeuillez réessayer.");
                            }
                        }
                    } else {
                        throw new Exception();
                    }
                } else {
                    System.out.println("\nVous n'avez plus de cartes.");
                    error = true;
                }
            } catch (Exception e) {
                System.out.println("\nVeuillez réessayer.");
            }
        }
        defausserPlus(j);
    }

    private static void executerProgramme(Joueur j) {
        Scanner scanner = new Scanner(System.in);

        if (j.instructions.size() == 0) {
            System.out.println("\nProgramme exécuté.");
        } else {
            while (j.instructions.size() > 0) {
                try {
                    Carte next = j.instructions.poll();
                    j.defausse.add(next);
                    next.action(j.tortue);
                } catch (Exception e) {
                    System.out.println("erreur programme");
                    System.out.println(e);
                }
            }
            System.out.println("\nProgramme exécuté.");
        }
        defausserPlus(j);
    }

    private static void defausser(Joueur j) {
        boolean error = false;
        while (!error) {
            try {
                if (j.main.size() > 0) {
                    System.out.println("\nSélectionnez une carte de votre main.");
                    Scanner scanner = new Scanner(System.in);
                    int choix = scanner.nextInt();

                    if (choix == 0 || choix == 1 || choix == 2 || choix == 3 || choix == 4) {
                        j.defausse.add(j.getCarteMain(choix));
                        j.main.remove(j.getCarteMain(choix));

                        System.out.println("\nMain :");
                        for (Carte c : j.main) {
                            System.out.println(c.type);
                        }

                        boolean errorAjout = false;
                        while (!errorAjout) {
                            try {
                                System.out.println("\nVoulez-vous defausser une autre carte?");
                                String ajout = scanner.next();
                                if (ajout.equals("Oui")) {
                                    errorAjout = true;
                                } else if (ajout.equals("Non")) {
                                    errorAjout = true;
                                    error = true;
                                } else {
                                    throw new Exception();
                                }
                            } catch (Exception e) {
                                System.out.println("\nVeuillez réessayer.");
                            }
                        }
                    } else {
                        throw new Exception();
                    }
                } else {
                    System.out.println("\nVous n'avez plus de cartes.");
                    error = true;
                }
            } catch (Exception e) {
                System.out.println("\nVeuillez réessayer.");
            }
        }
    }

    private static void defausserPlus(Joueur j){
        Scanner scanner = new Scanner(System.in);

        if (j.main.size() > 0) {
            boolean errordefausse = false;
            while (!errordefausse) {
                try {
                    System.out.println("\nVoulez-vous defausser des cartes?");
                    String ajout = scanner.next();
                    if (ajout.equals("Oui")) {
                        defausser(j);
                        errordefausse = true;
                    } else if (ajout.equals("Non")) {
                        errordefausse = true;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("\nVeuillez réessayer.");
                }
            }
        }
    }
}
