package pieces;

import javafx.scene.image.Image;

import java.util.ArrayList;

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

    @Override
    public ArrayList<Position> possibleMove(int xp, int yp) {
        return null;
    }
}























