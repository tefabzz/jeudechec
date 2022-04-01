package pieces;

import javafx.scene.image.Image;

import java.util.ArrayList;


public abstract class Piece {

    protected final boolean estBlanc;
    protected final Image skin;
    protected int xp;
    protected int yp;
    protected final String name;


    public Piece(boolean estBlanc, Image skin, String name, int xp, int yp) {
        this.estBlanc = estBlanc;
        this.skin = skin;
        this.name = name;
        this.xp = xp;
        this.yp= yp;


    }

    public boolean isAt(int x,int y){
        return (this.xp==x && this.yp==y);
    }
    public Image getSkin() {
        return skin;
    }

    public int getXp() {
        return xp;
    }

    public String getName() {
        return name;
    }

    public int getYp() {
        return yp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setYp(int yp) {
        this.yp = yp;
    }
    abstract void move();
    abstract void possibleMove();



}