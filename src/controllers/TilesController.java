package controllers;



import model.Board.Board;
import model.Board.Tile;
import model.Figures.Figure;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TilesController {
    private Board board;

    public TilesController(Board board) {
        this.board = board;
    }

    public void addTileListener(Tile tile){
        tile.addMouseListener(new TileListener(tile));
    }


     class TileListener implements MouseListener {
        private Tile tile;


        public TileListener(Tile tile) {
            this.tile = tile;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(tile.isSelected()){
                Figure selectedFigure = board.changeFigurePosition(tile.getPosition());
                tile.add(selectedFigure);
                board.repaint();
                board.unmarkTiles();

                //Ustawianie stanów pionków
                board.setNextTurn();
                board.resetFiguresStatus();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
