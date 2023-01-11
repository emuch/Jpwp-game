package emuch.efs;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
Gorny panel gry, na ktorym sa widoczne wszystkie zasoby i informacje
 */
class MenuPanel extends JPanel{
    Menu menu;
    LabelMenuPanel dateLabel;
    int x;
    int y;
    double xm;
    double ym;
    double xt;
    double dx;
    double dy;

    Image button_upgrade;
    Image button_menu;
    Image button_turn;
    /**
    Parametry MenuPanel - Panel gorny gry
    */
    MenuPanel(Menu menu) {
        this.menu = menu;
        this.x = menu.x;         //rozmiar x górnego panelu
        this.y = menu.y;         //rozmiar y górnego panelu
        this.xm = 0.2*x;         //pozycja x przycisku panelu od lewej (1152)
        this.ym = 0;             //pozycja y przycisku panelu od góry (0)
        this.xt = 0.1*x;         //pozycja x przycisku tury (TO DO liczba)
        this.dx = x*(0.1);       //rozmiar 2*x przycisku panelu
        this.dy = y*(0.05);      //rozmiar y przycisku panelu
        
        ImageIcon button_upgrade = new ImageIcon(this.menu.imagepath + "/button_upgrade.png");
        this.button_upgrade = button_upgrade.getImage();
        ImageIcon button_menu = new ImageIcon(this.menu.imagepath + "/button_menu.png");
        this.button_menu = button_menu.getImage();
        ImageIcon button_turn = new ImageIcon(this.menu.imagepath + "/button_turn.png");
        this.button_turn = button_turn.getImage();

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double gix = (double)e.getX();
                double giy = (double)e.getY();
                if (menu.gameinterface.show_buttons==false){
                    if (gix > 0 && gix < dx && giy > ym && giy < ym+dy) {
                        buttonUpgrade();
                    }
                    if (gix > xm && gix < xm+dx && giy > ym && giy < ym+dy) {
                        buttonMenu();
                    }
                    if (gix > xt && gix < xt+dx && giy > ym && giy < ym+dy) {
                        buttonTurn();
                    }
                }
            }
        });
        this.setVisible(true);
    }
    /**
    Dzialanie przycisku button_upgrade
    */
    void buttonUpgrade() {
        if (this.menu.gameinterface.highlight == 1) {
            this.menu.buildingResources.castle.upgrade();
            this.menu.labelmenupanel.infoLabel.setText("Zamek |Level: "+menu.buildingResources.castle.level+" Wood: "+menu.buildingResources.castle.woodcost+" Stone: "+menu.buildingResources.castle.stonecost+" Gold: "+menu.buildingResources.castle.goldcost);
        }
        if (this.menu.gameinterface.highlight == 2) {
            this.menu.buildingResources.sawmill.upgrade();
            this.menu.labelmenupanel.infoLabel.setText("Tartak |Level: "+menu.buildingResources.sawmill.level+" Wood: "+menu.buildingResources.sawmill.woodcost+" Stone: "+menu.buildingResources.sawmill.stonecost+" Gold: "+menu.buildingResources.sawmill.goldcost);
        }
        if (this.menu.gameinterface.highlight == 3) {
            this.menu.buildingResources.stonemine.upgrade();
            this.menu.labelmenupanel.infoLabel.setText("Kamieniołom | Level: "+menu.buildingResources.stonemine.level+" Wood: "+menu.buildingResources.stonemine.woodcost+" Stone: "+menu.buildingResources.stonemine.stonecost+" Gold: "+menu.buildingResources.stonemine.goldcost);
        }
        if (this.menu.gameinterface.highlight == 4) {
            this.menu.buildingResources.goldmine.upgrade();
            this.menu.labelmenupanel.infoLabel.setText("Kopalnia złota | Level: "+menu.buildingResources.goldmine.level+" Wood: "+menu.buildingResources.goldmine.woodcost+" Stone: "+menu.buildingResources.goldmine.stonecost+" Gold: "+menu.buildingResources.goldmine.goldcost);
        }
        this.menu.labelmenupanel.resourceLabelwood.setText("W: "+this.menu.buildingResources.wood+"+"+this.menu.buildingResources.woodGain);
        this.menu.labelmenupanel.resourceLabelstone.setText("S: "+this.menu.buildingResources.stone+"+"+this.menu.buildingResources.stoneGain);
        this.menu.labelmenupanel.resourceLabelgold.setText("G: "+this.menu.buildingResources.gold+"+"+this.menu.buildingResources.goldGain);
        if (this.menu.buildingResources.wood < 0 || this.menu.buildingResources.stone < 0 || this.menu.buildingResources.gold < 0) {
            this.menu.defeat();
        }
    }
    /**
    Dzialanie przycisku button_menu
    */
    void buttonMenu() {
        this.menu.labelmenupanel.dateLabel.setVisible(false);
        this.menu.labelmenupanel.resourceLabelwood.setVisible(false);
        this.menu.labelmenupanel.resourceLabelstone.setVisible(false);
        this.menu.labelmenupanel.resourceLabelgold.setVisible(false);
        //this.menu.labelmenupanel.eventLabel.setVisible(false);
        this.menu.labelmenupanel.infoLabel.setVisible(false);
        this.menu.gameinterface.show_buttons = true;
        this.repaint();
        this.menu.gameinterface.repaint();
    }
    /**
    Dzialanie przycisku button_turn
    */
    void buttonTurn() {  
        this.menu.rcounter.advance();
        this.menu.labelmenupanel.dateLabel.setText("Tura: " + Integer.toString(this.menu.rcounter.returnTurn()) + " Tydzień: " + Integer.toString(this.menu.rcounter.returnWeek()) + " " + Integer.toString(this.menu.rcounter.returnMonth()) + "-" + Integer.toString(this.menu.rcounter.returnYear()));
        this.menu.rcounter.check_events();
        if(this.menu.buildingResources.wood>999) {
            this.menu.buildingResources.wood = 999;
        }
        if(this.menu.buildingResources.stone>999) {
            this.menu.buildingResources.stone = 999;
        }
        if(this.menu.buildingResources.gold>999) {
            this.menu.buildingResources.gold = 999;
        }
        if(this.menu.buildingResources.woodGain>99) {
            this.menu.buildingResources.woodGain = 99;
        }
        if(this.menu.buildingResources.stoneGain>99) {
            this.menu.buildingResources.stoneGain = 99;
        }
        if(this.menu.buildingResources.goldGain>99) {
            this.menu.buildingResources.goldGain = 99;
        }
        this.menu.labelmenupanel.resourceLabelwood.setText("W: "+this.menu.buildingResources.wood+"+"+this.menu.buildingResources.woodGain);
        this.menu.labelmenupanel.resourceLabelstone.setText("S: "+this.menu.buildingResources.stone+"+"+this.menu.buildingResources.stoneGain);
        this.menu.labelmenupanel.resourceLabelgold.setText("G: "+this.menu.buildingResources.gold+"+"+this.menu.buildingResources.goldGain);
        if (this.menu.buildingResources.wood < 0 || this.menu.buildingResources.stone < 0 || this.menu.buildingResources.gold < 0) {
            this.menu.defeat();
        }
    }
    
    
    /** 
     * @param g
     */
    /**
    Rysowanie gornego panelu w zaleznosci od zmiennych
    */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if(this.menu.gameinterface.show_buttons == false){
            g2.setColor(new Color(238, 238,238));                   //kolor panelu
            g2.fillRect(0, 0, this.x, (int) this.y);                   //kolorowanie panelu po kliknięciu start
            g2.drawImage(this.button_upgrade, 0, 0, null);  //przycisk upgrade
            g2.drawImage(this.button_turn, (int) xt,0, null);   //przycisk turn
            g2.drawImage(this.button_menu, (int)xm, 0, null);  //przycisk menu
         }else if(this.menu.gameinterface.show_buttons == true){
            g2.setColor(new Color(238, 238,238));                   //kolor panelu
            g2.fillRect(0, 0, this.x, (int) this.y);                   //kolorowanie panelu dla włączenia gry
         }
    }
}