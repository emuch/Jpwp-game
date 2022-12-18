package emuch.efs;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

class MenuPanel extends JPanel{
    Menu menu;
    int x;
    int y;
    double xm;
    double ym;
    double xt;
    double dx;
    double dy;

    Image button_menu;
    Image button_turn;
    JLabel infoLabel;  //tura
    
    MenuPanel(Menu menu) {
        this.menu = menu;
        this.x = menu.x;         //rozmiar x górnego panelu
        this.y = menu.y;         //rozmiar y górnego panelu
        this.xm = 0.9*x;         //pozycja x przycisku panelu od lewej (1152)
        this.ym = 0;             //pozycja y przycisku panelu od góry (0)
        this.xt = 0.8*x;         //pozycja x przucisku tury (TO DO liczba)
        this.dx = x*(0.1);       //rozmiar 2*x przycisku panelu
        this.dy = y*(0.05);      //rozmiar y przycisku panelu
        this.setLayout(null);
        this.infoLabel = new JLabel("Tura:1 Tydzień:1 1-1263");
        this.infoLabel.setLocation(0,0);            //lokalizacja Jlabela z turami
        this.infoLabel.setSize((int) dx,(int) dy);
        this.add(this.infoLabel);
        
        ImageIcon button_menu = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images/button_menu.png");
        this.button_menu = button_menu.getImage();
        ImageIcon button_turn = new ImageIcon("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/images alpha/turn.png");
        this.button_turn = button_turn.getImage();
        
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double gix = (double)e.getX();
                double giy = (double)e.getY();
                if (menu.gameinterface.show_buttons==false){
                    if (gix > xm && gix < xm+dx && giy > ym && giy < ym+dy) {
                        System.out.println(1);
                        buttonMenu();
                    }
                    if (gix > xt && gix < xt+dx && giy > ym && giy < ym+dy) {
                        System.out.println(2);
                        buttonTurn();
                    }
                }
            }
        });
        this.setVisible(true);
    }
    
    void buttonMenu() {
        this.menu.gameinterface.show_buttons = true;
        this.repaint();
        this.menu.gameinterface.repaint();
    }

    void buttonTurn() {
        this.menu.rcounter.advance();
        this.infoLabel.setText("Tura: " + Integer.toString(this.menu.rcounter.returnTurn()) + " tydzień: " + Integer.toString(this.menu.rcounter.returnWeek()) + " " + Integer.toString(this.menu.rcounter.returnMonth()) + "-" + Integer.toString(this.menu.rcounter.returnYear()));
    }

    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if(this.menu.gameinterface.show_buttons == false){
            g2.setColor(new Color(212, 217,219));                   //kolor panelu
            g2.fillRect(110, 0, this.x,(int) this.y);                        //kolorowanie panelu po kliknięciu start
            g2.drawImage(this.button_menu, (int)xm, 0, null);  //przycisk menu
            g2.drawImage(this.button_turn,(int) xt,0, null);
         }else if(this.menu.gameinterface.show_buttons == true){
            g2.setColor(new Color(212, 217,219));                   //kolor panelu
            g2.fillRect(110, 0, this.x,(int) this.y);                         //kolorowanie panelu dla włączenia gry
         }
    }
}