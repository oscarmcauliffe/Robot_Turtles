import javax.net.ssl.SSLContext;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MenuAcceuil myWindow = new MenuAcceuil();  //creation de le fenetre
        myWindow.setVisible( true );


        /*while (!error){
            try{



                System.out.print("Nombre de joueurs?\n");
                Scanner scanner = new Scanner(System.in);
                int nbJoueur = scanner.nextInt();
                if (nbJoueur == 2 || nbJoueur == 3 || nbJoueur == 4){
                    error = true;

                    Jeu.nouvellePartie(nbJoueur);
                }
                else {
                    throw new Exception();
                }
            }catch (Exception e){
                System.out.println("Entrez 2, 3 ou 4.");
            }
        }*/
    }
}