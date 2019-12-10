package fr.projet5;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Panneau extends JPanel {

    public void paintComponent(Graphics g) {
        try {
            Image img = ImageIO.read(new File("/Users/monneriehugo/Desktop/projetD5/src/main/resources/image.jpg"));
            Image img2 = ImageIO.read(new File("/Users/monneriehugo/Desktop/projetD5/src/main/resources/image2.jpg"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            //g.drawImage(img, 0, 0, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}