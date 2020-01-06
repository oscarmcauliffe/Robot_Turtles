
public class Carte {
    String type;        //bleu, jaune, violette, laser

    public Carte(String t){
        type = t;
    }

    public void action(Tortue t){
        switch (this.type){
            case "bleu":{
                avancer(t);
            }
            case "jaune":{
                gauche(t);
            }
            case "violette":{
                droite(t);
            }
            case "laser":{
                laser(t);
            }
        }
    }

    private static void avancer (Tortue t){  /* rajouter le test mur */
        System.out.println("ACTION");
        switch (t.orientation){
            case 1:{
                if (Plateau.getPosition(t)[0] == 0){
                    Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                }
                else{
                    Tuile devant = Plateau.getTuile(Plateau.getPosition(t)[0]-1,Plateau.getPosition(t)[1]);
                    System.out.println(devant.nom);
                    switch (devant.nom){
                        case "joyaux":{
                            //gagne
                            break;
                        }

                        case "pierre":
                        case "glace":{
                            t.retourner();
                            break;
                        }

                        case "caisse":{
                            break;
                        }

                        case "vide":{
                            Plateau.deplacerTuile(t,Plateau.getPosition(t)[0]-1,Plateau.getPosition(t)[1]);
                            break;
                        }
                        default:{
                            if(devant instanceof Tortue){
                                Plateau.deplacerTuile(devant,((Tortue) devant).positiondepart[0],((Tortue) devant).positiondepart[1]);
                                Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                            }
                            break;
                        }
                    }
                }
                break;
            }
            case 2:{
                if (Plateau.getPosition(t)[1] == 7){
                    Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                }
                else{
                    Tuile devant = Plateau.getTuile(Plateau.getPosition(t)[0],Plateau.getPosition(t)[1]+1);
                    System.out.println(devant.nom);
                    switch (devant.nom){
                        case "joyaux":{
                            //gagne
                            break;
                        }

                        case "pierre":
                        case "glace":{
                            t.retourner();
                            break;
                        }

                        case "caisse":{
                            break;
                        }

                        case "vide":{
                            Plateau.deplacerTuile(t,Plateau.getPosition(t)[0],Plateau.getPosition(t)[1]+1);
                            break;
                        }
                        default:{
                            if(devant instanceof Tortue){
                                Plateau.deplacerTuile(devant,((Tortue) devant).positiondepart[0],((Tortue) devant).positiondepart[1]);
                                Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                            }
                            break;
                        }
                    }
                }
                break;
            }
            case 3:{
                if (Plateau.getPosition(t)[0] == 7){
                    Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                }
                else{
                    Tuile devant = Plateau.getTuile(Plateau.getPosition(t)[0]+1,Plateau.getPosition(t)[1]);
                    System.out.println(devant.nom);
                    switch (devant.nom){
                        case "joyaux":{
                            //gagne
                            break;
                        }

                        case "pierre":
                        case "glace":{
                            t.retourner();
                            break;
                        }

                        case "caisse":{
                            break;
                        }

                        case "vide":{
                            Plateau.deplacerTuile(t,Plateau.getPosition(t)[0]+1,Plateau.getPosition(t)[1]);
                            break;
                        }
                        default:{
                            if(devant instanceof Tortue){
                                Plateau.deplacerTuile(devant,((Tortue) devant).positiondepart[0],((Tortue) devant).positiondepart[1]);
                                Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                            }
                            break;
                        }
                    }
                }
                break;
            }
            case 4:{
                if (Plateau.getPosition(t)[1] == 0){
                    Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                }
                else{
                    Tuile devant = Plateau.getTuile(Plateau.getPosition(t)[0],Plateau.getPosition(t)[1]-1);
                    System.out.println(devant.nom);
                    switch (devant.nom){
                        case "joyaux":{
                            //gagne
                            break;
                        }

                        case "pierre":
                        case "glace":{
                            t.retourner();
                            break;
                        }

                        case "caisse":{
                            break;
                        }

                        case "vide":{
                            Plateau.deplacerTuile(t,Plateau.getPosition(t)[0],Plateau.getPosition(t)[1]-1);
                            break;
                        }
                        default:{
                            if(devant instanceof Tortue){
                                Plateau.deplacerTuile(devant,((Tortue) devant).positiondepart[0],((Tortue) devant).positiondepart[1]);
                                Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                            }
                            break;
                        }
                    }
                }
                break;
            }
        }
    }

    private static void droite (Tortue t) { /* fonction qui prend en argument l'orientation et qui tourne la tortue vers la droite */
        switch (t.orientation){
            case 1:{
                t.orientation = 2;
                break;
            }
            case 2:{
                t.orientation = 3;
                break;
            }
            case 3:{
                t.orientation = 4;
                break;
            }
            case 4:{
                t.orientation = 1;
                break;
            }
        }
    }

    private static void gauche (Tortue t) { /* fonction qui prend en argument l'orientation et qui tourne la tortue vers la droite */
        switch (t.orientation){
            case 1:{
                t.orientation = 4;
                break;
            }
            case 2:{
                t.orientation = 1;
                break;
            }
            case 3:{
                t.orientation = 2;
                break;
            }
            case 4:{
                t.orientation = 3;
                break;
            }
        }
    }

