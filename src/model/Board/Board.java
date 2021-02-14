package model.Board;

import controllers.FiguresController;
import controllers.TilesController;
import view.frame.GameFrame;
import model.Figures.*;
import view.gameOverView.GameOverWindow;
import controllers.GameOverController;
import view.gameView.SidePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    public static final int WHITE_TURN = 0;
    public static final int BLACK_TURN = 1;
    public ArrayList<Integer> figuresPosition;

    private int turn = WHITE_TURN;

    private boolean isWhiteKingAlive = true;
    private boolean isBlackKingAlive = true;
    private String[] filePaths;
    private GameFrame gameFrame;
    private Figure selectedFigure = null;


    private void setFilePaths() {
        this.filePaths = new String[12];
        filePaths[0] = "image/wieza_c.png";
        filePaths[1] = "image/kon_c.png";
        filePaths[2] = "image/laufer_c.png";
        filePaths[3] = "image/krolowa_c.png";
        filePaths[4] = "image/krol_c.png";
        filePaths[5] = "image/pionek_c.png";
        filePaths[6] = "image/wieza_b.png";
        filePaths[7] = "image/kon_b.png";
        filePaths[8] = "image/laufer_b.png";
        filePaths[9] = "image/krolowa_b.png";
        filePaths[10] = "image/krol_b.png";
        filePaths[11] = "image/pionek_b.png";
    }
    private void setTiles() {
        Tile tile;
        int x = 0;
        //Rysowanie Szachownicy
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        tile = new Tile("image/pole_biale.png", x);
                    } else {
                        tile = new Tile("image/pole_czarne.png", x);
                    }
                } else {
                    if (j % 2 == 1) {
                        tile = new Tile("image/pole_biale.png", x);
                    } else {
                        tile = new Tile("image/pole_czarne.png", x);
                    }
                }
                add(tile);
                x++;
            }
        }
    }
    private void setFigure(Figure figure, int i) {
        figure.setOpaque(false);
        Tile tile = (Tile) this.getComponent(i);
        tile.add(figure);
    }
    private void setAllFigures() {
        Figure figure;
        //CZARNE PIONKI
        figure = new Rook(filePaths[0],  false, 0);
        setFigure(figure, 0);
        figure = new Rook(filePaths[0],  false, 7);
        setFigure(figure, 7);
        figuresPosition.add(0);
        figuresPosition.add(7);

        figure = new Knight(filePaths[1],  false, 1);
        setFigure(figure, 1);
        figure = new Knight(filePaths[1],  false, 6);
        setFigure(figure, 6);
        figuresPosition.add(1);
        figuresPosition.add(6);

        figure = new Bishop(filePaths[2],  false, 2);
        setFigure(figure, 2);
        figure = new Bishop(filePaths[2],  false, 5);
        setFigure(figure, 5);
        figuresPosition.add(2);
        figuresPosition.add(5);

        figure = new Queen(filePaths[3],  false, 3);
        setFigure(figure, 3);
        figuresPosition.add(3);

        figure = new King(filePaths[4],  false, 4);
        setFigure(figure, 4);
        figuresPosition.add(4);

        for (int i = 8; i < 16; i++) {
            figure = new Pawn(filePaths[5],  false, i);
            setFigure(figure, i);
            figuresPosition.add(i);
        }

        //BIAŁE PIONKI
        figure = new Rook(filePaths[6],  true, 56);
        setFigure(figure, 56);
        figure = new Rook(filePaths[6],  true, 63);
        setFigure(figure, 63);
        figuresPosition.add(56);
        figuresPosition.add(63);

        figure = new Knight(filePaths[7],  true, 57);
        setFigure(figure, 57);
        figure = new Knight(filePaths[7],  true, 62);
        setFigure(figure, 62);
        figuresPosition.add(57);
        figuresPosition.add(62);

        figure = new Bishop(filePaths[8],  true, 58);
        setFigure(figure, 58);
        figure = new Bishop(filePaths[8],  true, 61);
        setFigure(figure, 61);
        figuresPosition.add(58);
        figuresPosition.add(61);

        figure = new Queen(filePaths[9],  true, 59);
        setFigure(figure, 59);
        figuresPosition.add(59);

        figure = new King(filePaths[10],  true, 60);
        setFigure(figure, 60);
        figuresPosition.add(60);

        for (int i = 48; i < 56; i++) {
            figure = new Pawn(filePaths[11],  true, i);
            setFigure(figure, i);
            figuresPosition.add(i);
        }
    }
    private void setTilesListeners() {
        TilesController tilesController = new TilesController(this);
        for (int i = 0; i < 64; i++) {
            Tile tile = (Tile) this.getComponent(i);
            tilesController.addTileListener(tile);
        }
    }
    private void setFiguresListeners() {
        FiguresController figuresController = new FiguresController(this);
        for (Integer position : figuresPosition) {
            Tile tile = (Tile) this.getComponent(position);
            figuresController.addFigureListener((Figure) tile.getComponent(0));
        }
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
    public int getTurn() {
        return turn;
    }
    public void setSelectedFigure(Figure selectedFigure) {
        this.selectedFigure = selectedFigure;
    }
    public Figure getSelectedFigure() {
        return selectedFigure;
    }


    public void repaintBoard() {
        for (Integer i = 0; i < 64; i++) {
            Tile tile = (Tile) this.getComponent(i);
            tile.repaintComponent();
            for (Integer j : figuresPosition) {
                if (i.equals(j)) {                                            //BARDZO WAŻNE ŻEBY PORÓWNYWAĆ FUNKCJĄ EQUALS, BO == MOŻE NIE ZADZIAŁAĆ
                    Figure figure = (Figure) tile.getComponent(0);
                    figure.repaintComponent();
                }
            }
        }
        setTilesListeners();
        setFiguresListeners();
    }  //służy do rysowania planszy na nowo po wczytaniu gry
    public void markTiles(ArrayList<Integer> possibleMoves) {
        Tile tile1;
        int i, x = 0;
        for (i = 0; i < possibleMoves.size(); i++) {
            x = possibleMoves.get(i);
            tile1 = (Tile) this.getComponent(x);
            this.remove(x);

            tile1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));

            //Tu ustawiamy czerwone obramówki jeśli pionek można pobić
            for (Integer y : this.figuresPosition) {
                if (x == y) {
                    tile1.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                }
            }

            tile1.setIsSelected(true);
            tile1.validate();
            this.add(tile1, x);
        }
        this.repaint();
    }
    public void unmarkTiles() {
        //---------------------Kliknięcie ponowne na ten sam pionek wyłącza z niego selected
        for (int i = 0; i < 64; i++) {
            Tile tile = (Tile) this.getComponent(i);
            tile.setBorder(null);
            tile.setIsSelected(false);
        }
    }
    public void setFiguresStatus(Figure selectedFigure) {
        this.setSelectedFigure(selectedFigure);
        //-------------------------Ustawianie reszty pionków by się nie ruszały
        Tile tile;
        for (Integer y : this.figuresPosition) {
            tile = (Tile) this.getComponent(y);
            Figure figure = (Figure) tile.getComponent(0);
            if (figure.getStatus() != Figure.TO_KILL) {
                figure.setStatus(Figure.IS_NOT_ENABLED);
            }
        }
        tile = (Tile) this.getComponent(this.selectedFigure.getPosition());
        Figure figure = (Figure) tile.getComponent(0);
        figure.setStatus(Figure.IS_SELECTED);
    }
    public void resetFiguresStatus() {
        if (isBlackKingAlive && isWhiteKingAlive) {
            for (Integer x : figuresPosition) {
                Tile tile = (Tile) getComponent(x);
                Figure figure = (Figure) tile.getComponent(0);
                if (turn == WHITE_TURN) {
                    if (figure.isWhite()) {
                        figure.setStatus(Figure.IS_ENABLED);
                    } else {
                        figure.setStatus(Figure.IS_NOT_ENABLED);
                    }
                } else if (turn == BLACK_TURN) {
                    if (!figure.isWhite()) {
                        figure.setStatus(Figure.IS_ENABLED);
                    } else {
                        figure.setStatus(Figure.IS_NOT_ENABLED);
                    }
                }
            }
        }
    }
    public void deleteFigure(Figure figureToDelete) {
        //sprawdzanie czy bijemy króla
        if(figureToDelete.getClass()==King.class){
            GameOverWindow gameOverWindow;
            if(figureToDelete.isWhite()){
                isWhiteKingAlive = false;
                gameOverWindow = new GameOverWindow(gameFrame, "Black's Wins!");
            }else{
                isBlackKingAlive = false;
                gameOverWindow = new GameOverWindow(gameFrame, "White's Wins!");
            }
            new GameOverController(gameFrame, gameOverWindow);
            for (Integer x : figuresPosition) {
                Tile tile = (Tile) getComponent(x);
                Figure figure = (Figure) tile.getComponent(0);
                figure.setStatus(Figure.IS_NOT_ENABLED);
            }
            gameFrame.setEnabled(false);

        }

        //usuwanie pionka
        Tile tile = (Tile) this.getComponent(figureToDelete.getPosition());
        tile.remove(0);


        //usuwanie pozycji usuniętego pionka w tablicy pozycji pionków
        int i = 0, memberToDelete = 0;
        for (Integer x : figuresPosition) {
            if (x == selectedFigure.getPosition()) {
                memberToDelete = i;
            }
            i++;
        }
        figuresPosition.remove(memberToDelete);

        //ustawianie pozycji pionka
        selectedFigure.setPosition(figureToDelete.getPosition());
        tile.add(selectedFigure);
        repaint();

    }

    public Figure changeFigurePosition(int tilePosition){
        //-------------------------Ustawianie pionków by znów się ruszały
        int i=0,oldPosition=0;
        for(Integer x:figuresPosition){
            if(x==selectedFigure.getPosition()){
                oldPosition=i;
            }
            i++;
        }
        figuresPosition.remove(oldPosition);
        figuresPosition.add(tilePosition);

        selectedFigure.setPosition(tilePosition);
        return selectedFigure;
    }
    public Figure getParticularFigure(int figurePosition){
        Tile tile = (Tile) getComponent(figurePosition);
        return (Figure) tile.getComponent(0);
    }

    public void setNextTurn(){
        JPanel mainPanel =  gameFrame.getPanel();
        SidePanel sidePanel = (SidePanel) mainPanel.getComponent(2);
        if(turn == WHITE_TURN){
            sidePanel.getTurnText().setText("BLACK'S TURN");
        }else {
            sidePanel.getTurnText().setText("WHITE'S TURN");
        }
        turn = (turn +1)%2;
    }

    public Board(GameFrame gameFrame) {
        super();
        this.gameFrame = gameFrame;
        this.figuresPosition = new ArrayList<>();
        setFilePaths();
        setPreferredSize(new Dimension(600, 600));
        setLayout(new GridLayout(8, 8));

        setTiles();
        setAllFigures();
        setTilesListeners();
        setFiguresListeners();
    }
}
