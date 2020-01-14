public class Joyau extends Tuile{
    int nbr;

    public Joyau(int i, int x, int y){
        nom = "joyau";
        nbr=i;
        Plateau.ajoutTuile(this, x, y);
    }
}
