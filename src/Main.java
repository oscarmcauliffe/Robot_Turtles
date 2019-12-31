import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Nombre de joueurs?\n");
        Scanner scanner = new Scanner(System.in);
        int nbJoueur = scanner.nextInt();

        Jeu.nouvellePartie(nbJoueur);
    }


    public static ArrayDeque<String> creationFile() {
        ArrayDeque<String> instructions = new ArrayDeque<>();
        String entree;
        do {
            System.out.print("\nSaisissez \n“A” pour avancer \n“G” pour faire un quart de tour vers la gauche \n“D” pour faire un quart de tour vers la droite.");
            Scanner scanner = new Scanner(System.in);
            entree = scanner.next();
            if (entree.equals("A") || entree.equals("G") || entree.equals("D")) {
                instructions.add(entree);
            }
        } while (instructions.size() < 5);
        return instructions;
    }

    /*public static void deplacement(ArrayDeque<String> instructions, Tortue tortue) {
        do {
            String next = instructions.poll();
            if(next.equals("A")){
                if(tortue.orientation == 1){
                    tortue.position[0] -= 1;
                }
                else if(tortue.orientation == 2){
                    tortue.position[1] += 1;
                }
                else if(tortue.orientation == 3){
                    tortue.position[0] += 1;
                }
                else if(tortue.orientation == 4){
                    tortue.position[1] -= 1;
                }
            }
            else if(next.equals("D")){
                if(tortue.orientation == 4){
                    tortue.orientation = 1;
                }
                else {
                    tortue.orientation += 1;
                }
            }
            else if(next.equals("G")){
                if(tortue.orientation == 1){
                    tortue.orientation = 4;
                }
                else {
                    tortue.orientation -= 1;
                }
            }
        } while (instructions.size() != 0);
    }*/
}