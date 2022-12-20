package emuch.efs;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BasicStroke;

class GameInterface extends JPanel {
    MenuPanel menupanel;
    Menu menu;
    int highlight;
    int x;
    int y;
    double b1yrel;
    double b2yrel;
    double b3yrel;
    double xpos;
    double ypos;
    double dx;
    double dy;

    Image map_blur;
    Image logo;
    Image background;
    Image button_start;
    Image button_settings;
    Image button_exit;

    boolean show_buttons;

    GameInterface (Menu menu){
        this.menu = menu;
        this.highlight = 0;
        this.x = menu.x;                 //rozmiar x pola gry
        this.y = menu.y;                 //rozmiar y pola gry
        this.dx = x*(0.2);               //wielkość przycisków x
        this.dy = y*(0.05);              //wielkość przycisków y
        this.b1yrel = -(dy)/2-(dy)*2;    //Guzik pierwszy menu w osi y
        this.b2yrel = -(dy)/2;           //Guzik drugi w osi y
        this.b3yrel = -(dy)/2+(dy)*2;    //Guzik trzeci w osi y
        this.xpos = (this.x-this.dx)/2;  //Pozycja guzika w x od lewej krawędzi (512)
        this.ypos = (this.y-this.dy)/2;  //Pozycja guzika w y od góry (342)
        this.show_buttons = true;        //widoczność przycisków głównego menu
        
        ImageIcon map_blur = new ImageIcon(/*menu.indirectPathimages + */"C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/map_blur.png");
        this.map_blur = map_blur.getImage();
        ImageIcon logo = new ImageIcon("/C:/Users/Emus/Desktop/Programy%20Studia/JAVA%20JDK/Empirefromscratch/images/logo.png");
        this.logo = logo.getImage();
        ImageIcon button_start = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/button_start.png");
        this.button_start = button_start.getImage();
        ImageIcon button_settings = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/button_settings.png");
        this.button_settings = button_settings.getImage();
        ImageIcon button_exit = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/button_exit.png");
        this.button_exit = button_exit.getImage();
        ImageIcon background = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/map.png");
        this.background = background.getImage();

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double gix = (double)e.getX();
                double giy = (double)e.getY();
                //System.out.println(gix);
                //System.out.println(giy);
                if (show_buttons==true && gix > xpos && gix < xpos+dx) {
                    if (giy > ypos+b1yrel && giy < ypos+b1yrel+dy) {
                        buttonStart();
                    } else if (giy > ypos+b2yrel && giy < ypos+b2yrel+dy) {
                        buttonSettings();
                    } else if (giy > ypos+b3yrel && giy < ypos+b3yrel+dy) {
                        buttonExit();
                    }
                } else if (show_buttons==false) {
                    if (gix > 525 && gix < 705 && giy > 220 && giy < 350) {
                        highlight = 1;
                        menu.labelmenupanel.infoLabel.setText("Zamek|L:"+menu.buildingResources.castle.level+" W:"+menu.buildingResources.castle.woodcost+" S:"+menu.buildingResources.castle.stonecost+" G:"+menu.buildingResources.castle.goldcost);
                    }
                    else if (gix > 270 && gix < 420 && giy > 230 && giy < 360){
                        highlight = 2;
                        menu.labelmenupanel.infoLabel.setText("Tartak|L:"+menu.buildingResources.sawmill.level+" W:"+menu.buildingResources.sawmill.woodcost+" S:"+menu.buildingResources.sawmill.stonecost+" G:"+menu.buildingResources.sawmill.goldcost);
                    }
                    else if (gix > 750 && gix < 930 && giy > 100 && giy < 230){
                        highlight = 3;
                        menu.labelmenupanel.infoLabel.setText("Kamieniołom|L:"+menu.buildingResources.stonemine.level+" W:"+menu.buildingResources.stonemine.woodcost+" S:"+menu.buildingResources.stonemine.stonecost+" G:"+menu.buildingResources.stonemine.goldcost);
                    }
                    else if (gix > 830 && gix < 1020 && giy > 360 && giy < 500){
                        highlight = 4;
                        menu.labelmenupanel.infoLabel.setText("Kopalnia złota|L:"+menu.buildingResources.goldmine.level+" W:"+menu.buildingResources.goldmine.woodcost+" S:"+menu.buildingResources.goldmine.stonecost+" G:"+menu.buildingResources.goldmine.goldcost);
                    }
                    else{
                        highlight = 0;
                        menu.labelmenupanel.infoLabel.setText("Nie wybrano");
                    }
                    repaint();
                }
            }
        });
    }

    void buttonStart() {
        this.menu.labelmenupanel.dateLabel.setVisible(true);
        this.menu.labelmenupanel.resourceLabel.setVisible(true);
        this.menu.labelmenupanel.eventLabel.setVisible(true);
        this.menu.labelmenupanel.infoLabel.setVisible(true);
        this.show_buttons = false;
        this.repaint();
        this.menu.menupanel.repaint();
    }
    
    void buttonSettings() {
        
    }
    
    void buttonExit() {
        System.exit(0);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //g2.setColor(new Color(212, 217,219));               //kolor panelu
        //g2.fillRect(0, 0, this.x, this.y);                     //kolorowanie panelu po włączeniu
        if(this.show_buttons == true){
            g2.drawImage(this.map_blur, 0, 0, null);     //wyblurowane tło gry po włączeniu gry/kliknięciu przycisku menu
            g2.drawImage(logo, x/4, y/24, null);              //logo gry na ekranie startowym
            g2.drawImage(this.button_start, (int)xpos, (int)(ypos+b1yrel), null);     //przycisk start
            g2.drawImage(this.button_settings, (int)xpos, (int)(ypos+b2yrel), null);  //przycisk settings
            g2.drawImage(this.button_exit, (int)xpos, (int)(ypos+b3yrel), null);      //przycisk exit
        } else if(this.show_buttons == false){
            g2.drawImage(this.background, 0, 0, null);   //tło gry po kliknięciu start
            g2.setStroke(new BasicStroke(3));
            if (this.highlight == 1) {//zamek = 1
                g2.drawLine(525, 220, 705, 220);
                g2.drawLine(525, 220, 525, 350);
                g2.drawLine(705, 220, 705, 350);
                g2.drawLine(525, 350, 705, 350);         
            } if (this.highlight == 2) {//tartak = 2
                g2.drawLine(270, 230, 420, 230);
                g2.drawLine(270, 230, 270, 360);
                g2.drawLine(420, 230, 420, 360);
                g2.drawLine(270, 360, 420, 360);
            } if (this.highlight == 3) {//kopalnia = 3
                g2.drawLine(750, 100, 930, 100);
                g2.drawLine(750, 100, 750, 230);
                g2.drawLine(930, 100, 930, 230);
                g2.drawLine(750, 230, 930, 230);
            } if (this.highlight == 4) {//złoto = 4
                g2.drawLine(830, 360, 830, 500);
                g2.drawLine(830, 500, 1020, 500);
                g2.drawLine(830, 360, 1020, 360);
                g2.drawLine(1020, 360, 1020, 500);
            }
        }
    }
}
