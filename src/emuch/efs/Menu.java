package emuch.efs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
Klasa glowna, do ktorej sa dodawane Gameinterface, Menupanel, Music i LabelMenuPanel
*/
class Menu {
    JFrame menu;
    GameInterface gameinterface;
    MenuPanel menupanel;
    LabelMenuPanel labelmenupanel;
    Music music;
    RoundCounter rcounter;
    BuildingResources buildingResources;
    int difficulty;
    int x = 1280;
    int y = 720;
    Image game_icon;

    String imagepath;
    /**
    Elementy okna
    */
    Menu() throws Exception {
        this.imagepath = new File("images").getCanonicalPath().toString();

        ImageIcon game_icon = new ImageIcon(this.imagepath + "/game_icon.png");  //TO DO ICON
        //System.out.println(imagepath); //sprawdzenie sciezki wzglednej

        menu = new JFrame("Empire from scratch");
        menu.setIconImage(game_icon.getImage());
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

        music = new Music();
        music.playMusic();
        
        menu.setVisible(true);
        
        menu.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    /**
    Ustawienie poczatkowych zasobow, daty w zaleznosci od trudnosci
    */
    void setGame() {
        this.labelmenupanel.dateLabel.setText("Tura: 1 Tydzie??: 1 1-1263");
        this.labelmenupanel.resourceLabelwood.setText("");
        this.labelmenupanel.resourceLabelgold.setText("");
        this.labelmenupanel.resourceLabelstone.setText("");
        //this.labelmenupanel.eventLabel.setText("Brak wydarze??");
        this.labelmenupanel.infoLabel.setText("Brak wyboru");
        this.rcounter = new RoundCounter(this); //licznik tur
        try {
            this.buildingResources = new BuildingResources(this);
        } catch (Exception e) {
        }
    }
    /**
    Efekt porazki w grze
    */
    void defeat() {
        setGame();
        //this.labelmenupanel.eventLabel.setText("Zbankrutowa??e??. Zacznij od nowa!");
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Zbankrutowa??e??. Zacznij od nowa!");
    }
}