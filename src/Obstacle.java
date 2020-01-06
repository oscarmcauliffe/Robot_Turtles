import java.util.ArrayList;

public class Obstacle extends Tuile{
    String type;

    public Obstacle(String t){
        switch (t){
            case "pierre":{
                type = t;
                break;
            }
            case "glace":{
                type = t;
                break;
            }
            case "caisse":{
                type = t;
                break;
            }
            default:{
                type = "pierre";
                break;
            }
        }
        nom = type;
    }

    public static ArrayList<Obstacle> listeObstacles(){
        ArrayList<Obstacle> oJ = new ArrayList();
        for (int i = 0; i < 3; i++){
            oJ.add(new Obstacle("pierre"));
        }
        for (int i = 0; i < 2; i++){
            oJ.add(new Obstacle("glace"));
        }
        for (int i = 0; i < 1; i++){
            oJ.add(new Obstacle("caisse"));
        }
        return oJ;
    }
}
