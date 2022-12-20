package emuch.efs;

import javax.swing.JLabel;
import java.awt.Font;

class LabelMenuPanel extends JLabel{
    Menu menu;
    JLabel dateLabel;
    JLabel resourceLabel;
    JLabel eventLabel;
    JLabel infoLabel;
    int x;
    int y;

    LabelMenuPanel(Menu menu){
        this.menu = menu;
        this.x = menu.x;
        this.y = menu.y;
        this.dateLabel = new JLabel("Tura:1 Tydzień:1 1-1263");
        this.dateLabel.setLocation(0,0);                            //lokalizacja JLabela z turami
        this.dateLabel.setSize((int) (x*0.15),(int) (y*(0.05)));         //wielkość JLabela z turami
        this.dateLabel.setHorizontalAlignment(JLabel.CENTER);            //Centrowanie horyzontalne
        this.dateLabel.setVerticalAlignment(JLabel.CENTER);              //Centrowanie wertykalne
        //this.dateLabel.setFont(Font("Verdana"),Font.PLAIN, 14);

        this.resourceLabel = new JLabel();
        this.resourceLabel.setLocation((int) (x*0.15),0);                 //lokalizacja JLabela z zasobami
        this.resourceLabel.setSize((int) (x*0.15),(int) (y*(0.05)));         //wielkość JLabela z zasobami
        this.resourceLabel.setHorizontalAlignment(JLabel.CENTER);            //Centrowanie horyzontalne
        this.resourceLabel.setVerticalAlignment(JLabel.CENTER);              //Centrowanie wertykalne
        
        this.eventLabel = new JLabel("Brak wydarzeń");
        this.eventLabel.setLocation((int) (x*0.15)*2,0);                //lokalizacja JLabela z eventami
        this.eventLabel.setSize((int) (x*0.2),(int) (y*(0.05)));          //wielkość JLabela z ventami
        this.eventLabel.setHorizontalAlignment(JLabel.CENTER);            //Centrowanie horyzontalne
        this.eventLabel.setVerticalAlignment(JLabel.CENTER);              //Centrowanie wertykalne

        this.infoLabel = new JLabel("Brak wyboru");
        this.infoLabel.setLocation((int) ((x*0.2)+(x*0.15)*2),0);     //lokalizacja JLabela z eventami
        this.infoLabel.setSize((int) (x*0.2),(int) (y*(0.05)));          //wielkość JLabela z ventami
        this.infoLabel.setHorizontalAlignment(JLabel.CENTER);            //Centrowanie horyzontalne
        this.infoLabel.setVerticalAlignment(JLabel.CENTER);              //Centrowanie wertykalne
        
        this.setLayout(null);
        this.add(this.dateLabel);
        this.add(this.resourceLabel);
        this.add(this.eventLabel);
        this.add(this.infoLabel);
        this.dateLabel.setVisible(false);
        this.resourceLabel.setVisible(false);
        this.eventLabel.setVisible(false);
        this.infoLabel.setVisible(false);
    }
}
