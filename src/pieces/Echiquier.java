package pieces;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

public class Echiquier {

    private Boolean Jeu;
    private ArrayList<Piece> blancs= new ArrayList<>();
    private ArrayList<Piece> noires=new ArrayList<>();

    public Echiquier(){
        init();
    }

    public ArrayList<Piece> getBlancs() {
        return blancs;
    }

    /**
     * Renvoie la piece à la position x et y
     * @param x numéro de case
     * @param y numéro de case
     * @return la piece à cette position, null si il n'y en a pas
     */
    public Piece pieceAtPos(int x, int y){
        Piece piece= null;
        for (Piece p:blancs) {
            if(p.isAt(x,y)){
                piece = p;
                break;
            }
        }
        for (Piece p:noires) {
            if(p.isAt(x,y)){
                piece = p;
                break;
            }

        }
        return piece;
    }

    public ArrayList<Piece> getNoires() {
        return noires;
    }

    private static int xp, yp, Xp, Yp;
    private static Boolean Tourdujoueur;
    // Définit sur true si movement est invalide. Demande de nouveau l'utilisateur dans move ()
    // méthode.
    private static Boolean MouvementIncorrect = false;
    // Contient une chaîne avec l'entrée de l'utilisateur pour les instructions de déplacement
    String mouvement;

    /**
     * Cette méthode initialise le jeu
     */
    private void init(){
        blancs.add(new Pion(true,new Image("interfaceGr/PB.gif"),"pion1",0*64,1*64));
        blancs.add(new Pion(true,new Image("interfaceGr/PB.gif"),"pion2",1*64,1*64));
        blancs.add(new Pion(true,new Image("interfaceGr/PB.gif"),"pion3",2*64,1*64));
        blancs.add(new Pion(true,new Image("interfaceGr/PB.gif"),"pion4",3*64,1*64));
        blancs.add(new Pion(true,new Image("interfaceGr/PB.gif"),"pion5",4*64,1*64));
        blancs.add(new Pion(true,new Image("interfaceGr/PB.gif"),"pion6",5*64,1*64));
        blancs.add(new Pion(true,new Image("interfaceGr/PB.gif"),"pion7",6*64,1*64));
        blancs.add(new Pion(true,new Image("interfaceGr/PB.gif"),"pion8",7*64,1*64));
        blancs.add(new Tour(true,new Image("interfaceGr/TB.gif"),"Tour1",0*64,0*64));
        blancs.add(new Tour(true,new Image("interfaceGr/TB.gif"),"Tour2",7*64,0*64));
        blancs.add(new Fou(true,new Image("interfaceGr/FB.gif"),"Fou1",2*64,0*64));
        blancs.add(new Fou(true,new Image("interfaceGr/FB.gif"),"Fou2",5*64,0*64));
        blancs.add(new Cavalier(true,new Image("interfaceGr/CB.gif"),"Cavalier1",1*64,0*64));
        blancs.add(new Cavalier(true,new Image("interfaceGr/CB.gif"),"Cavalier2",6*64,0*64));
        blancs.add(new Roi(true,new Image("interfaceGr/RB.gif"),"Roi",4*64,0*64));
        blancs.add(new Reine(true,new Image("interfaceGr/DB.gif"),"Reine",3*64,0*64));
        //------------------------------------------------------------------------------------------------
        noires.add(new Pion(false,new Image("interfaceGr/PN.gif"),"pion1",0*64,6*64));
        noires.add(new Pion(false,new Image("interfaceGr/PN.gif"),"pion2",1*64,6*64));
        noires.add(new Pion(false,new Image("interfaceGr/PN.gif"),"pion3",2*64,6*64));
        noires.add(new Pion(false,new Image("interfaceGr/PN.gif"),"pion4",3*64,6*64));
        noires.add(new Pion(false,new Image("interfaceGr/PN.gif"),"pion5",4*64,6*64));
        noires.add(new Pion(false,new Image("interfaceGr/PN.gif"),"pion6",5*64,6*64));
        noires.add(new Pion(false,new Image("interfaceGr/PN.gif"),"pion7",6*64,6*64));
        noires.add(new Pion(false,new Image("interfaceGr/PN.gif"),"pion8",7*64,6*64));
        noires.add(new Tour(false,new Image("interfaceGr/TN.gif"),"Tour1",7*64,7*64));
        noires.add(new Tour(false,new Image("interfaceGr/TN.gif"),"Tour2",0*64,7*64));
        noires.add(new Fou(false,new Image("interfaceGr/FN.gif"),"Fou1",2*64,7*64));
        noires.add(new Fou(false,new Image("interfaceGr/FN.gif"),"Fou2",5*64,7*64));
        noires.add(new Cavalier(false,new Image("interfaceGr/CN.gif"),"Cavalier1",1*64,7*64));
        noires.add(new Cavalier(false,new Image("interfaceGr/CN.gif"),"Cavalier2",6*64,7*64));
        noires.add(new Roi(false,new Image("interfaceGr/RN.gif"),"Roi",4*64,7*64));
        noires.add(new Reine(false,new Image("interfaceGr/DN.gif"),"Reine",3*64,7*64));


    }

