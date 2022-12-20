package emuch.efs;

import javax.swing.JFrame;
//import java.io.File;

class Menu {
    JFrame menu;
    GameInterface gameinterface;
    MenuPanel menupanel;
    LabelMenuPanel labelmenupanel;
    RoundCounter rcounter;
    BuildingResources buildingResources;
    int difficulty;
    int x = 1280;
    int y = 720;
    //String indirectPathimages;
    //String indirectPathsounds;
    //Drawing drawing;
    
    Menu() throws Exception {
        menu = new JFrame("Empire from scratch");
        menu.setSize(x,y);
        menu.setResizable(false);
        menu.setLayout(null);

        labelmenupanel = new LabelMenuPanel(this);
        labelmenupanel.setSize(x*7/10, y*5/100);
        labelmenupanel.setLocation(0, 0);
        
        menupanel = new MenuPanel(this);
        menupanel.setSize(x*3/10, y*5/100);
        menupanel.setLocation(x*2/10*3+x*1/10, 0);

        gameinterface = new GameInterface(this);
        gameinterface.setSize(x, y*95/100);
        gameinterface.setLocation(0, y*5/100);
        
        menu.add(menupanel);
        menu.add(gameinterface);
        menu.add(labelmenupanel);

        this.difficulty = 1;
        setGame();
        Thread thread = new Muzyka_dziala();
        thread.start();
        menu.setVisible(true);

        
        //this.indirectPathimages = new File(App.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getPath() + "/images/";
        //this.indirectPathimages = new App().getClass().getResource("../images/").toString();
        //this.indirectPathsounds = new App().getClass().getResource("../../../sounds/").toString();
        //System.out.println(indirectPathimages + " koniec");
    }

    void setGame() {
        this.labelmenupanel.dateLabel.setText("Tura:1 Tydzień:1 1-1263");
        this.labelmenupanel.resourceLabel.setText("");
        this.labelmenupanel.eventLabel.setText("Brak wydarzeń");
        this.labelmenupanel.infoLabel.setText("Brak wyboru");
        this.rcounter = new RoundCounter(this); //licznik tur
        try {
            this.buildingResources = new BuildingResources(this);
        } catch (Exception e) {
        }
    }

    void defeat() {
        setGame();
        this.labelmenupanel.eventLabel.setText("Zbankrutowałeś. Zacznij od nowa!");
    }
}

class Muzyka_dziala extends Thread {
    public void run() {
        Music.playMusic();
    }
}