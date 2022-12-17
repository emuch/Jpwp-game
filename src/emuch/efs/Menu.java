package emuch.efs;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Menu {
    JFrame menu;
    GameInterface gameinterface;
    MenuPanel menupanel;
    Game game;
    int x = 1280;
    int y = 720;
    
    Menu() {
        game = new Game();
        menu = new JFrame("Empire from scratch");
        menu.setSize(x,y);
        menu.setResizable(false);
        menu.setLayout(null);
        gameinterface = new GameInterface(this);
        gameinterface.setSize(x, y*95/100);
        gameinterface.setLocation(0,y*5/100);
        gameinterface.setBackground(new Color(0,255,0));

        gameinterface.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double gix = (double)e.getX();
                double giy = (double)e.getY();
                if (gameinterface.show_buttons==true && gix > gameinterface.xpos && gix < gameinterface.xpos+gameinterface.dx) {
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
        
        menupanel = new MenuPanel(this);
        menupanel.setSize(x, y*5/100);
        menupanel.y = y*5/100;
        menupanel.setLocation(0, 0);
        menupanel.setBackground(new Color(128,128,128));
        
        menupanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double gix = (double)e.getX();
                double giy = (double)e.getY();
                if (gameinterface.show_buttons==false && gix > menupanel.xm && gix < menupanel.xm+menupanel.dx){
                    if (giy > menupanel.ym && giy < menupanel.ym+menupanel.dy) {
                        menupanel.buttonMenu();
                    }
                }
            }
        });

        menu.add(menupanel);
        menu.add(gameinterface);
        Thread thread = new Muzyka_dziala();
        thread.start();
        menu.setVisible(true);
    }
}

class Muzyka_dziala extends Thread {
    public void run() {
        Music.playMusic();
    }

}
