package view.startView;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;


public class StartPanel extends JPanel {
    private final JButton newGameButton;
    private final JButton continueGameButton;
    private final JButton exitGameButton;

    public StartPanel() {
        super();
        this.newGameButton = new JButton("NewGame");
        this.continueGameButton = new JButton("Continue");
        this.exitGameButton = new JButton("Exit");


        this.setOpaque(false);
        this.setPreferredSize(new Dimension(850, 720));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JTextPane startTitle = new JTextPane();

        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setFontSize(attributeSet,100);
        StyleConstants.setAlignment(attributeSet,StyleConstants.ALIGN_CENTER);
        StyleConstants.setBold(attributeSet,true);
        startTitle.setCharacterAttributes(attributeSet,false);

        startTitle.setText("GAME OF CHESS");
        startTitle.setDisabledTextColor(Color.BLACK);
        startTitle.setEnabled(false);
        startTitle.setOpaque(false);

        Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 22);
        newGameButton.setFont(f2);
        continueGameButton.setFont(f2);
        exitGameButton.setFont(f2);

        newGameButton.setAlignmentX(CENTER_ALIGNMENT);
        continueGameButton.setAlignmentX(CENTER_ALIGNMENT);
        exitGameButton.setAlignmentX(CENTER_ALIGNMENT);
        startTitle.setAlignmentX(CENTER_ALIGNMENT);

        newGameButton.setMaximumSize(new Dimension(400, 70));
        continueGameButton.setMaximumSize(new Dimension(400, 70));
        exitGameButton.setMaximumSize(new Dimension(400, 70));
        startTitle.setMaximumSize(new Dimension( 1000,150));

        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(startTitle);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(newGameButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(continueGameButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(exitGameButton);

    }

    public JButton getNewGameButton() {
        return newGameButton;
    }

    public JButton getContinueGameButton() {
        return continueGameButton;
    }

    public JButton getExitGameButton() {
        return exitGameButton;
    }

}

