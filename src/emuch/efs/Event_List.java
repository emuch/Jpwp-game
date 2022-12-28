package emuch.efs;
import java.util.ArrayList;

class Event_List {
    ArrayList<Event> list;
    Event_List(Menu menu) {
        list = new ArrayList<Event>();  //od najmniejszego do największego prawdopodobieństwa  //najpierw ciche eventy a potem głośne od najmniejszego
        list.add(new NewResources(menu)); //dodawanie zasobów
        list.add(new BurningForest(menu));//0.1
        list.add(new DrainedStoneMine(menu));//0.1
        list.add(new GoldMineCollapse(menu));//0.2
    }
}
class NewResources extends Event{
    NewResources(Menu menu) {
        super(menu);
    }
    @Override
    boolean check_conditions(){
        return true;
    }
    @Override
    void run(){//ilość zasobów bazowych na początku tury
        this.menu.buildingResources.wood+=this.menu.buildingResources.woodGain;
        this.menu.buildingResources.stone+=this.menu.buildingResources.stoneGain;
        this.menu.buildingResources.gold+=this.menu.buildingResources.goldGain;
    }
}

class BurningForest extends Event{   //głośny event
    BurningForest(Menu menu) {
        super(menu);
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.1/*&& this.menu.rcounter.returnWeek() > 4*/)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.wood-=30;
        this.menu.labelmenupanel.eventLabel.setText("Wybuchł pożar lasu, tracisz 30 drewna."); //zmiana labela
    }
}

class GoldMineCollapse extends Event{   //głośny event
    GoldMineCollapse(Menu menu) {
        super(menu);
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.2)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.gold-=30;
        this.menu.labelmenupanel.eventLabel.setText("Zawaliła się kopalnia złota! Tracisz 30 złota."); //zmiana labela
    }
}

class DrainedStoneMine extends Event{   //głośny event
    DrainedStoneMine(Menu menu) {
        super(menu);
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.1)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.stone-=30;
        this.menu.labelmenupanel.eventLabel.setText("Kamieniołom się wyczerpał, tracisz 30 kamienia."); //zmiana labela
    }
}