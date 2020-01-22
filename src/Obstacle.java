import java.util.ArrayList;
//classe definissant chaques type de mur par un nom (par defaut pierre)
public class Obstacle extends Tuile{

    public Obstacle(String n){
        switch (n){
            case "pierre":
            case "glace":
            case "caisse":{
                nom = n;
                break;
            }
            default:{
                nom = "pierre";
                break;
            }
        }
    }

    //cree les obstacles pour chaque joueurs
    public static ArrayList<Obstacle> listeObstacles(){
        ArrayList<Obstacle> pioche = new ArrayList();
        for (int i = 0; i < 3; i++){
            pioche.add(new Obstacle("pierre"));
        }
        for (int i = 0; i < 2; i++){
            pioche.add(new Obstacle("glace"));
        }
        for (int i = 0; i < 1; i++){
            pioche.add(new Obstacle("caisse"));
        }
        return pioche;
    }
}
