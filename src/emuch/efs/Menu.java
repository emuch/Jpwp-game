package emuch.efs;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Menu {
    JFrame menu;
    JPanel menupanel;
    GameInterface gameinterface;
    Game game;
    int x = 1280;
    int y = 1024;
    
    Menu() {
        game = new Game();
        menu = new JFrame("Empire from scratch");
        menu.setSize(x,y);
        menu.setResizable(false);
        menu.setLayout(null);
        menupanel = new JPanel();
        menupanel.setSize(x, y*5/100);
        menupanel.setLocation(0, 0);
        menupanel.setBackground(new Color(255,0,0));
        gameinterface = new GameInterface(x,y);
        gameinterface.setSize(x, y*95/100);
        gameinterface.setLocation(0,y*5/100);
        gameinterface.setBackground(new Color(0,255,0));
        gameinterface.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double gix = (double)e.getX();
                double giy = (double)e.getY();
                if (gix > gameinterface.xpos && gix < gameinterface.xpos+gameinterface.dx) {
                    if (giy > gameinterface.ypos+gameinterface.b1yrel && giy < gameinterface.ypos+gameinterface.b1yrel+gameinterface.dy) {
                        gameinterface.buttonStart();
                    } else if (giy > gameinterface.ypos+gameinterface.b2yrel && giy < gameinterface.ypos+gameinterface.b2yrel+gameinterface.dy) {
                        gameinterface.buttonSettings();
                    } else if (giy > gameinterface.ypos+gameinterface.b3yrel && giy < gameinterface.ypos+gameinterface.b3yrel+gameinterface.dy) {
                        gameinterface.buttonExit();
                    }
                }
            }
        });
        
        menu.add(menupanel);
        menu.add(gameinterface);
        menu.setVisible(true);
    }
}
