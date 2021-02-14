package view.gameView;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class SidePanel extends JPanel {
    private final JButton restartGameButton;
    private final JButton saveGameButton;
    private JTextPane turnText;

    public SidePanel() {
        super();
        this.restartGameButton = new JButton("RESTART");
        this.saveGameButton = new JButton("SAVE");
        this.turnText = new JTextPane();

        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setFontSize(attributeSet,25);
        StyleConstants.setAlignment(attributeSet,StyleConstants.ALIGN_CENTER);
        StyleConstants.setBold(attributeSet,true);
        turnText.setCharacterAttributes(attributeSet,false);

        turnText.setText("WHITE'S TURN");
        turnText.setDisabledTextColor(Color.BLACK);
        turnText.setEnabled(false);
        turnText.setOpaque(false);
        turnText.setMaximumSize(new Dimension(200, 50));

        Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 18);

        restartGameButton.setFont(f2);
        restartGameButton.setMaximumSize(new Dimension(200, 50));
        restartGameButton.setAlignmentX(CENTER_ALIGNMENT);

        saveGameButton.setFont(f2);
        saveGameButton.setMaximumSize(new Dimension(200, 50));
        saveGameButton.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(turnText);
        add(Box.createRigidArea(new Dimension(0, 172)));
        add(saveGameButton);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(restartGameButton);
        add(Box.createRigidArea(new Dimension(0, 20)));

        setPreferredSize(new Dimension(300, 600));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public JButton getRestartGameButton() {
        return restartGameButton;
    }

    public JButton getSaveGameButton() {
        return saveGameButton;
    }

    public JTextPane getTurnText() {
        return turnText;
    }

    public void setTurnText(JTextPane turnText) {
        this.turnText = turnText;
    }
}

