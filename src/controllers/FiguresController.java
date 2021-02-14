package controllers;

import model.Board.Board;
import model.Figures.Figure;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class FiguresController {
    private Board board;

    public FiguresController(Board board) {
        this.board = board;
    }

    public void addFigureListener(Figure figure){
        figure.addMouseListener(new FigureListener(figure));
    }

    class FigureListener implements MouseListener{
        private Figure figure;

        public FigureListener(Figure figure) {
            this.figure = figure;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            int status = figure.getStatus();

            if (status == Figure.IS_ENABLED) {
                doWhenFigureIsEnabled();
            } else if (status == Figure.IS_SELECTED) {
                doWhenFigureIsSelected();
            } else if (status == Figure.TO_KILL) {
                doWhenFigureIsToKill();
            }
        }

        private void doWhenFigureIsEnabled(){
            ArrayList<Integer> possibleMoves = figure.move(board);
            if(possibleMoves.size() > 0) {
                board.markTiles(possibleMoves);
                board.setFiguresStatus(figure);
            }
        }
        private void doWhenFigureIsSelected(){
            board.unmarkTiles();
            board.resetFiguresStatus();
        }
        private void doWhenFigureIsToKill(){
            board.unmarkTiles();
            board.deleteFigure(figure);
            board.setNextTurn();
            board.resetFiguresStatus();
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
