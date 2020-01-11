import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MenuPrincipal {

    super("Robot Turtles");       // initialise le titre de le fenetre
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);         //arrete le programme lorsque toutes les fenetres sont fermées
    this.setSize(600, 400);         //permet de gerer la taille de la fenetre
    this.setLocationRelativeTo(null);         //place la fenetre par rapport a une autre fenetre, la valeur nulle correpsond au bureau
    this.getContentPane().setLayout(null);

    public static void main(String[] args) throws Exception{
        // Applique un look and feel
        UIManager.setLookAndFeel( new NimbusLookAndFeel());
        // Create my windows
        MenuAcceuil myWindow = new MenuAcceuil();  //creation de le fenetre
        myWindow.setVisible( true );
    }
}
