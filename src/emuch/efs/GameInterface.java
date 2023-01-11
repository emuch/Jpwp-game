package emuch.efs;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BasicStroke;

/**
Zmienne i wlasciwosci okna gry
*/
class GameInterface extends JPanel {
    MenuPanel menupanel;
    Menu menu;
    int highlight;
    int x;
    int y;
    double b1yrel;
    double b2yrel;
    double b3yrel;
    double b4yrel;
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
    Image button_easy;
    Image button_normal;
    Image button_hard;
    Image button_back;

    boolean show_buttons;
    boolean show_settings;

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
        this.b4yrel = -(dy)/2+(dy)*4;    //Guzik trzeci w osi y
        this.xpos = (this.x-this.dx)/2;  //Pozycja guzika w x od lewej krawędzi (512)
        this.ypos = (this.y-this.dy)/2;  //Pozycja guzika w y od góry (342)
        this.show_buttons = true;        //widoczność przycisków głównego menu
        this.show_settings = false;      //widoczność przycisków settings
        
        ImageIcon map_blur = new ImageIcon(this.menu.imagepath + "/map_blur.png");
        this.map_blur = map_blur.getImage();
        ImageIcon logo = new ImageIcon(this.menu.imagepath + "/logo.png");
        this.logo = logo.getImage();
        ImageIcon button_start = new ImageIcon(this.menu.imagepath + "/button_start.png");
        this.button_start = button_start.getImage();
        ImageIcon button_settings = new ImageIcon(this.menu.imagepath + "/button_settings.png");
        this.button_settings = button_settings.getImage();
        ImageIcon button_exit = new ImageIcon(this.menu.imagepath + "/button_exit.png");
        this.button_exit = button_exit.getImage();
        ImageIcon background = new ImageIcon(this.menu.imagepath + "/map.png");
        this.background = background.getImage();
        ImageIcon button_easy = new ImageIcon(this.menu.imagepath + "/button_easy.png");
        this.button_easy = button_easy.getImage();
        ImageIcon button_normal = new ImageIcon(this.menu.imagepath + "/button_normal.png");
        this.button_normal = button_normal.getImage();
        ImageIcon button_hard = new ImageIcon(this.menu.imagepath + "/button_hard.png");
        this.button_hard = button_hard.getImage();
        ImageIcon button_back = new ImageIcon(this.menu.imagepath + "/button_back.png");
        this.button_back = button_back.getImage();

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double gix = (double)e.getX();
                double giy = (double)e.getY();
                //System.out.println(gix);   //pozycja kursora x
                //System.out.println(giy);   //pozycja kursora y
                if (show_buttons==true && show_settings == false && gix > xpos && gix < xpos+dx) {
                    if (giy > ypos+b1yrel && giy < ypos+b1yrel+dy) {
                        buttonStart();
                    } else if (giy > ypos+b2yrel && giy < ypos+b2yrel+dy) {
                        buttonSettings();
                    } else if (giy > ypos+b3yrel && giy < ypos+b3yrel+dy) {
                        buttonExit();
                    }
                } else if (show_buttons==true && show_settings == true && gix > xpos && gix < xpos+dx) { //wybór poziomu trudności z menu
                    if (giy > ypos+b1yrel && giy < ypos+b1yrel+dy) { //easy
                        menu.difficulty = 0;
                        menu.setGame();
                        //System.out.println(menu.difficulty);
                    } else if (giy > ypos+b2yrel && giy < ypos+b2yrel+dy) { //normal
                        menu.difficulty = 1;
                        menu.setGame();
                        //System.out.println(menu.difficulty);
                    } else if (giy > ypos+b3yrel && giy < ypos+b3yrel+dy) { //hard
                        menu.difficulty = 2;
                        menu.setGame();
                        //System.out.println(menu.difficulty);
                    }else if (giy > ypos+b4yrel && giy < ypos+b4yrel+dy) { //powrót
                        buttonBack();
                    }
                }else if (show_buttons==false && show_settings == false) {//zaznaczenie konkretnego budynku
                    if (gix > 525 && gix < 705 && giy > 220 && giy < 350) {//Zamek
                        highlight = 1;
                        menu.labelmenupanel.infoLabel.setText("Zamek | Level: "+menu.buildingResources.castle.level+" Wood: "+menu.buildingResources.castle.woodcost+" Stone: "+menu.buildingResources.castle.stonecost+" Gold: "+menu.buildingResources.castle.goldcost);
                    }
                    else if (gix > 270 && gix < 420 && giy > 230 && giy < 360){//Tartak
                        highlight = 2;
                        menu.labelmenupanel.infoLabel.setText("Tartak | Level: "+menu.buildingResources.sawmill.level+" Wood: "+menu.buildingResources.sawmill.woodcost+" Stone: "+menu.buildingResources.sawmill.stonecost+" Gold: "+menu.buildingResources.sawmill.goldcost);
                    }
                    else if (gix > 750 && gix < 930 && giy > 100 && giy < 230){//Kamieniołom
                        highlight = 3;
                        menu.labelmenupanel.infoLabel.setText("Kamieniołom | Level: "+menu.buildingResources.stonemine.level+" Wood: "+menu.buildingResources.stonemine.woodcost+" Stone: "+menu.buildingResources.stonemine.stonecost+" Gold: "+menu.buildingResources.stonemine.goldcost);
                    }
                    else if (gix > 830 && gix < 1020 && giy > 360 && giy < 500){//Kopalnia złota
                        highlight = 4;
                        menu.labelmenupanel.infoLabel.setText("Kopalnia złota | Level: "+menu.buildingResources.goldmine.level+" Wood: "+menu.buildingResources.goldmine.woodcost+" Stone: "+menu.buildingResources.goldmine.stonecost+" Gold: "+menu.buildingResources.goldmine.goldcost);
                    }
                    else{//brak wyboru
                        highlight = 0;
                        menu.labelmenupanel.infoLabel.setText("Nie wybrano");
                    }
                    repaint();
                }
            }
        });
    }

    /**
    Przycisk Start
    */
    void buttonStart() {
        this.menu.labelmenupanel.dateLabel.setVisible(true);
        this.menu.labelmenupanel.resourceLabelwood.setVisible(true);
        this.menu.labelmenupanel.resourceLabelstone.setVisible(true);
        this.menu.labelmenupanel.resourceLabelgold.setVisible(true);
        //this.menu.labelmenupanel.eventLabel.setVisible(true);
        this.menu.labelmenupanel.infoLabel.setVisible(true);
        this.show_buttons = false;
        this.repaint();
        this.menu.menupanel.repaint();
    }
    
    /**
    Przycisk Settings
    */
    void buttonSettings() {
        this.show_settings = true;
        this.repaint();
    }
    
    /**
    Przycisk Exit
    */
    void buttonExit() {
        System.exit(0);
    }
    
    /**
    Przycisk Back
    */
    void buttonBack(){
        this.show_settings = false;
        repaint();
    }

    
    /** 
     * @param g
     */
    /**
    Rysowanie dolnego panelu w zaleznosci od zmiennych
    */
    @Override
    public void paint(Graphics g) { 
        Graphics2D g2 = (Graphics2D) g;
        if (this.show_buttons == true && this.show_settings == true){
            g2.drawImage(this.map_blur, 0, 0, null);          //wyblurowane tło gry po włączeniu gry/kliknięciu przycisku menu
            g2.drawImage(this.logo, x/4, y/24, null);              //logo gry na ekranie startowym
            g2.drawImage(this.button_easy, (int)xpos, (int)(ypos+b1yrel), null);   //przycisk easy po settings
            g2.drawImage(this.button_normal, (int)xpos, (int)(ypos+b2yrel), null); //przycisk normal po settings
            g2.drawImage(this.button_hard, (int)xpos, (int)(ypos+b3yrel), null);   //przycisk hard po settings
            g2.drawImage(this.button_back, (int)xpos, (int)(ypos+b4yrel), null);   //przycisk powrotu
        }else if(this.show_buttons == true && this.show_settings == false){
            g2.drawImage(this.map_blur, 0, 0, null);          //wyblurowane tło gry po włączeniu gry/kliknięciu przycisku menu
            g2.drawImage(this.logo, x/4, y/24, null);              //logo gry na ekranie startowym
            g2.drawImage(this.button_start, (int)xpos, (int)(ypos+b1yrel), null);     //przycisk start
            g2.drawImage(this.button_settings, (int)xpos, (int)(ypos+b2yrel), null);  //przycisk settings
            g2.drawImage(this.button_exit, (int)xpos, (int)(ypos+b3yrel), null);      //przycisk exit
        }else if(this.show_buttons == false && this.show_settings == false){
            g2.drawImage(this.background, 0, 0, null);        //tło gry po kliknięciu start
            g2.setStroke(new BasicStroke(2));
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
