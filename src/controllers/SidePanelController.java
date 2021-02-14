package controllers;

import model.Board.Board;
import view.frame.GameFrame;
import view.gameView.MainPanel;
import view.gameView.SidePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SidePanelController {
    private GameFrame gameFrame;
    private Board board;

    public SidePanelController(Board board, GameFrame gameFrame, SidePanel sidePanel) {
        this.gameFrame = gameFrame;
        this.board = board;
        sidePanel.getRestartGameButton().addActionListener(new RestartGameListener());
        sidePanel.getSaveGameButton().addActionListener(new SaveGameListener());

    }

    class SaveGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("binFiles/object-graph.bin"))) {
                outputStream.writeObject(board);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class RestartGameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Board board = new Board(gameFrame);
            SidePanel sidePanel = new SidePanel();
            MainPanel mainPanel = new MainPanel(sidePanel,board);

            new SidePanelController(board,gameFrame, sidePanel);

            gameFrame.setPanel(mainPanel);
            gameFrame.repaintFrameContent();
        }
    }
}