    private static void laser (Tortue t){
        switch (t.orientation){
            case 1:{
                int i = 1;
                do{
                    Tuile devant = Plateau.getTuile(Plateau.getPosition(t)[0]-i,Plateau.getPosition(t)[1]);
                    System.out.println(devant.nom);
                    switch (devant.nom){
                        case "joyaux":{
                            switch (Jeu.listeJoueurs.length){
                                case 2:{
                                    t.retourner();
                                    i=0;
                                    break;
                                }
                                case 3:
                                case 4:{
                                    Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                                    i=0;
                                    break;
                                }
                            }
                            break;
                        }

                        case "pierre":{
                            i=0;
                            break;
                        }

                        case "glace":{
                            Plateau.plateau[Plateau.getPosition(t)[0]-i][Plateau.getPosition(t)[1]] = new Tuile();
                            i=0;
                            break;
                        }

                        case "caisse":{
                            break;
                        }

                        case "vide":{
                            i++;
                        }

                        default:{
                            if(devant instanceof Tortue){
                                switch (Jeu.listeJoueurs.length){
                                    case 2:{
                                        t.retourner();
                                        i=0;
                                        break;
                                    }
                                    case 3:
                                    case 4:{
                                        Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                                        i=0;
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }while (i!=0);
                break;
            }
            case 2:{
                int i = 1;
                do{
                    Tuile devant = Plateau.getTuile(Plateau.getPosition(t)[0],Plateau.getPosition(t)[1]+i);
                    System.out.println(devant.nom);
                    switch (devant.nom){
                        case "joyaux":{
                            switch (Jeu.listeJoueurs.length){
                                case 2:{
                                    t.retourner();
                                    i=0;
                                    break;
                                }
                                case 3:
                                case 4:{
                                    Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                                    i=0;
                                    break;
                                }
                            }
                            break;
                        }

                        case "pierre":{
                            i=0;
                            break;
                        }

                        case "glace":{
                            Plateau.plateau[Plateau.getPosition(t)[0]][Plateau.getPosition(t)[1]+i] = new Tuile();
                            i=0;
                            break;
                        }

                        case "caisse":{
                            break;
                        }

                        case "vide":{
                            i++;
                        }

                        default:{
                            if(devant instanceof Tortue){
                                switch (Jeu.listeJoueurs.length){
                                    case 2:{
                                        t.retourner();
                                        i=0;
                                        break;
                                    }
                                    case 3:
                                    case 4:{
                                        Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                                        i=0;
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }while (i!=0);
                break;
            }
            case 3:{
                int i = 1;
                do{
                    Tuile devant = Plateau.getTuile(Plateau.getPosition(t)[0]+i,Plateau.getPosition(t)[1]);
                    System.out.println(devant.nom);
                    switch (devant.nom){
                        case "joyaux":{
                            switch (Jeu.listeJoueurs.length){
                                case 2:{
                                    t.retourner();
                                    i=0;
                                    break;
                                }
                                case 3:
                                case 4:{
                                    Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                                    i=0;
                                    break;
                                }
                            }
                            break;
                        }

                        case "pierre":{
                            i=0;
                            break;
                        }

                        case "glace":{
                            Plateau.plateau[Plateau.getPosition(t)[0]+i][Plateau.getPosition(t)[1]] = new Tuile();
                            i=0;
                            break;
                        }

                        case "caisse":{
                            break;
                        }

                        case "vide":{
                            i++;
                        }

                        default:{
                            if(devant instanceof Tortue){
                                switch (Jeu.listeJoueurs.length){
                                    case 2:{
                                        t.retourner();
                                        i=0;
                                        break;
                                    }
                                    case 3:
                                    case 4:{
                                        Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                                        i=0;
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }while (i!=0);
                break;
            }
            case 4:{
                int i = 1;
                do{
                    Tuile devant = Plateau.getTuile(Plateau.getPosition(t)[0],Plateau.getPosition(t)[1]-i);
                    System.out.println(devant.nom);
                    switch (devant.nom){
                        case "joyaux":{
                            switch (Jeu.listeJoueurs.length){
                                case 2:{
                                    t.retourner();
                                    i=0;
                                    break;
                                }
                                case 3:
                                case 4:{
                                    Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                                    i=0;
                                    break;
                                }
                            }
                            break;
                        }

                        case "pierre":{
                            i=0;
                            break;
                        }

                        case "glace":{
                            Plateau.plateau[Plateau.getPosition(t)[0]][Plateau.getPosition(t)[1]-i] = new Tuile();
                            i=0;
                            break;
                        }

                        case "caisse":{
                            break;
                        }

                        case "vide":{
                            i++;
                        }

                        default:{
                            if(devant instanceof Tortue){
                                switch (Jeu.listeJoueurs.length){
                                    case 2:{
                                        t.retourner();
                                        i=0;
                                        break;
                                    }
                                    case 3:
                                    case 4:{
                                        Plateau.deplacerTuile(t,t.positiondepart[0],t.positiondepart[1]);
                                        i=0;
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }while (i!=0);
                break;
            }
        }
    }
}
