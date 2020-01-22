import java.util.ArrayList;
import java.lang.Object;

public class Jeu {
    public static ArrayList<Joueur> listeJoueurs;
    public static Joueur joueurActuel;
    public static int joueurCompteur = 0;

    public static FenetreJeu fenetre;

    //initialise une matrice en fonction du nombre de joueurs dans la partie et definit tous ce qu'il y a sur le plateau et lance le premier tour
    public static void nouvellePartie(int nombreJoueurs) {
        switch (nombreJoueurs) {
            case 2: {
                Plateau.initialisation();
                Plateau.adapterPlateau();

                Tortue rouge = new Tortue("rouge", 0, 1);
                Tortue bleu = new Tortue("bleu", 0, 5);

                Joyau joyau1 = new Joyau(1, 7, 3);

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

                Joyau joyau1 = new Joyau(1, 7, 0);
                Joyau joyau2 = new Joyau(2, 7, 3);
                Joyau joyau3 = new Joyau(3, 7, 6);

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

                Joyau joyau1 = new Joyau(1, 7, 1);
                Joyau joyau2 = new Joyau(2, 7, 6);

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
    //Permet de passer a un autre joueur
    public static void nextJoueur() {
        if (listeJoueurs.size() == 1){
            FenetreGagne fenetrePerdu = new FenetreGagne(listeJoueurs.get(0),false);
            fenetrePerdu.setVisible(true);
            fenetre.dispose();
        }
        else{
            if (joueurCompteur == listeJoueurs.size() - 1) {
                joueurCompteur = 0;
            } else {
                joueurCompteur++;
            }
            tourJoueur(listeJoueurs.get(joueurCompteur));
        }
    }
    // dans une partie a plusieurs permet de passer au joueur suivant en prenant en compte la possibilité qu'un joueur ai gagné
    public static void nextJoueurGagne() {
        if (listeJoueurs.size() == 1){
            FenetreGagne fenetrePerdu = new FenetreGagne(listeJoueurs.get(0),false);
            fenetrePerdu.setVisible(true);
            fenetre.dispose();
        }
        else{
            joueurCompteur--;
            if (joueurCompteur == listeJoueurs.size() - 1) {
                joueurCompteur = 0;
            } else {
                joueurCompteur++;
            }
            tourJoueur(listeJoueurs.get(joueurCompteur));
        }
    }

    //definit le joueur actuel, complete sa main et met a jour les compteurs de ses murs
    public static void tourJoueur(Joueur j) {
        joueurActuel = j;
        FenetreJeu.joueurActuel = j;
        FenetreJeu.actionValide = false;

        j.countItems(j);
        j.completerMain();

        fenetre.updateFenetre();
    }

    //execute les cartes placée dans la pile d'instruction
    public static void executerProgramme(Joueur j){
        if (j.instructions.size() != 0){
            for(Carte c : j.instructions){
                Carte next = j.instructions.poll();
                j.defausse.add(next);
                next.action(j.tortue);
                fenetre.updateFenetre();
            }
        }
    }
}
