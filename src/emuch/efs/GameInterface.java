package emuch.efs;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;


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
    GameInterface (int x, int y){
        this.x = x;
        this.y = y;
        this.b1yrel = -y*(0.1)/2-y*(0.1);
        this.b2yrel = -y*(0.1)/2;
        this.b3yrel = -y*(0.1)/2+y*(0.1);
        this.xpos = x*(1-0.1)/2;
        this.ypos = y*(1-0.1)/2;
        this.dx = x*(0.1);
        this.dy = y*(0.1);
    }

    void buttonStart() {
        
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
        g2.setColor(new Color(0,0,0));
        g2.fillRect((int)xpos,(int)(ypos+b1yrel),(int)dx,(int)dy);
        g2.setColor(new Color(255,0,0));
        g2.fillRect((int)xpos,(int)(ypos+b2yrel),(int)dx,(int)dy);
        g2.setColor(new Color(0,0,255));
        g2.fillRect((int)xpos,(int)(ypos+b3yrel),(int)dx,(int)dy);
    }
}