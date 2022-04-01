package pieces;

import javafx.scene.image.Image;

public class Cavalier extends Piece {


    public Cavalier(boolean estBlanc, Image skin, String name, int xp, int yp) {
        super(estBlanc, skin, name, xp, yp);
    }

    @Override
    void move() {

    }

    @Override
    void possibleMove() {

    }
}

//    @Override
//    void move() {
//        this.yp = this.yp +1;
//        this.yp= this.yp + 2;


//
//    @Override
//    public boolean possibleMove(int xp, int yp, int X, int Y) {
//        return  chemin(xp, yp, X, Y);
//    }
//
//    @Override
//    public Boolean chemin(int xp, int yp, int X, int Y) {
//        return ((Math.abs(xp - X) == 2 && Math.abs(yp- Y) == 1)
//                || (Math.abs(xp - X) == 1 && Math.abs(yp- Y) == 2));
//    }
//}






















