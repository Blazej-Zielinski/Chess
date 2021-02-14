package view.gameView;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel(JPanel sidePanel,JPanel board) {
        add(board);
        add(Box.createRigidArea(new Dimension(25,0)));
        add(sidePanel);
    }
}
