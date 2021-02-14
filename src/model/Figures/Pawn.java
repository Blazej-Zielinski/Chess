package model.Figures;

import model.Board.Board;

import java.util.ArrayList;

public class Pawn extends Figure {

    public Pawn(String filename, boolean isWhite, int position) {
        super(filename, isWhite, position);
    }


    @Override
    public ArrayList<Integer> move(Board board) {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        if (!(position < 8 || position > 55)) {                      //warunek który sprawdza czy pinek nie jest w górnym rzędzie lub dolnym rzędzie
            //-----------------------Podstawowe ruchy
            Integer[] basicMoves = new Integer[2];
            if (!isWhite()) {
                basicMoves[0] = position + 8;
                if (position < 16) {
                    basicMoves[1] = position + 16;
                }
            } else {
                basicMoves[0] = position - 8;
                if (position > 47) {
                    basicMoves[1] = position - 16;
                }
            }

            //--------------------------Sprawdzanie czy jakaś figura nie zastawia drogi
            boolean cond1 = true, cond2 = true;
            for (Integer x : board.figuresPosition) {
                if (x.equals(basicMoves[0])) {
                    cond1 = false;
                }
                if (x.equals(basicMoves[1])) {
                    cond2 = false;
                }
            }

            if (cond1) {
                possibleMoves.add(basicMoves[0]);
                if (cond2 && ((position < 16 && !isWhite()) || (position > 47 && isWhite()))) {
                    possibleMoves.add(basicMoves[1]);
                }
            }

            //---------------------Bicie figur
            Integer[] figuresToKill = new Integer[2];
            if (!isWhite()) {
                if ((position + 1) % 8 != 0) {
                    figuresToKill[0] = position + 9;
                }
                if (position % 8 != 0) {
                    figuresToKill[1] = position + 7;
                }
            } else {
                if ((position + 1) % 8 != 0) {
                    figuresToKill[0] = position - 7;
                }
                if (position % 8 != 0) {
                    figuresToKill[1] = position - 9;
                }
            }

            for (Integer x : board.figuresPosition) {
                if (x.equals(figuresToKill[0]) && isFiguresDifferentColor(board.getParticularFigure(x))) {
                    possibleMoves.add(figuresToKill[0]);
                    setFigureToKill(board.getParticularFigure(figuresToKill[0]));
                }
                if (x.equals(figuresToKill[1]) && isFiguresDifferentColor(board.getParticularFigure(x))) {
                    possibleMoves.add(figuresToKill[1]);
                    setFigureToKill(board.getParticularFigure(figuresToKill[1]));
                }
            }
        }
        return possibleMoves;
    }

}
