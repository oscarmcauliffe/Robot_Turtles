import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.plaf.BorderUIResource;
import java.util.Arrays;

public class Plateau {
    public static Tuile[][] plateau;

    //Cree le plateau de jeu
    public static void initialisation() {
        plateau = new Tuile[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                plateau[i][j] = new Tuile();
            }
        }
    }

    //Recupere la position d'une tuile
    public static int[] getPosition(Tuile tuile) {
        int[] position = new int[2];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (plateau[i][j] == tuile) {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        return position;
    }

    public static Tuile getTuile(int x, int y) {
        return plateau[x][y];
    }

    //Permet d'ajouter une tuile a des coordonees precises
    public static void ajoutTuile(Tuile tuile, int x, int y) {
        plateau[x][y] = tuile;
    }

    //Permet de deplacer une tuile a des coordonees precises
    public static void deplacerTuile(Tuile tuile, int x, int y) {
        int positionX = getPosition(tuile)[0];
        int positionY = getPosition(tuile)[1];
        plateau[positionX][positionY] = plateau[x][y];
        plateau[x][y] = tuile;
    }

    //Cree une colonne de murs de pierre pour les parties a 3 et 4 joueurs
    public static void adapterPlateau() {
        for (int i = 0; i < 8; i++) {
            plateau[i][7] = new Obstacle("pierre");
        }
    }

    //Verifie si le placement de l'obstacle serait problematique pour le deroulement du jeu
    public static boolean placementValide(int x, int y) {
        int cLigne = 0; //Lignes
        for (int j = 0; j < 8; j++) {
            if (plateau[x][j].nom.equals("pierre") || plateau[x][j].nom.equals("caisse") || plateau[x][j].nom.equals("joyau")) {
                cLigne++;
            }
        }
        if (cLigne >= 7) {
            return false;
        }

        int cColonne = 0; //Lignes
        for (int i = 0; i < 8; i++) {
            if (plateau[i][y].nom.equals("pierre") || plateau[i][y].nom.equals("caisse") || plateau[i][y].nom.equals("joyau")) {
                cColonne++;
            }
        }
        if (cColonne >= 7) {
            return false;
        }

        if (x - 1 >= 0) {
            if (getTuile(x - 1, y) != null) {
                Tuile nord = getTuile(x - 1, y);
                if (nord.nom.equals("joyau") || nord instanceof Tortue) {
                    int xNord = getPosition(nord)[0];
                    int yNord = getPosition(nord)[1];
                    int cNord = 0;
                    if (xNord + 1 < 8) {
                        if (getTuile(xNord + 1, yNord).nom.equals("pierre") || getTuile(xNord + 1, yNord).nom.equals("caisse") || getTuile(xNord + 1, yNord) == null) {
                            cNord++;
                        }
                    } else cNord++;
                    if (xNord - 1 >= 0) {
                        if (getTuile(xNord - 1, yNord).nom.equals("pierre") || getTuile(xNord - 1, yNord).nom.equals("caisse") || getTuile(xNord - 1, yNord) == null) {
                            cNord++;
                        }
                    } else cNord++;
                    if (yNord + 1 < 8) {
                        if (getTuile(xNord, yNord + 1).nom.equals("pierre") || getTuile(xNord, yNord + 1).nom.equals("caisse") || getTuile(xNord, yNord + 1) == null) {
                            cNord++;
                        }
                    } else cNord++;
                    if (yNord - 1 >= 0) {
                        if (getTuile(xNord, yNord - 1).nom.equals("pierre") || getTuile(xNord, yNord - 1).nom.equals("caisse") || getTuile(xNord, yNord - 1) == null) {
                            cNord++;
                        }
                    } else cNord++;

                    if (cNord >= 3) {
                        return false;
                    }
                }
            }
        }

        if (x + 1 < 8) {
            if (getTuile(x + 1, y) != null) {
                Tuile sud = getTuile(x + 1, y);
                if (sud.nom.equals("joyau") || sud instanceof Tortue) {
                    int xSud = getPosition(sud)[0];
                    int ySud = getPosition(sud)[1];
                    int cSud = 0;
                    if (xSud + 1 < 8) {
                        if (getTuile(xSud + 1, ySud).nom.equals("pierre") || getTuile(xSud + 1, ySud).nom.equals("caisse") || getTuile(xSud + 1, ySud) == null) {
                            cSud++;
                        }
                    } else cSud++;
                    if (xSud - 1 >= 0) {
                        if (getTuile(xSud - 1, ySud).nom.equals("pierre") || getTuile(xSud - 1, ySud).nom.equals("caisse") || getTuile(xSud - 1, ySud) == null) {
                            cSud++;
                        }
                    } else cSud++;
                    if (ySud + 1 < 8) {
                        if (getTuile(xSud, ySud + 1).nom.equals("pierre") || getTuile(xSud, ySud + 1).nom.equals("caisse") || getTuile(xSud, ySud + 1) == null) {
                            cSud++;
                        }
                    }
                    if (ySud - 1 >= 0) {
                        if (getTuile(xSud, ySud - 1).nom.equals("pierre") || getTuile(xSud, ySud - 1).nom.equals("caisse") || getTuile(xSud, ySud - 1) == null) {
                            cSud++;
                        }
                    } else cSud++;

                    if (cSud >= 3) {
                        return false;
                    }
                }
            }
        }

        if (y - 1 >= 0) {
            if (getTuile(x, y - 1) != null) {
                Tuile est = getTuile(x, y - 1);
                if (est.nom.equals("joyau") || est instanceof Tortue) {
                    int xEst = getPosition(est)[0];
                    int yEst = getPosition(est)[1];
                    int cEst = 0;
                    if (xEst + 1 < 8) {
                        if (getTuile(xEst + 1, yEst).nom.equals("pierre") || getTuile(xEst + 1, yEst).nom.equals("caisse") || getTuile(xEst + 1, yEst) == null) {
                            cEst++;
                        }
                    } else cEst++;
                    if (xEst - 1 >= 0) {
                        if (getTuile(xEst - 1, yEst).nom.equals("pierre") || getTuile(xEst - 1, yEst).nom.equals("caisse") || getTuile(xEst - 1, yEst) == null) {
                            cEst++;
                        }
                    } else cEst++;
                    if (yEst + 1 < 8) {
                        if (getTuile(xEst, yEst + 1).nom.equals("pierre") || getTuile(xEst, yEst + 1).nom.equals("caisse") || getTuile(xEst, yEst + 1) == null) {
                            cEst++;
                        }
                    }
                    if (yEst - 1 >= 0) {
                        if (getTuile(xEst, yEst - 1).nom.equals("pierre") || getTuile(xEst, yEst - 1).nom.equals("caisse") || getTuile(xEst, yEst - 1) == null) {
                            cEst++;
                        }
                    } else cEst++;

                    if (cEst >= 3) {
                        return false;
                    }
                }
            }
        }


        if (y + 1 < 8) {
            if (getTuile(x, y + 1) != null) {
                Tuile west = getTuile(x, y + 1);
                if (west.nom.equals("joyau") || west instanceof Tortue) {
                    int xWest = getPosition(west)[0];
                    int yWest = getPosition(west)[1];
                    int cWest = 0;
                    if (xWest + 1 < 8) {
                        if (getTuile(xWest + 1, yWest).nom.equals("pierre") || getTuile(xWest + 1, yWest).nom.equals("caisse")) {
                            cWest++;
                        }
                    } else cWest++;
                    if (xWest - 1 >= 0) {
                        if (getTuile(xWest - 1, yWest).nom.equals("pierre") || getTuile(xWest - 1, yWest).nom.equals("caisse")) {
                            cWest++;
                        }
                    } else {
                        cWest++;
                    }
                    if (yWest + 1 < 8) {
                        if (getTuile(xWest, yWest + 1).nom.equals("pierre") || getTuile(xWest, yWest + 1).nom.equals("caisse")) {
                            cWest++;
                        }
                    } else cWest++;
                    if (yWest - 1 >= 0) {
                        if (getTuile(xWest, yWest - 1).nom.equals("pierre") || getTuile(xWest, yWest - 1).nom.equals("caisse")) {
                            cWest++;
                        }
                    } else cWest++;

                    if (cWest >= 3) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}