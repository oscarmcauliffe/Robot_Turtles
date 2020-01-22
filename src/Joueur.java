import javax.swing.*;
import javax.swing.plaf.synth.SynthStyleFactory;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Joueur {
    String nom;
    int score;
    Tortue tortue;
    ArrayDeque<Carte> pioche;
    ArrayList<Obstacle> piocheObstacle;
    ArrayList<Carte> main;
    ArrayDeque<Carte> instructions;
    ArrayList<Carte> defausse;

    //definit les attributs du joueur
    public Joueur(String n, Tortue t){
        nom = n;
        tortue = t;
        score = 0;
        pioche = nouvellePioche();
        main = new ArrayList<>();
        instructions = new ArrayDeque<>();
        defausse = new ArrayList<>();
        piocheObstacle = Obstacle.listeObstacles();
    }

    //créer la pioche du joueur
    public ArrayDeque<Carte> nouvellePioche(){
        ArrayList<Carte> piocheliste = new ArrayList();
        for (int i = 0; i < 18; i++){
            piocheliste.add(new Carte("bleu"));
        }
        for (int i = 0; i < 8; i++){
            piocheliste.add(new Carte("jaune"));
        }
        for (int i = 0; i < 8; i++){
            piocheliste.add(new Carte("violette"));
        }
        for (int i = 0; i < 3; i++){
            piocheliste.add(new Carte("laser"));
        }
        Collections.shuffle(piocheliste);

        ArrayDeque<Carte> pioche = new ArrayDeque<>(piocheliste);
        return pioche;
    }

    //permet de completer la main afin que le joueur ait 5 cartes
    public void completerMain(){
        if (this.main.size() < 5){
            do{
                if (pioche.size() == 0){
                    Collections.shuffle(defausse);
                    pioche = new ArrayDeque<>(defausse);
                    for (Carte c : defausse){
                        defausse.remove(c);
                    }
                }
                else {
                    this.main.add(this.pioche.poll());
                }
            } while (this.main.size() < 5);
        }
    }

    //getter permettant de recuperer la carte a l'index i dans la liste main
    public Carte getCarteMain(int i){
        return this.main.get(i);
    }

    //retire la tortue lorsque le joueur a gagne
    public void retirerTortue(){
        int x = Plateau.getPosition(this.tortue)[0];
        int y = Plateau.getPosition(this.tortue)[1];
        Plateau.plateau[x][y] = new Tuile();
    }

    //compte le nombre de mur disponible
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
        for (Carte i : j.instructions) {
            carte++;
        }
        FenetreJeu.compteurProgramme.setText("x" + carte);

        int carteD = 0;
        for (Carte i : j.defausse) {
            carteD++;
        }
        FenetreJeu.compteurDefausse.setText("x" + carteD);
    }
}