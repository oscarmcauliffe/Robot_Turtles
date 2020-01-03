
public class Carte {
    String type;        //bleu, jaune, violette, laser

    public Carte(String t){
        type = t;
    }

    public void action(Tortue t){
        switch (this.type){
            case "bleu":{
                avancer(t,t.orientation);
            }
            case "jaune":{
                gauche(t.orientation);
            }
            case "violette":{
                droite(t.orientation);
            }
            case "laser":{
            }
        }
    }

    public static void avancer (Tortue t, int orientation){  /* rajouter le test mur */
        switch (orientation){
            case 1:{
                if (Plateau.getPosition(t)[0] == 0){
                    //retourne pt de départ
                }
                else{
                    Tuile devant = Plateau.getTuile(Plateau.getPosition(t)[0],Plateau.getPosition(t)[1]);
                    switch (devant.nom){
                        case "joyaux":{
                            //gagne
                            break;
                        }

                        case "pierre":
                        case "glace":
                        case "caisse":{
                            t.retourner();
                            break;
                        }

                        case "vide":{
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                }
                break;
            }
            case 2:{
                break;
            }
            case 3:{
                break;
            }
            case 4:{
                break;
            }
        }
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
