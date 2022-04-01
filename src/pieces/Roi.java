


package pieces;


import javafx.scene.image.Image;

import java.util.ArrayList;

public class Roi extends Piece {


    public Roi(boolean estBlanc, Image skin, String name, int xp, int yp) {
        super(estBlanc, skin, name, xp, yp);
    }

    @Override
    void move() {

    }

    @Override
    void possibleMove() {

    }
}



//    public boolean possibleMove(int xp, int yp, int X, int Y) {
//
//        return Math.abs(X - xp) <= 1 || Math.abs(Y - yp) <= 1;
//
//
//    }
//
//    @Override
//    public Boolean chemin(int xp, int yp, int X, int Y) {
//        return null;
//    }
//}







//    @Override
//    void move() {
//
//    }



//
//    public boolean deplacement(int departLigne, int departColonne, int arriveeligne,int arriveColonne) {
//        return Math.abs(arriveeligne - departLigne) <= 1|| Math.abs(arriveColonne - departColonne) <= 1;
//    }
//}