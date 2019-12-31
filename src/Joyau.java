public class Joyau extends Tuile{
    public Joyau(int x, int y){
        nom = "joyau";
        Plateau.ajoutTuile(this, x, y);
    }

    public Joyau(String n, int x, int y){
        nom = n;
        Plateau.ajoutTuile(this, x, y);
    }
}
