import javax.swing.*;
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

    public Carte getCarteMain(int i){
        return this.main.get(i);
    }
}