    public Boolean getJeu() {
        return this.Jeu;
    }


    private static void initialisation_de_la_grille(Piece[][] echiquier) {
        // un échiquier avec une matrice 8x8 de pièces
        // les lignes [0] et [1] sont noires
        // les lignes [6] et [7] sont blanches
//
//        for (int ligne = 0; ligne < echiquier.length; ligne++) {
//            for (int colonne = 0; colonne < echiquier[ligne].length; colonne++) {
//                if (ligne == 0) {
//                    switch (colonne) {
//                        case 0:
//                            echiquier[ligne][colonne] = new Tour(false);
//                            break;
//                        case 1:
//                            echiquier[ligne][colonne] = new Cavalier(false);
//                            break;
//                        case 2:
//                            echiquier[ligne][colonne] = new Fou(false);
//                            break;
//                        case 3:
//                            echiquier[ligne][colonne] = new Reine(false);
//                            break;
//                        case 4:
//                            echiquier[ligne][colonne] = new Roi(false);
//                            break;
//                        case 5:
//                            echiquier[ligne][colonne] = new Fou(false);
//                            break;
//                        case 6:
//                            echiquier[ligne][colonne] = new Cavalier(false);
//                            break;
//                        case 7:
//                            echiquier[ligne][colonne] = new Tour(false);
//                            break;
//                    }
//                } else if (ligne == 1) {
//                    echiquier[ligne][colonne] = new Pion(false);
//                } else if (ligne == 6) {
//                    echiquier[ligne][colonne] = new Pion(true);
//                } else if (ligne == 7) {
//                    switch (colonne) {
//                        case 0:
//                            echiquier[ligne][colonne] = new Tour(true);
//                            break;
//                        case 1:
//                            echiquier[ligne][colonne] = new Cavalier(true);
//                            break;
//                        case 2:
//                            echiquier[ligne][colonne] = new Fou(true);
//                            break;
//                        case 3:
//                            echiquier[ligne][colonne] = new Reine(true);
//                            break;
//                        case 4:
//                            echiquier[ligne][colonne] = new Roi(true);
//                            break;
//                        case 5:
//                            echiquier[ligne][colonne] = new Fou(true);
//                            break;
//                        case 6:
//                            echiquier[ligne][colonne] = new Cavalier(true);
//                            break;
//                        case 7:
//                            echiquier[ligne][colonne] = new Tour(true);
//                            break;
//                    }
//                } else {
//                    echiquier[ligne][colonne] = null;
//                }
//            }
//        }

//        // Affecte aléatoirement qui commence en premier (noir ou blanc)
//        Random rand = new Random();
//        Tourdujoueur = rand.nextBoolean();
//
//    }
//
//    /**
//     * Détermine si il y a echec
//     * @param Echec
//     * @return
//     */
//    private boolean mouvementValide(boolean Echec) {
//
//        // On verifie que le chemin ne sort pas de l'échequier
//        if (xp < 0 || xp> 7 || yp < 0 || yp > 7 || Xp < 0 || Xp > 7 || Yp < 0 || Yp > 7) {
//            System.out.println("Le mouvement est en dehors de l'echiquier");
//            return false;
//        }
//
//        // On vérifie que l'origine n'est pas null
//        if (Echiquier[xp][yp]== null) {
//            System.err.println("L'origine est vide");
//            return false;
//        }
//
//        // On verifie que c'est bien le tour du joueur pour qu'il joue
//        if ((Echiquier[xp][yp].estBlanc && !Tourdujoueur) || (!Echiquier[xp][yp].estBlanc && Tourdujoueur)) {
//            if(Echec == false)
//                System.err.println("Ce n'est pas votre tour");
//            return false;
//        }
//
//        // On verifie que les déplacement spécifique de la pièces sont bien respectés
//        if (!echiquier[xp][yp].deplacement(xp,yp,Xp,Yp)) {
//            if(Echec == false)
//                System.err.println("Cette pièce ne bouge pas comme ça");
//            return false;
//        }
//
//        // cette déclaration arrête la déclaration pour vérifier si le blanc atterit
//        // blanc de l'exécution estBlanc() sur un espace null
//        if (echiquier[Xp][Yp] == null) {
//            //Chemin pas possible si une piece veut fauter une auter piece SAUF POUR LE CAVALIER
//            if(!(echiquier[xp][yp] instanceof Cavalier)){
//                int deplaceX = 0, deplaceY = 0;
//                if(xp < Xp) deplaceX = 1; else if(xp > Xp)deplaceX = -1;
//                if(yp < Yp) deplaceY = 1; else if(yp > Yp) deplaceY = -1;
//
//                int i = xp, j = yp;
//                while(i != Xp || j != Yp){
//                    if(i != Xp) i+= deplaceX;
//                    if(j != Yp) j+= deplaceY;
//
//                    if(echiquier[i][j] != null){
//                        System.err.println("Cette pieces ne peut pas sauter un pion");
//                        return false;
//                    }
//                }
//            }
//            return true;
//        }
//
//        if(echiquier[xp][yp] instanceof Pion && (Xp == Yp) && this.echiquier[Xp][Yp] == null ){
//            System.out.println("Ne peut pas ce deplacer en diagonale");
//            return false;
//        }
//
//        // On verifie que un pion Blanc ne veut pas se poser sur un autre pion Blanc
//        if (echiquier[xp][yp].estBlanc && echiquier[Xp][Yp].estBlanc) {
//            System.err.println("Les blancs ne peuvent pas atterrir sur le blanc");
//            return false;
//        }
//
//        // On verifie que un pion Noir ne veut pas se poser sur un autre pion Noir
//        if (!echiquier[xp][yp].estBlanc && !echiquier[Xp][Yp].estBlanc) {
//            System.err.println("Le noir ne peut pas atterrir sur le noir");
//            return false;
//        }
//
//        return true;
//    }
//
//    public boolean ECHEC() {
//        //Piece ROI;
//        ArrayList<Position> P = new ArrayList<Position>();
//        boolean joueur_adverse = Tourdujoueur;
//        boolean joueur_courant = !Tourdujoueur;
//        //On recherche la position du ROI
//        for (int ligne = 0; ligne < 8; ligne++) {
//            for (int colonne = 0; colonne < 8; colonne++) {
//                if (this.echiquier[ligne][colonne] != null && this.echiquier[ligne][colonne].estBlanc == Tourdujoueur && this.echiquier[ligne][colonne] instanceof Roi) {
//                    //ROI = this.echiquier[ligne][colonne];
//                    Xp = ligne;
//                    Yp = colonne;
//
//                }
//            }
//        }
//
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
//        for(int ligne=0; ligne<8; ligne++){
//            for(int colonne=0; colonne<8; colonne++){
//                if(this.echiquier[ligne][colonne] != null && this.echiquier[ligne][colonne].estBlanc == !Tourdujoueur)
//                {
//                    departLigne = ligne;
//                    departColonne = colonne;
//
//                    if(mouvementValide(true))
//                        P.add(new Position(departLigne,departColonne,arriveeligne,arriveColonne));
//                    System.out.println(departLigne+""+departColonne);
//                }
//            }
//        }
//        if(P.isEmpty())
//            return false;
//        else
//            return true;
//    }
//
//
//    public void deplacer() {
//        if (MouvementIncorrect) {
//            System.err.println("Le mouvement n'est pas valide. Veuillez réessayer:");
//            MouvementIncorrect = false;
//        }
//
//        else if (Tourdujoueur) {
//            System.out.println( "\nLe joueur BLANC doit jouer\n");
//        } else {
//            System.out.println("\nLe joueur NOIR doit jouer\n");
//        }
//
//        mouvement = user_input.nextLine();
//
//
//        // convertir en minuscules
//        String lowerCase = mouvement.toLowerCase();
//        // analyse la chaîne de déplacement en composants
//        String[] components = lowerCase.split(" ");
//
//        // si vous supposez que le déplacement est "e1 à e5" alors
//        // composants [0] .chartAt (0) = 'e'
//        // composants [0] .charAt (1) = '1'
//
//        // utilisez des chars dans les composants pour définir les coordonnées du tableau
//        // déplace l'origine et déplace la destination
//
//        departLigne = 7 - (components[0].charAt(1) - '1');
//        departColonne = components[0].charAt(0) - 'a';
//        arriveeligne = 7 - (components[2].charAt(1) - '1');
//        arriveColonne = components[2].charAt(0) - 'a';
//
//        if (mouvementValide(false)) {
//            // mettre une pièce dans la destination
//            echiquier[arriveeligne][arriveColonne] = echiquier[departLigne][departColonne];
//            // vide l'origine du mouvement
//            echiquier[departLigne][departColonne] = null;
//            if(ECHEC() == true)
//            {System.out.println("\n ECHEC !\n");}
//            Tourdujoueur = !Tourdujoueur;
//
//
//        }
//        else {
//            MouvementIncorrect = true;
//            mouvementValide(false);
//            if(ECHEC() == true)
//            {System.out.println("\n ECHEC !\n");}
//
//
        }


    }
