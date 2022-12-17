package emuch.efs;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

class MenuPanel extends JPanel{
    Menu menu;
    int x;
    int y;
    double xm= 0.9*x;
    double ym= 0;
    double dx;
    double dy;
    Image button_start;
    Image button_settings;
    Image button_exit;
    
    MenuPanel(Menu menu) {
        this.menu = menu;
        this.x = menu.x;         //rozmiar x górnego panelu
        this.y = menu.y;         //rozmiar y górnego panelu
        this.xm = 0.9*x;         //pozycja x przycisku panelu od lewej (1152)
        this.ym = 0;             //pozycja y przycisku panelu od góry (0)
        this.dx = x*(0.2);       //rozmiar 2*x przycisku panelu
        this.dy = y*(0.05);      //rozmiar y przycisku panelu
    }
    void button_images(){
        ImageIcon button_start = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/button_start.PNG");
        this.button_start = button_start.getImage();
        ImageIcon button_settings = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/button_settings.PNG");
        this.button_settings = button_settings.getImage();
        ImageIcon button_exit = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/button_exit.PNG");
        this.button_exit = button_exit.getImage();
    }
    
    void buttonMenu() {
        this.menu.gameinterface.show_buttons = true;
        this.repaint();
        this.menu.gameinterface.repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        if(this.menu.gameinterface.show_buttons == false){
            g2.setColor(new Color(212, 217,219));                   //kolor panelu
            g2.fillRect(0, 0, menu.menupanel.x, menu.menupanel.y);     //kolorowanie panelu po kliknięciu start
            g2.drawImage(menu.gameinterface.button_menu, (int)xm, (int)ym, null);  //przycisk menu
         }else if(this.menu.gameinterface.show_buttons == true){
            g2.setColor(new Color(212, 217,219));                   //kolor panelu
            g2.fillRect(0, 0, menu.menupanel.x, menu.menupanel.y);     //kolorowanie panelu dla włączenia gry
         }
    }
}