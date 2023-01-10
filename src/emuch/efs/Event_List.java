package emuch.efs;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Event_List {
    ArrayList<Event> list;
    Event_List(Menu menu) {
        list = new ArrayList<Event>();  //od najmniejszego do największego prawdopodobieństwa  //najpierw ciche eventy a potem głośne od najmniejszego
        list.add(new NewResources(menu)); //dodawanie zasobów
        list.add(new Epidemic(menu));//0.05
        list.add(new DeadOxMine(menu));//0.1
        list.add(new SawmillSaw(menu));//0.2
        list.add(new BurningForest(menu));//0.3
        list.add(new DrainedStoneMine(menu));//0.3
        list.add(new GoldMineCollapse(menu));//0.3
        //list.add(new (menu));
        //list.add(new (menu));
        //list.add(new (menu));
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
        if(Math.random() < 0.3/*&& this.menu.rcounter.returnWeek() > 4*/)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.wood-=10;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Niedaleko tartaku, w okolicznych lasach wybuchł pożar,\n to wpłynie na nasze zasoby w najbliższej przyszłości.\n Tracisz 10 drewna.", "Las płonie!", JOptionPane.INFORMATION_MESSAGE);
    }
}

class GoldMineCollapse extends Event{   //głośny event
    GoldMineCollapse(Menu menu) {
        super(menu);
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.3)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.gold-=20;
        this.menu.buildingResources.wood-=10;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Zawaliła się jedna z naszych kopalnia złota! Jest kilku poszkodowanych.\n Najpewniej przyczyną zawalenia była niestabilna belka podtrzymująca strop.\n Naprawy będą wymagały sporej ilości zasobów do przygotowania nowych belek i odkopania zawaleniska.\n Tracisz 20 złota i 10 drewna.", "Zawalenie kopalni złota!", JOptionPane.INFORMATION_MESSAGE);
    }
}

class DrainedStoneMine extends Event{   //głośny event
    DrainedStoneMine(Menu menu) {
        super(menu);
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.3)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.stone-=20;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Kamieniołom w pobliskich górach się wyczerpał. Będziemy musieli poświęcić trochę\n czasu na znalezienie nowego łatwo dostępnego źródła tego zasobu.\n Tracisz 20 kamienia.", "Wyczerpanie kamieniołomu.", JOptionPane.INFORMATION_MESSAGE);
    }
}

class SawmillSaw extends Event{   //głośny event
    SawmillSaw(Menu menu) {
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
        this.menu.buildingResources.wood-=10;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Piły, z których korzystaliśmy do tej pory w tartaku, nie tną już tak jak dawniej,\n chyba nadeszła pora wymiany na nowe, to spowoduje przestoje w pracy.\n Tracisz 10 drewna.", "Zepsuta piły.", JOptionPane.INFORMATION_MESSAGE);
    }
}

class DeadOxMine extends Event{   //głośny event
    DeadOxMine(Menu menu) {
        super(menu);
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.1 && this.menu.rcounter.returnWeek() > 2)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.stone-=20;
        this.menu.buildingResources.stoneGain-=5;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "W wyniku ostatnich dostaw nasze bawoły bardzo\n ucierpiały w wyniku tego niektóre zmarły,\n będzie wymagane ustalenie czasu odpoczynku,\n co zmniejszy ilość zaopatrzenia naszego zamku w kamień.\n Tracisz 20 kamienia i 5 przyrostu kamienia.", "Umierające bawoły.", JOptionPane.INFORMATION_MESSAGE);
    }
}

class Epidemic extends Event{   //głośny event
    Epidemic(Menu menu) {
        super(menu);
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.05 && this.menu.rcounter.returnWeek() > 8)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.wood-=20;
        this.menu.buildingResources.stone-=20;
        this.menu.buildingResources.gold-=40;
        this.menu.buildingResources.woodGain-=10;
        this.menu.buildingResources.stoneGain-=10;
        this.menu.buildingResources.goldGain-=10;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "W naszym zamku wybuchła epidemia będzie to miało znaczne skutki i wpływ na dostawy.\n Przede wszystkim musimy zadbać o lekarzy i leczenie populacji, a to będzie kosztowne.\n Musimy być również świadomi problemu z brakiem ludzi do pracy i w konsekwencji strat na rzecz zasobów.\n Tracisz 40 złota, 20 drewna, 20 kamienia i po 10 przyrostu każdego z zasobów.", "Epidemia!", JOptionPane.INFORMATION_MESSAGE);
    }
}