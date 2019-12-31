import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Joueur {
    String nom;
    int score;
    Tortue tortue;
    ArrayDeque<Carte> pioche;
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
        do{
            this.main.add(this.pioche.poll());
        }while (this.main.size() < 5);
    }
}