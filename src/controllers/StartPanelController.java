package controllers;

import model.Board.Board;
import view.frame.GameFrame;
import view.gameView.MainPanel;
import view.gameView.SidePanel;
import view.startView.StartPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StartPanelController {
    private GameFrame gameFrame;

    public StartPanelController(GameFrame gameFrame, StartPanel startPanel) {
        this.gameFrame = gameFrame;

        startPanel.getNewGameButton().addActionListener(new NewGameListener());
        startPanel.getContinueGameButton().addActionListener(new ContinueGameListener());
        startPanel.getExitGameButton().addActionListener(new ExitGameListener());
    }

    class NewGameListener implements ActionListener{

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

    class ContinueGameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(() -> {
                Board board = null;
                SidePanel sidePanel = new SidePanel();
                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("binFiles/object-graph.bin"))) {
                    board = (Board) inputStream.readObject();
                    board.repaintBoard();
                    board.setGameFrame(gameFrame);
                    if(board.getTurn() == Board.BLACK_TURN){
                        sidePanel.getTurnText().setText("BLACK'S TURN");
                    }
                } catch (IOException ex) {

                    //Tworzona jest plansza w stanie podstawowym

                    board = new Board(gameFrame);
                    MainPanel mainPanel = new MainPanel(sidePanel,board);

                    new SidePanelController(board,gameFrame, sidePanel);

                    gameFrame.setPanel(mainPanel);
                    gameFrame.repaintFrameContent();

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                MainPanel mainPanel = new MainPanel(sidePanel,board);

                new SidePanelController(board,gameFrame,sidePanel);

                gameFrame.setPanel(mainPanel);
                gameFrame.repaintFrameContent();

            });
        }
    }

    class ExitGameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}

