package model.Figures;

import model.Board.Board;

import java.util.ArrayList;

public class Bishop extends Figure {

    public Bishop(String filename, boolean isWhite, int position) {
        super(filename, isWhite, position);
    }

    @Override
    public ArrayList<Integer> move(Board board) {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        int moveDiagonal1 = 9, moveDiagonal2 = 7;

        //Podstawowe ruchy + bicie figur + blokowanie się figur

        //poruszanie się do up right
        outer1:
        for (Integer i = 1; (position + i * moveDiagonal1 < 64) && ((position + i * moveDiagonal1) % 8 != 0); i++) {
            for (Integer x : board.figuresPosition) {
                if (x == position + i * moveDiagonal1) {
                    if (isFiguresDifferentColor(board.getParticularFigure(x))) {
                        setFigureToKill(board.getParticularFigure(x));
                        possibleMoves.add(x);
                        break outer1;
                    } else {
                        break outer1;
                    }
                }
            }
            possibleMoves.add(position + i * moveDiagonal1);
        }

        //poruszanie się w down left
        outer2:
        for (Integer i = 1; (position - i * moveDiagonal1 >= 0) && ((position - i * moveDiagonal1 + 1) % 8 != 0); i++) {
            for (Integer x : board.figuresPosition) {
                if (x == position - i * moveDiagonal1) {
                    if (isFiguresDifferentColor(board.getParticularFigure(x))) {
                        setFigureToKill(board.getParticularFigure(x));
                        possibleMoves.add(x);
                        break outer2;
                    } else {
                        break outer2;
                    }
                }
            }
            possibleMoves.add(position - i * moveDiagonal1);
        }

        //poruszanie się w up left
        outer3:
        for (Integer i = 1; (position + i * moveDiagonal2 < 64) && ((position + i * moveDiagonal2 + 1) % 8 != 0); i++) {
            for (Integer x : board.figuresPosition) {
                if (x == position + i * moveDiagonal2) {
                    if (isFiguresDifferentColor(board.getParticularFigure(x))) {
                        setFigureToKill(board.getParticularFigure(x));
                        possibleMoves.add(x);
                        break outer3;
                    } else {
                        break outer3;
                    }
                }
            }
            possibleMoves.add(position + i * moveDiagonal2);
        }
        //poruszanie się w down right
        outer4:
        for (Integer i = 1; (position - i * moveDiagonal2 >= 0) && (position - i * moveDiagonal2) % 8 != 0; i++) {
            for (Integer x : board.figuresPosition) {
                if (x == position - i * moveDiagonal2) {
                    if (isFiguresDifferentColor(board.getParticularFigure(x))) {
                        setFigureToKill(board.getParticularFigure(x));
                        possibleMoves.add(x);
                        break outer4;
                    } else {
                        break outer4;
                    }
                }
            }
            possibleMoves.add(position - i * moveDiagonal2);
        }

        return possibleMoves;
    }

}
