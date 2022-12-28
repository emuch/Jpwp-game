package emuch.efs;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    
    MenuPanel(Menu menu) {
        this.menu = menu;
        this.x = menu.x;         //rozmiar x górnego panelu
        this.y = menu.y;         //rozmiar y górnego panelu
        this.xm = 0.2*x;         //pozycja x przycisku panelu od lewej (1152)
        this.ym = 0;             //pozycja y przycisku panelu od góry (0)
        this.xt = 0.1*x;         //pozycja x przucisku tury (TO DO liczba)
        this.dx = x*(0.1);       //rozmiar 2*x przycisku panelu
        this.dy = y*(0.05);      //rozmiar y przycisku panelu
        
        ImageIcon button_upgrade = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/button_upgrade.png");
        this.button_upgrade = button_upgrade.getImage();
        ImageIcon button_menu = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/button_menu.png");
        this.button_menu = button_menu.getImage();
        ImageIcon button_turn = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/button_turn.png");
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

    void buttonUpgrade() {
        if (this.menu.gameinterface.highlight == 1) {
            this.menu.buildingResources.castle.upgrade();
            this.menu.labelmenupanel.infoLabel.setText("Zamek|L:"+menu.buildingResources.castle.level+" W:"+menu.buildingResources.castle.woodcost+" S:"+menu.buildingResources.castle.stonecost+" G:"+menu.buildingResources.castle.goldcost);
        }
        if (this.menu.gameinterface.highlight == 2) {
            this.menu.buildingResources.sawmill.upgrade();
            this.menu.labelmenupanel.infoLabel.setText("Tartak|L:"+menu.buildingResources.sawmill.level+" W:"+menu.buildingResources.sawmill.woodcost+" S:"+menu.buildingResources.sawmill.stonecost+" G:"+menu.buildingResources.sawmill.goldcost);
        }
        if (this.menu.gameinterface.highlight == 3) {
            this.menu.buildingResources.stonemine.upgrade();
            this.menu.labelmenupanel.infoLabel.setText("Kamieniołom|L:"+menu.buildingResources.stonemine.level+" W:"+menu.buildingResources.stonemine.woodcost+" S:"+menu.buildingResources.stonemine.stonecost+" G:"+menu.buildingResources.stonemine.goldcost);
        }
        if (this.menu.gameinterface.highlight == 4) {
            this.menu.buildingResources.goldmine.upgrade();
            this.menu.labelmenupanel.infoLabel.setText("Kopalnia złota|L:"+menu.buildingResources.goldmine.level+" W:"+menu.buildingResources.goldmine.woodcost+" S:"+menu.buildingResources.goldmine.stonecost+" G:"+menu.buildingResources.goldmine.goldcost);
        }
        this.menu.labelmenupanel.resourceLabel.setText("D: "+this.menu.buildingResources.wood+"+"+this.menu.buildingResources.woodGain+" S: "+this.menu.buildingResources.stone+"+"+this.menu.buildingResources.stoneGain+" G: "+this.menu.buildingResources.gold+"+"+this.menu.buildingResources.goldGain);
        if (this.menu.buildingResources.wood < 0 || this.menu.buildingResources.stone < 0 || this.menu.buildingResources.gold < 0) {
            this.menu.defeat();
        }
    }
    
    void buttonMenu() {
        this.menu.labelmenupanel.dateLabel.setVisible(false);
        this.menu.labelmenupanel.resourceLabel.setVisible(false);
        this.menu.labelmenupanel.eventLabel.setVisible(false);
        this.menu.labelmenupanel.infoLabel.setVisible(false);
        this.menu.gameinterface.show_buttons = true;
        this.repaint();
        this.menu.gameinterface.repaint();
    }

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
        this.menu.labelmenupanel.resourceLabel.setText("D: "+this.menu.buildingResources.wood+"+"+this.menu.buildingResources.woodGain+" S: "+this.menu.buildingResources.stone+"+"+this.menu.buildingResources.stoneGain+" G: "+this.menu.buildingResources.gold+"+"+this.menu.buildingResources.goldGain);
        if (this.menu.buildingResources.wood < 0 || this.menu.buildingResources.stone < 0 || this.menu.buildingResources.gold < 0) {
            this.menu.defeat();
        }
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if(this.menu.gameinterface.show_buttons == false){
            g2.setColor(new Color(212, 217,219));                   //kolor panelu
            g2.fillRect(0, 0, this.x, (int) this.y);                   //kolorowanie panelu po kliknięciu start
            g2.drawImage(this.button_upgrade, 0, 0, null);  //przycisk menu
            g2.drawImage(this.button_menu, (int)xm, 0, null);  //przycisk menu
            g2.drawImage(this.button_turn, (int) xt,0, null);   //przycisk turn
         }else if(this.menu.gameinterface.show_buttons == true){
            g2.setColor(new Color(212, 217,219));                   //kolor panelu
            g2.fillRect(0, 0, this.x, (int) this.y);                   //kolorowanie panelu dla włączenia gry
         }
    }
}