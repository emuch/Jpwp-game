package emuch.efs;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

class GameInterface extends JPanel {
    MenuPanel menupanel;
    Menu menu;
    int x;
    int y;
    double b1yrel;
    double b2yrel;
    double b3yrel;
    double xpos;
    double ypos;
    double dx;
    double dy;
    Image background;
    Image button_menu;
    Image map_blur;
    Image logo;
    boolean show_buttons;

    GameInterface (Menu menu){
        this.menu = menu;
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
        
        ImageIcon map_blur = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/map_blur.PNG");
        this.map_blur = map_blur.getImage();
        ImageIcon logo = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/logo.PNG");
        this.logo = logo.getImage();
    }
    
    void background_game() {
        ImageIcon background = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/map.PNG");
        this.background = background.getImage();
        ImageIcon button_menu = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/button_menu.PNG");
        this.button_menu = button_menu.getImage();
    }

    void buttonStart() {
        this.show_buttons = false;
        this.background_game();
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
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(map_blur, 0, 0, null);     //wyblurowane tło gry po włączeniu gry/kliknięciu przycisku menu
        menu.menupanel.button_images();                        //wczytanie obrazów przycisków
        if(this.show_buttons == true){
        g2.drawImage(logo, 320, 30, null);      //logo gry na ekranie startowym
        g2.drawImage(menu.menupanel.button_start, (int)xpos, (int)(ypos+b1yrel), null);     //przycisk start
        g2.drawImage(menu.menupanel.button_settings, (int)xpos, (int)(ypos+b2yrel), null);  //przycisk settings
        g2.drawImage(menu.menupanel.button_exit, (int)xpos, (int)(ypos+b3yrel), null);      //przycisk exit
        } else if(this.show_buttons == false){
        g2.drawImage(menu.gameinterface.background, 0, 0, null);        //tło gry po kliknięciu start
        }
    }
}
