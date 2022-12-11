package emuch.efs;

import javax.swing.JPanel;
import javax.swing.plaf.LabelUI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

class GameInterface extends JPanel {
    int x;
    int y;
    double b1yrel;
    double b2yrel;
    double b3yrel;
    double xpos;
    double ypos;
    double dx;
    double dy;
    Image background;
    boolean show_buttons;

    GameInterface (int x, int y){
        this.x = x;
        this.y = y;
        this.dx = x*(0.2);
        this.dy = y*(0.05);
        this.b1yrel = -(dy)/2-(dy)*2; //Guzik pierwszy w osi y
        this.b2yrel = -(dy)/2;         //Guzik drugi w osi y
        this.b3yrel = -(dy)/2+(dy)*2; //Guzik trzeci w osi y
        this.xpos = (this.x-this.dx)/2;
        this.ypos = (this.y-this.dy)/2;
        this.show_buttons = true;
    }
    
    void background_game() {
        ImageIcon background = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/map.PNG");
        this.background = background.getImage();
    }

    void buttonStart() {
        this.show_buttons = false;
        this.background_game();
        this.repaint();
    }
    
    void buttonSettings() {
        
    }
    
    void buttonExit() {
        System.exit(0);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background, 0, 0, null);
        if(this.show_buttons){
        g2.setColor(new Color(0,0,0));
        g2.fillRect((int)xpos,(int)(ypos+b1yrel),(int)dx,(int)dy);
        g2.setColor(new Color(255,0,0));
        g2.fillRect((int)xpos,(int)(ypos+b2yrel),(int)dx,(int)dy);
        g2.setColor(new Color(0,0,255));
        g2.fillRect((int)xpos,(int)(ypos+b3yrel),(int)dx,(int)dy);
        }
    }
}