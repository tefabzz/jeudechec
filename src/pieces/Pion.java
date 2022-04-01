package pieces;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Pion extends Piece {


    public Pion(boolean estBlanc, Image skin, String name, int xp, int yp) {
        super(estBlanc, skin, name, xp, yp);
    }


    @Override
    void move() {

    }

    @Override
    void possibleMove() {
    }


    public ArrayList<Position> possibleMove(int xp, int yp){
        ArrayList<Position> possible = new ArrayList<>();
        if (this.estBlanc) {
            possible.add(new Position(this.xp, this.yp + 1));
        } else {
            possible.add(new Position(this.xp, this.yp - 1));
        }
        return possible;

    }
}















//    public boolean possibleMove(int xp, int yp, int X, int Y) {
//        if (this.estBlanc) {
//            return (((yp == Y) && xp == (X + 1))
//                    || ((xp == 6) && (yp == Y) && (xp == (X + 2)))
//                    || ((xp == (X + 1))
//                    && (Math.abs(yp - Y) == 1)));
//
//        } else {
//            return (((yp == Y) && xp == (X - 1))
//                    || ((xp == 1) && (yp == Y) && (xp == (X - 2)))
//                    || ((xp == (X - 1))
//                    && (Math.abs(yp - Y) == 1)));
//        }
//
//    }
