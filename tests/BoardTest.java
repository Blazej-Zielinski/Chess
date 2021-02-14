import model.Board.Board;
import model.Figures.Figure;
import org.junit.Assert;
import org.junit.Test;
import view.frame.GameFrame;
import view.gameView.MainPanel;
import view.gameView.SidePanel;

import javax.swing.*;

public class BoardTest {
    @Test
    public void changeFigurePosition_tilePosition16_returnsFigureWithPosition16() {
        //given
        int tilePosition = 16;
        Board board = new Board(null);
        Figure selectedFigure = board.getParticularFigure(1);
        board.setSelectedFigure(selectedFigure);

        //when
        Figure figure = board.changeFigurePosition(tilePosition);

        //then
        Assert.assertEquals(tilePosition, figure.getPosition());
        Assert.assertEquals(figure, board.getSelectedFigure());
    }

    @Test
    public void figureToDelete_selectedFigureAtPosition5_boardFiguresPositionWithoutPosition5() {
        //given
        Board board = new Board(null);
        board.setSelectedFigure(board.getParticularFigure(5));
        Figure figureToDelete = board.getParticularFigure(62);

        //when
        board.deleteFigure(figureToDelete);

        //then
        Assert.assertFalse(board.figuresPosition.contains(5));
    }

    @Test
    public void setNextTurn_runSetNextTurn7Times_BlacksTurn() {
        //given
        GameFrame gameFrame = new GameFrame(new JPanel());
        gameFrame.setVisible(false);
        Board board = new Board(gameFrame);
        SidePanel sidePanel = new SidePanel();
        MainPanel mainPanel = new MainPanel(sidePanel,board);
        gameFrame.setPanel(mainPanel);
        gameFrame.repaintFrameContent();


        //when
        for (int i = 0; i < 7; i++) {
            board.setNextTurn();
        }

        //then
        Assert.assertEquals(board.getTurn(), Board.BLACK_TURN);
        Assert.assertEquals(sidePanel.getTurnText().getText(), "BLACK'S TURN");
    }


}
