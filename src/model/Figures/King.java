package model.Figures;

import model.Board.Board;

import java.util.ArrayList;

public class King extends Figure {

    public King(String filename, boolean isWhite, int position) {
        super(filename, isWhite, position);
    }

    @Override
    public ArrayList<Integer> move(Board board) {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        //-----------------------Podstawowe ruchy
        int moveUpDown = 8, moveSide = 1, moveDiagonal1 = 9, moveDiagonal2 = 7;
        boolean cond1 = false, cond2 = false, cond3 = false, cond4 = false;

        if (position < 8) {
            cond1 = true;
        } //dolny rząd
        if (position > 55) {
            cond2 = true;
        } //górny rząd
        if (position % 8 == 0) {
            cond3 = true;
        } //lewa kolumna
        if ((position + 1) % 8 == 0) {
            cond4 = true;
        } //prawa kolumna

        if (!cond1 && !cond2 && !cond3 && !cond4) {
            possibleMoves.add(position + moveUpDown);
            possibleMoves.add(position - moveUpDown);
            possibleMoves.add(position + moveSide);
            possibleMoves.add(position - moveSide);
            possibleMoves.add(position + moveDiagonal1);
            possibleMoves.add(position + moveDiagonal2);
            possibleMoves.add(position - moveDiagonal1);
            possibleMoves.add(position - moveDiagonal2);
        }

        if (cond1 && !cond3 && !cond4) {
            possibleMoves.add(position + moveUpDown);
            possibleMoves.add(position + moveSide);
            possibleMoves.add(position - moveSide);
            possibleMoves.add(position + moveDiagonal1);
            possibleMoves.add(position + moveDiagonal2);
        }

        if (cond2 && !cond3 && !cond4) {
            possibleMoves.add(position - moveUpDown);
            possibleMoves.add(position + moveSide);
            possibleMoves.add(position - moveSide);
            possibleMoves.add(position - moveDiagonal1);
            possibleMoves.add(position - moveDiagonal2);
        }

        if (cond3 && !cond1 && !cond2) {
            possibleMoves.add(position - moveUpDown);
            possibleMoves.add(position + moveUpDown);
            possibleMoves.add(position + moveSide);
            possibleMoves.add(position + moveDiagonal1);
            possibleMoves.add(position - moveDiagonal2);
        }

        if (cond4 && !cond1 && !cond2) {
            possibleMoves.add(position - moveUpDown);
            possibleMoves.add(position + moveUpDown);
            possibleMoves.add(position - moveSide);
            possibleMoves.add(position - moveDiagonal1);
            possibleMoves.add(position + moveDiagonal2);
        }

        if (cond1 && cond3) {
            possibleMoves.add(position + moveUpDown);
            possibleMoves.add(position + moveSide);
            possibleMoves.add(position + moveDiagonal1);
        }

        if (cond1 && cond4) {
            possibleMoves.add(position + moveUpDown);
            possibleMoves.add(position - moveSide);
            possibleMoves.add(position + moveDiagonal2);
        }

        if (cond2 && cond3) {
            possibleMoves.add(position - moveUpDown);
            possibleMoves.add(position + moveSide);
            possibleMoves.add(position - moveDiagonal2);
        }

        if (cond2 && cond4) {
            possibleMoves.add(position - moveUpDown);
            possibleMoves.add(position - moveSide);
            possibleMoves.add(position - moveDiagonal1);
        }


        //---------------------Bicie figur i gdy figury zasłaniają ruch
        ArrayList<Integer> membersToDelete = new ArrayList<>();
        for (Integer x : board.figuresPosition) {
            for (Integer i : possibleMoves) {
                if (x.equals(i)) {

                    if (isFiguresDifferentColor(board.getParticularFigure(i))) {
                        setFigureToKill(board.getParticularFigure(i));
                    } else {
                        membersToDelete.add(i);
                    }

                }
            }
        }

        for (Integer x : membersToDelete) {
            possibleMoves.remove(x);
        }


        return possibleMoves;
    }

}
