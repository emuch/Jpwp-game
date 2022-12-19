package emuch.efs;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    Image map_blur;
    Image logo;
    Image background;
    Image button_start;
    Image button_settings;
    Image button_exit;

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
        
        ImageIcon map_blur = new ImageIcon(/*menu.indirectPathimages + */"C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/map_blur.png");
        this.map_blur = map_blur.getImage();
        ImageIcon logo = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/logo.png");
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
                if (show_buttons==true && gix > xpos && gix < xpos+dx) {
                    if (giy > ypos+b1yrel && giy < ypos+b1yrel+dy) {
                        buttonStart();
                    } else if (giy > ypos+b2yrel && giy < ypos+b2yrel+dy) {
                        buttonSettings();
                    } else if (giy > ypos+b3yrel && giy < ypos+b3yrel+dy) {
                        buttonExit();
                    }
                }
            }
        });
    }

    void buttonStart() {
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
        g2.setColor(new Color(212, 217,219));               //kolor panelu
        g2.fillRect(0, 0, this.x,(int) this.y);       
        if(this.show_buttons == true){
        g2.drawImage(this.map_blur, 0, 0, null);     //wyblurowane tło gry po włączeniu gry/kliknięciu przycisku menu
        g2.drawImage(logo, 320, 30, null);           //logo gry na ekranie startowym
        g2.drawImage(this.button_start, (int)xpos, (int)(ypos+b1yrel), null);     //przycisk start
        g2.drawImage(this.button_settings, (int)xpos, (int)(ypos+b2yrel), null);  //przycisk settings
        g2.drawImage(this.button_exit, (int)xpos, (int)(ypos+b3yrel), null);      //przycisk exit
        } else if(this.show_buttons == false){
        g2.drawImage(this.background, 0, 0, null);   //tło gry po kliknięciu start
        }
    }
}
