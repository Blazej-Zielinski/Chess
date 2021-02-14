package view.gameOverView;


import view.Backgrounds.FrameBackground;
import view.frame.GameFrame;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;


public class GameOverWindow extends JFrame {
    private JButton restartGameButton;

    public GameOverWindow(GameFrame frame, String title) {
        super(title);
        setSize(600, 300);
        setLocation(frame.getX() + 200, frame.getY() + 100);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setSize(600, 300);

        JTextPane gameOverText = new JTextPane();

        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setFontSize(attributeSet,60);
        StyleConstants.setAlignment(attributeSet,StyleConstants.ALIGN_CENTER);
        StyleConstants.setBold(attributeSet,true);
        gameOverText.setCharacterAttributes(attributeSet,false);

        gameOverText.setText(title);
        gameOverText.setDisabledTextColor(Color.WHITE);
        gameOverText.setEnabled(false);
        gameOverText.setOpaque(false);

        restartGameButton = new JButton("RESTART");

        Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 18);
        restartGameButton.setFont(f2);
        restartGameButton.setMaximumSize(new Dimension(250,200));
        restartGameButton.setAlignmentX(CENTER_ALIGNMENT);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(gameOverText);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        mainPanel.add(restartGameButton);

        FrameBackground background = new FrameBackground("image/szachy4.jpg");
        background.add(mainPanel);
        add(background);
    }

    public JButton getRestartGameButton() {
        return restartGameButton;
    }
}

