package fr.projet5;


import javax.swing.*;
import java.awt.*;

class GlobalConsoleFrame extends JFrame
{
    GlobalConsoleFrame()
    {
        setSize(1280, 1024);
        setTitle("Test");
        setContentPane(new AfficheImage("/Users/souksou/Desktop/projet 5/projetD5/src/main/resources/foot.png"));
        getContentPane().setLayout(new BorderLayout());
        this.setVisible(true);
    }
}

class AfficheImage extends JPanel
{
    Image eau;

    AfficheImage(String s)
    {
        eau = getToolkit().getImage(s);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(eau, 0, 0, getWidth(), getHeight(), this);
    }
}

class affichage
{
    public static void main(String[] args)
    {
        GlobalConsoleFrame test = new GlobalConsoleFrame();
    }
}
