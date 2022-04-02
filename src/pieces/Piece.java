package pieces;

import javafx.scene.image.Image;

import java.util.ArrayList;


public abstract class Piece {

    protected final boolean estBlanc;
    protected final Image skin;
    protected int X;
    protected int Y;
    protected final String name;


    public Piece(boolean estBlanc, Image skin, String name, int X, int Y) {
        this.estBlanc = estBlanc;
        this.skin = skin;
        this.name = name;
        this.X = X;
        this.Y= Y;


    }

    public boolean isAt(int X,int Y){
        return (this.X==X && this.Y==Y);
    }
    public Image getSkin() {
        return skin;
    }

    public int getX() {
        return X;
    }

    public String getName() {
        return name;
    }

    public int getY() {
        return Y;
    }

    public void setXp(int X) {
        this.X = X;
    }

    public void setYp(int Y) {
        this.Y = Y;
    }
    abstract void move();
    abstract void possibleMove();

    public abstract ArrayList<Position> possibleMove(int X, int Y);


    }


