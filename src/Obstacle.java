import java.util.ArrayList;

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
