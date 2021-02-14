
import controllers.StartPanelController;
import view.Backgrounds.FrameBackground;
import view.frame.GameFrame;
import view.startView.StartPanel;

import java.awt.*;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrameBackground frameBackground = new FrameBackground("image/tlo.jpg");
                StartPanel startPanel = new StartPanel();
                frameBackground.add(startPanel);

                GameFrame gameFrame = new GameFrame(frameBackground);

                new StartPanelController(gameFrame,startPanel);
            }
        });
    }
}
