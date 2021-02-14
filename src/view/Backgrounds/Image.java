package view.Backgrounds;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Image extends JPanel  {
    private transient BufferedImage image;
    private String filename;

    public Image(String filename) {
        super();
        this.filename=filename;
        this.setLayout(new BorderLayout());

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


    public void repaintComponent(){
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

