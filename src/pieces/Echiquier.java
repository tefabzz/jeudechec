package pieces;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

public class Echiquier {

    private Boolean Jeu;
    private ArrayList<Piece> blancs = new ArrayList<>();
    private ArrayList<Piece> noires = new ArrayList<>();

    public Echiquier() {
        init();
    }




    public ArrayList<Piece> getBlancs() {
        return blancs;
    }


    /**
     * Renvoie la piece à la position x et y
     *
     * @param x numéro de case
     * @param y numéro de case
     * @return la piece à cette position, null si il n'y en a pas
     */
    public Piece pieceAtPos(int x, int y) {
        Piece piece = null;
        for (Piece p : blancs) {
            if (p.isAt(x, y)) {
                piece = p;
                break;
            }
        }
        for (Piece p : noires) {
            if (p.isAt(x, y)) {
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
    private void init() {
        blancs.add(new Pion(true, new Image("interfaceGr/PB.gif"), "pion1", 0 * 64, 1 * 64));
        blancs.add(new Pion(true, new Image("interfaceGr/PB.gif"), "pion2", 1 * 64, 1 * 64));
        blancs.add(new Pion(true, new Image("interfaceGr/PB.gif"), "pion3", 2 * 64, 1 * 64));
        blancs.add(new Pion(true, new Image("interfaceGr/PB.gif"), "pion4", 3 * 64, 1 * 64));
        blancs.add(new Pion(true, new Image("interfaceGr/PB.gif"), "pion5", 4 * 64, 1 * 64));
        blancs.add(new Pion(true, new Image("interfaceGr/PB.gif"), "pion6", 5 * 64, 1 * 64));
        blancs.add(new Pion(true, new Image("interfaceGr/PB.gif"), "pion7", 6 * 64, 1 * 64));
        blancs.add(new Pion(true, new Image("interfaceGr/PB.gif"), "pion8", 7 * 64, 1 * 64));
        blancs.add(new Tour(true, new Image("interfaceGr/TB.gif"), "Tour1", 0 * 64, 0 * 64));
        blancs.add(new Tour(true, new Image("interfaceGr/TB.gif"), "Tour2", 7 * 64, 0 * 64));
        blancs.add(new Fou(true, new Image("interfaceGr/FB.gif"), "Fou1", 2 * 64, 0 * 64));
        blancs.add(new Fou(true, new Image("interfaceGr/FB.gif"), "Fou2", 5 * 64, 0 * 64));
        blancs.add(new Cavalier(true, new Image("interfaceGr/CB.gif"), "Cavalier1", 1 * 64, 0 * 64));
        blancs.add(new Cavalier(true, new Image("interfaceGr/CB.gif"), "Cavalier2", 6 * 64, 0 * 64));
        blancs.add(new Roi(true, new Image("interfaceGr/RB.gif"), "Roi", 4 * 64, 0 * 64));
        blancs.add(new Reine(true, new Image("interfaceGr/DB.gif"), "Reine", 3 * 64, 0 * 64));
        //------------------------------------------------------------------------------------------------
        noires.add(new Pion(false, new Image("interfaceGr/PN.gif"), "pion1", 0 * 64, 6 * 64));
        noires.add(new Pion(false, new Image("interfaceGr/PN.gif"), "pion2", 1 * 64, 6 * 64));
        noires.add(new Pion(false, new Image("interfaceGr/PN.gif"), "pion3", 2 * 64, 6 * 64));
        noires.add(new Pion(false, new Image("interfaceGr/PN.gif"), "pion4", 3 * 64, 6 * 64));
        noires.add(new Pion(false, new Image("interfaceGr/PN.gif"), "pion5", 4 * 64, 6 * 64));
        noires.add(new Pion(false, new Image("interfaceGr/PN.gif"), "pion6", 5 * 64, 6 * 64));
        noires.add(new Pion(false, new Image("interfaceGr/PN.gif"), "pion7", 6 * 64, 6 * 64));
        noires.add(new Pion(false, new Image("interfaceGr/PN.gif"), "pion8", 7 * 64, 6 * 64));
        noires.add(new Tour(false, new Image("interfaceGr/TN.gif"), "Tour1", 7 * 64, 7 * 64));
        noires.add(new Tour(false, new Image("interfaceGr/TN.gif"), "Tour2", 0 * 64, 7 * 64));
        noires.add(new Fou(false, new Image("interfaceGr/FN.gif"), "Fou1", 2 * 64, 7 * 64));
        noires.add(new Fou(false, new Image("interfaceGr/FN.gif"), "Fou2", 5 * 64, 7 * 64));
        noires.add(new Cavalier(false, new Image("interfaceGr/CN.gif"), "Cavalier1", 1 * 64, 7 * 64));
        noires.add(new Cavalier(false, new Image("interfaceGr/CN.gif"), "Cavalier2", 6 * 64, 7 * 64));
        noires.add(new Roi(false, new Image("interfaceGr/RN.gif"), "Roi", 4 * 64, 7 * 64));
        noires.add(new Reine(false, new Image("interfaceGr/DN.gif"), "Reine", 3 * 64, 7 * 64));
    }



    public Boolean getJeu() {
        return this.Jeu;
    }
}





