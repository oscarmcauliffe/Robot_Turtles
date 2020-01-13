import javax.swing.plaf.BorderUIResource;
import java.util.Arrays;

public class Plateau {
    public static Tuile[][] plateau;

    public static void initialisation() {
        plateau = new Tuile[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                plateau[i][j] = new Tuile();
            }
        }
    }

    public static void affichage() {
        System.out.print("\n\n\n\n\n\n");
        for (int i = 0; i < 8; i++) {
            System.out.print("\n");
            for (int j = 0; j < 8; j++) {
                System.out.print("|"+plateau[i][j].nom+"|");
            }
        }
    }

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

    public static Tuile getTuile(int x, int y){
        return plateau[x][y];
    }

    public static void ajoutTuile(Tuile tuile, int x, int y){
        plateau[x][y] = tuile;
    }

    public static void deplacerTuile(Tuile tuile, int x, int y){
        int positionX = getPosition(tuile)[0];
        int positionY = getPosition(tuile)[1];
        plateau[positionX][positionY] = plateau[x][y];
        plateau[x][y] = tuile;
    }

    public static void adapterPlateau(){
        for (int i = 0; i < 8; i++){
            plateau[i][7] = new Obstacle("pierre");
        }
    }

}
