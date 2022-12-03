package emuch.efs;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

class Menu {
    JFrame menu;
    JPanel menupanel;
    JPanel gameinterface;
    
    Menu() {
        menu = new JFrame("Empire from scratch");
        menu.setSize(1280,1024);
        menu.setResizable(false);
        menu.setLayout(null);
        menupanel = new JPanel();
        menupanel.setSize(1280, 1024*5/100);
        menupanel.setLocation(0, 0);
        menupanel.setBackground(new Color(255,0,0));
        gameinterface = new JPanel();
        gameinterface.setSize(1280, 1024*95/100);
        gameinterface.setLocation(0,1024*5/100);
        gameinterface.setBackground(new Color(0,255,0));
        gameinterface.addMouseListener(null);
        
        menu.add(menupanel);
        menu.add(gameinterface);
        menu.setVisible(true);
    }
}
