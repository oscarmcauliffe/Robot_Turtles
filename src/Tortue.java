import java.util.ArrayList;

public class Tortue extends Tuile{
    int[] positiondepart;
    int orientation; // 1=N; 2=E; 3=S; 4=W;

    public Tortue(String n, int x, int y){
        nom = n;
        orientation = 1;
        positiondepart = new int[2];
        positiondepart[0] = x;
        positiondepart[1] = y;
        Plateau.ajoutTuile(this, x, y);
    }

}