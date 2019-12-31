
public class Carte {
    String type;        //bleu, jaune, violette, laser

    public Carte(String t){
        type = t;
    }

    public static void action(Carte c, Tortue t){
        /*switch (c.type){
            case "bleu":{
                avancer(t.orientation);
            }
            case "jaune":{
                gauche(t.orientation);
            }
            case "violette":{
                droite(t.orientation);
            }
            case "laser":{
                laser(t.orientation);
            }
        }*/
    }

    public static void droite (int orientation) { /* fonction qui prend en argument l'orientation et qui tourne la tortue vers la droite */
        orientation ++ ;
        if (orientation == 5) {
            orientation = 1 ;
        }

    }

    public static void gauche (int orientation) { /* fonction qui prend en argument l'orientation et qui tourne la tortue vers la droite */
        orientation -- ;
        if (orientation == 0) {
            orientation = 4 ;
        }
    }

    public static void avancer (int[] position, int orientation) {  /* rajouter le test mur */
        if (orientation == 1) {
            position[0] --;

        }
        else if (orientation == 3) {
            position[0] ++ ;
        }
        else if (orientation == 2) {
            position[1] --;
        }
        else {
            position[1] ++;
        }
    }

    /*public static void laser (int[] position,int orientation,int[] plateau){ *//* identifer les tuiles *//*
        if (orientation == 1) {

            for (int i=position[0]; i>-1; i--){
                if (plateau[i].contains("P"){ *//* trouver comment identifier les tuiles sur le plateau *//*

                }
                else if (plateau[i]==)
            }
        }
        else if (orientation == 3) {
            for (int i=position[0]; i<9; i++){

            }
        }
        else if (orientation == 2) {
            for (int i=position[1]; i>-1; i--){

            }
        }
        else {
            for (int i=position[1]; i<9; i++){

            }
        }
    }*/
}
