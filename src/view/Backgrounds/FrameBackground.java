package view.Backgrounds;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FrameBackground extends JPanel {
    private transient BufferedImage image;
    public FrameBackground(String filename) {
        super();
        this.setLayout(new FlowLayout());

        File imageFile = new File(filename);
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Bląd odczytu");
            e.printStackTrace();
        }

        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(dimension);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, this);
    }

}
