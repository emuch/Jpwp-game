package emuch.efs;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
Zdefiniowanie labelow uzywanych do wyswietlania zasobow, daty, informacji o wybranym budynku
*/
class LabelMenuPanel extends JLabel{
    Menu menu;
    JLabel dateLabel;
    JLabel resourceLabelwood;
    JLabel resourceLabelgold;
    JLabel resourceLabelstone;
    //JLabel eventLabel;
    JLabel infoLabel;
    int x;
    int y;
    Image wood_icon;
    Image stone_icon;
    Image gold_icon;
    
    LabelMenuPanel(Menu menu){
        this.menu = menu;
        this.x = menu.x;
        this.y = menu.y;
        ImageIcon wood_icon = new ImageIcon(this.menu.imagepath + "/wood_36x36.png");
        this.wood_icon = wood_icon.getImage();
        ImageIcon stone_icon = new ImageIcon(this.menu.imagepath + "/stone_36x36.png");
        this.stone_icon = stone_icon.getImage();
        ImageIcon gold_icon = new ImageIcon(this.menu.imagepath + "/gold_36x36.png");
        this.gold_icon = gold_icon.getImage();

        this.dateLabel = new JLabel("Tura: 1 Tydzień: 1 1-1263");
        this.dateLabel.setLocation(0,0);                            //lokalizacja JLabela z turami
        this.dateLabel.setSize((int) (x*0.15),(int) (y*(0.05)));         //wielkość JLabela z turami
        this.dateLabel.setHorizontalAlignment(JLabel.CENTER);            //Centrowanie horyzontalne
        this.dateLabel.setVerticalAlignment(JLabel.CENTER);              //Centrowanie wertykalne
        this.dateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        this.resourceLabelwood = new JLabel();
        this.resourceLabelwood.setLocation((int) (x*0.15),0);                 //lokalizacja JLabela z zasobami drewna
        this.resourceLabelwood.setSize((int) (x*0.10),(int) (y*(0.05)));         //wielkość JLabela z zasobami drewna
        this.resourceLabelwood.setHorizontalAlignment(JLabel.CENTER);            //Centrowanie horyzontalne
        this.resourceLabelwood.setVerticalAlignment(JLabel.CENTER);              //Centrowanie wertykalne
        this.resourceLabelwood.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        this.resourceLabelwood.setIcon(wood_icon);
        this.resourceLabelwood.setOpaque(true);
        this.resourceLabelwood.setBackground(new Color(115, 77, 42));   
        
        this.resourceLabelstone = new JLabel();
        this.resourceLabelstone.setLocation((int) (x*0.25),0);                 //lokalizacja JLabela z zasobami drewna
        this.resourceLabelstone.setSize((int) (x*0.10),(int) (y*(0.05)));         //wielkość JLabela z zasobami drewna
        this.resourceLabelstone.setHorizontalAlignment(JLabel.CENTER);            //Centrowanie horyzontalne
        this.resourceLabelstone.setVerticalAlignment(JLabel.CENTER);              //Centrowanie wertykalne
        this.resourceLabelstone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        this.resourceLabelstone.setIcon(stone_icon);
        this.resourceLabelstone.setOpaque(true);
        this.resourceLabelstone.setBackground(new Color(122, 122, 122));  
        
        this.resourceLabelgold = new JLabel();
        this.resourceLabelgold.setLocation((int) (x*0.35),0);                 //lokalizacja JLabela z zasobami drewna
        this.resourceLabelgold.setSize((int) (x*0.10),(int) (y*(0.05)));         //wielkość JLabela z zasobami drewna
        this.resourceLabelgold.setHorizontalAlignment(JLabel.CENTER);            //Centrowanie horyzontalne
        this.resourceLabelgold.setVerticalAlignment(JLabel.CENTER);              //Centrowanie wertykalne
        this.resourceLabelgold.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        this.resourceLabelgold.setIcon(gold_icon);
        this.resourceLabelgold.setOpaque(true);
        this.resourceLabelgold.setBackground(new Color(209, 216, 7));  
        
        //this.eventLabel = new JLabel("Brak wydarzeń");
        //this.eventLabel.setLocation((int) (x*0.15)*2,0);                //lokalizacja JLabela z eventami
        //this.eventLabel.setSize((int) (x*0.2),(int) (y*(0.05)));          //wielkość JLabela z eventami
        //this.eventLabel.setHorizontalAlignment(JLabel.CENTER);            //Centrowanie horyzontalne
        //this.eventLabel.setVerticalAlignment(JLabel.CENTER);              //Centrowanie wertykalne

        this.infoLabel = new JLabel("Brak wyboru");
        this.infoLabel.setLocation((int) ((x*0.15)+(x*0.10)*3),0);     //lokalizacja JLabela z budynkami
        this.infoLabel.setSize((int) (x*0.25),(int) (y*(0.05)));          //wielkość JLabela z budynkami
        this.infoLabel.setHorizontalAlignment(JLabel.CENTER);            //Centrowanie horyzontalne
        this.infoLabel.setVerticalAlignment(JLabel.CENTER);              //Centrowanie wertykalne
        
        this.setLayout(null);
        this.add(this.dateLabel);
        this.add(this.resourceLabelwood);
        this.add(this.resourceLabelstone);
        this.add(this.resourceLabelgold);
        //this.add(this.eventLabel);
        this.add(this.infoLabel);
        this.dateLabel.setVisible(false);
        this.resourceLabelwood.setVisible(false);
        this.resourceLabelgold.setVisible(false);
        this.resourceLabelstone.setVisible(false);
        //this.eventLabel.setVisible(false);
        this.infoLabel.setVisible(false);
    }
}
