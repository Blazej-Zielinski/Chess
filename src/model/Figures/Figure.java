package model.Figures;

import model.Board.Board;
import view.Backgrounds.Image;

import java.util.ArrayList;

public abstract class Figure extends Image {
    public static final int IS_NOT_ENABLED = 0;
    public static final int IS_ENABLED = 1;
    public static final int IS_SELECTED = 2;
    public static final int TO_KILL = 3;


    private final boolean isWhite;
    protected int position;
    protected int status = IS_ENABLED;

    public Figure(String filename, boolean isWhite, int position) {
        super(filename);
        this.isWhite = isWhite;
        this.position = position;

        if(!isWhite){
            status=IS_NOT_ENABLED;
        }
    }

    abstract public ArrayList<Integer> move(Board board);
    protected boolean isFiguresDifferentColor(Figure figure) {
        return (figure.isWhite() != this.isWhite());
    }
    protected void setFigureToKill(Figure figure) {
        figure.status = TO_KILL;
    }



    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public boolean isWhite() {
        return isWhite;
    }

}

