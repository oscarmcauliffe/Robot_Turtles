import javax.swing.plaf.BorderUIResource;
import java.util.Arrays;

public class Plateau {
    public static Tuile[][] plateau;
    //initialise un plateau en matrice 8x8
    public static void initialisation() {
        plateau = new Tuile[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                plateau[i][j] = new Tuile();
            }
        }
    }
    //getter permetant de recuperer la position d'une tuile
    public static int[] getPosition(Tuile tuile){
        int[] position = new int[2];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (plateau[i][j]==tuile){
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        return position;
    }

    //getter permettant de recuperer une tuile
    public static Tuile getTuile(int x, int y){
        return plateau[x][y];
    }

    //ajoute une tuile sur le plateau
    public static void ajoutTuile(Tuile tuile, int x, int y){
        plateau[x][y] = tuile;
    }

    //deplace une tuile sur le plateau
    public static void deplacerTuile(Tuile tuile, int x, int y){
        int positionX = getPosition(tuile)[0];
        int positionY = getPosition(tuile)[1];
        plateau[positionX][positionY] = plateau[x][y];
        plateau[x][y] = tuile;
    }
    //adapte la plateau en fonction du nombre de joueurs
    public static void adapterPlateau(){
        for (int i = 0; i < 8; i++){
            plateau[i][7] = new Obstacle("pierre");
        }
    }


}
