package controllers;

import model.Board.Board;
import view.frame.GameFrame;
import view.gameOverView.GameOverWindow;
import view.gameView.MainPanel;
import view.gameView.SidePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameOverController {
    private GameFrame gameFrame;
    private GameOverWindow gameOverWindow;

    public GameOverController(GameFrame gameFrame, GameOverWindow gameOverWindow) {
        this.gameFrame = gameFrame;
        this.gameOverWindow = gameOverWindow;
        gameOverWindow.getRestartGameButton().addActionListener(new RestartGameOverListener());
        gameOverWindow.addWindowListener(new WindowClosingListener());
    }

    class RestartGameOverListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gameFrame.setEnabled(true);
            gameOverWindow.dispose();

            Board board = new Board(gameFrame);
            SidePanel sidePanel = new SidePanel();
            MainPanel mainPanel = new MainPanel(sidePanel,board);

            new SidePanelController(board,gameFrame, sidePanel);

            gameFrame.setPanel(mainPanel);
            gameFrame.repaintFrameContent();
        }
    }

    class WindowClosingListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            gameFrame.setEnabled(true);
            gameOverWindow.dispose();
        }
    }
}
