package view.frame;


import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame  {
    private JPanel panel;

    public GameFrame(JPanel panel) {
        super("App");
        this.panel = panel;
        add(panel);

        setPreferredSize(new Dimension(1280, 720));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        pack();
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void repaintFrameContent(){
        getContentPane().removeAll();
        add(this.panel);
        setSize(1000,700);
//        setLocation(200,50);
        validate();
        repaint();
    }
}

