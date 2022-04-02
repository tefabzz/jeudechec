package pieces;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Pion extends Piece {


    public Pion(boolean estBlanc, Image skin, String name, int X, int Y) {
        super(estBlanc, skin, name, X, Y);
    }


    @Override
    void move() {

    }

    @Override
    void possibleMove() {

    }

    @Override
    public ArrayList<Position> possibleMove(int X, int Y){
        ArrayList<Position> possible = new ArrayList<>();
        if (this.estBlanc) {

          if (Y<7) possible.add(new Position(X,Y+1));
          if (Y==1) possible.add(new Position(X, Y+2));
        }
        else {
            if (Y>0) possible.add(new Position(X, Y - 1));
            if (Y==6) possible.add(new Position(X, Y - 2));
        }
        return possible;




    }
}