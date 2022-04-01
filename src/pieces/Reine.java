

package pieces;

import javafx.scene.image.Image;

public class Reine extends Piece {


    public Reine(boolean estBlanc, Image skin, String name, int xp, int yp) {
        super(estBlanc, skin, name, xp, yp);
    }

    @Override
    void move() {

    }

    @Override
    void possibleMove() {

    }

//    @Override
//    public boolean possibleMove(int xp, int yp, int X, int Y) {
//        return (cheminDiagonal(xp, yp, X, Y)) || chemin(xp, yp, X, Y);
//    }
//
//    @Override
//    public Boolean chemin(int xp, int yp, int X, int Y) {
//        return null;
//    }
//    public Boolean cheminDiagonal(int xp, int yp, int X, int Y) {
//        return ((Math.abs(xp - X) == Math.abs(yp - Y)));
//    }




//    @Override
//    void move() {
//
//    }
}










//    private static Boolean cheminDiagonal(int departLigne, int departColonne, int arriveeligne,int arriveColonne) {
//        return ((Math.abs(departLigne - arriveeligne) == Math.abs(departColonne - arriveColonne)));
//    }
//
//    private static Boolean chemin(int departLigne, int departColonne, int arriveeligne,int arriveColonne) {
//        return !((departLigne != arriveeligne) && (departColonne != arriveColonne));
//    }
//
//
//    public boolean deplacement(int departLigne, int departColonne, int arriveeligne,int arriveColonne) {
//        return (cheminDiagonal(departLigne, departColonne, arriveeligne, arriveColonne))
//                || chemin(departLigne, departColonne, arriveeligne, arriveColonne);
//    }
//}