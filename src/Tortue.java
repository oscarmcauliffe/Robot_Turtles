import java.util.ArrayList;

public class Tortue extends Tuile{
    int[] positiondepart;
    int orientation; // 1=N; 2=E; 3=S; 4=W;

    //créer une tortue en lui attribuant un nom, une orientation et une position de depart + ajout au plateau
    public Tortue(String n, int x, int y){
        nom = n;
        orientation = 3;
        positiondepart = new int[2];
        positiondepart[0] = x;
        positiondepart[1] = y;
        Plateau.ajoutTuile(this, x, y);
    }

    //methode permettant de tourner l'orientation de la tortue de 90°
    public void retourner(){
        int orientationFinale = 0;
        switch (this.orientation){
            case 1:{
                orientationFinale = 3;
                break;
            }
            case 2:{
                orientationFinale = 4;
                break;
            }
            case 3:{
                orientationFinale = 1;
                break;
            }
            case 4:{
                orientationFinale = 2;
                break;
            }
        }
        this.orientation = orientationFinale;
    }
}