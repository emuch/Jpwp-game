package emuch.efs;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.io.File;

class Menu {
    JFrame menu;
    GameInterface gameinterface;
    MenuPanel menupanel;
    int x = 1280;
    int y = 720;
    String indirectPathimages;
    RoundCounter rcounter;
    //String indirectPathsounds;
    
    Menu() throws Exception {
        menu = new JFrame("Empire from scratch");
        menu.setSize(x,y);
        menu.setResizable(false);
        menu.setLayout(null);
        
        menupanel = new MenuPanel(this);
        menupanel.setSize(x, y*5/100);
        menupanel.setLocation(0, 0);

        gameinterface = new GameInterface(this);
        gameinterface.setSize(x, y*95/100);
        gameinterface.setLocation(0,y*5/100);

        menu.add(menupanel);
        menu.add(gameinterface);
        rcounter = new RoundCounter(this); //licznik tur
        
        Thread thread = new Muzyka_dziala();
        thread.start();
        menu.setVisible(true);
        
        //this.indirectPathimages = new File(App.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getPath() + "/images/";
        //this.indirectPathimages = new App().getClass().getResource("../images/").toString();
        //this.indirectPathsounds = new App().getClass().getResource("../../../sounds/").toString();
        //System.out.println(indirectPathimages + " koniec");
    }
}

class Muzyka_dziala extends Thread {
    public void run() {
        Music.playMusic();
    }

}
