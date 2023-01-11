package emuch.efs;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
Lista eventow dostepnych w grze
*/
class Event_List {
    ArrayList<Event> list;
    Event_List(Menu menu) {
        list = new ArrayList<Event>();  //od najmniejszego do największego prawdopodobieństwa  //najpierw ciche eventy a potem głośne od najmniejszego
        list.add(new NewResources(menu)); //dodawanie zasobów
        list.add(new ThiefOnStreets(menu));//0.05
        list.add(new Epidemic(menu));//0.05 , 8 week
        list.add(new RiversFlooded(menu));//0.1, 16 week
        list.add(new StrikeSawmill(menu));//0.1
        list.add(new StrikeStonemine(menu));//0.1
        list.add(new StrikeGoldmine(menu));//0.1
        list.add(new DeadOxMine(menu));//0.1 , 2 week
        list.add(new BanditsStonemine(menu));//0.2 12 week
        list.add(new SawmillSaw(menu));//0.2
        list.add(new ThiefsInMagazine(menu));//0.2 , 3 week
        list.add(new BurningForest(menu));//0.3
        list.add(new DrainedStoneMine(menu));//0.3
        list.add(new GoldMineCollapse(menu));//0.3
    }
}

/**
Poczatkowy przychod zasobow co ture
*/
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

/**
Event: Las plonie!
 */
class BurningForest extends Event{   //głośny event
    BurningForest(Menu menu) {
        super(menu);
        this.loud = true;
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

/**
Event: Zawalenie kopalni zlota!
 */
class GoldMineCollapse extends Event{   //głośny event
    GoldMineCollapse(Menu menu) {
        super(menu);
        this.loud = true;
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

/**
Event: Wyczerpanie kamieniolomu.
 */
class DrainedStoneMine extends Event{   //głośny event
    DrainedStoneMine(Menu menu) {
        super(menu);
        this.loud = true;
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

/**
Event: Zepsute pily.
 */
class SawmillSaw extends Event{   //głośny event
    SawmillSaw(Menu menu) {
        super(menu);
        this.loud = true;
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
        JOptionPane.showMessageDialog(okno, "Piły, z których korzystaliśmy do tej pory w tartaku, nie tną już tak jak dawniej,\n chyba nadeszła pora wymiany na nowe, to spowoduje przestoje w pracy.\n Tracisz 10 drewna.", "Zepsute piły.", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
Event: Umierajace bawoly.
 */
class DeadOxMine extends Event{   //głośny event
    DeadOxMine(Menu menu) {
        super(menu);
        this.loud = true;
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

/**
Event: Epidemia!
 */
class Epidemic extends Event{   //głośny event
    Epidemic(Menu menu) {
        super(menu);
        this.loud = true;
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

/**
Event: Zlodzieje w magazynie!
 */
class ThiefsInMagazine extends Event{   //głośny event
    ThiefsInMagazine(Menu menu) {
        super(menu);
        this.loud = true;
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.2 && this.menu.rcounter.returnWeek() > 3)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.wood-=30;
        this.menu.buildingResources.stone-=30;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Odkryliśmy, że z naszego magazynu zostały skradzione zasoby,\n to musiała być zorganizowana akcja,\n bo straciliśmy naprawdę dużo ciężkich materiałów.\n Tracisz 30 drewna i 30 kamienia.", "Złodzieje w magazynie!", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
Event: Kieszonkowcy grasuja wszedzie.
 */
class ThiefOnStreets extends Event{   //głośny event
    ThiefOnStreets(Menu menu) {
        super(menu);
        this.loud = true;
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.05)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.gold-=40;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Niedawno mieszkańcy zaczęli zgłaszać informacje o sporej ilości kradzieży na ulicach,\n jest to zapewne wina kieszonkowców czyhających na targach.\n Poddani mogą mieć przez to problem z płaceniem podatków,\n musimy zadbać o ich bezpieczeństwo albo zmniejszyć podatki.\n Tracisz 40 złota.", "Kieszonkowcy grasują wszędzie.", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
Event: Strajk w tartaku.
 */
class StrikeSawmill extends Event{   //głośny event
    StrikeSawmill(Menu menu) {
        super(menu);
        this.loud = true;
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.1)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.wood-=10;
        this.menu.buildingResources.gold-=10;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Ludzie są oburzeni panującymi w tartaku\n warunkami pracy, uważają to za wyzysk.\n Spowoduje to przestoje w produkcji, musimy podnieść\n im pensje, żeby zapobiec dalszym strajkom.\n Tracisz 10 drewna i 10 złota.", "Strajk w tartaku.", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
Event: Strajk w kamieniolomie.
 */
class StrikeStonemine extends Event{   //głośny event
    StrikeStonemine(Menu menu) {
        super(menu);
        this.loud = true;
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.1)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.stone-=10;
        this.menu.buildingResources.gold-=10;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Ludzie są oburzeni panującymi w kamieniołomie\n warunkami, uważają to za niehumanitarne.\n Spowoduje to przestoje w produkcji, musimy podnieść\n im pensje, żeby zapobiec dalszym strajkom.\n Tracisz 10 kamienia i 10 złota.", "Strajk w kamieniołomie.", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
Event: Strajk w kopalni zlota.
 */
class StrikeGoldmine extends Event{   //głośny event
    StrikeGoldmine(Menu menu) {
        super(menu);
        this.loud = true;
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.1)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.gold-=20;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Ludzie są oburzeni panującymi w kopalni złota\n warunkami pracy, uważają to za wyzysk.\n Spowoduje to przestoje w wydobyciu, musimy podnieść\n im pensje, żeby zapobiec dalszym strajkom.\n Tracisz 20 złota.", "Strajk w kopalni złota.", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
Event: Bandyci z pobliskich gor.
 */
class BanditsStonemine extends Event{   //głośny event
    BanditsStonemine(Menu menu) {
        super(menu);
        this.loud = true;
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.2 && this.menu.rcounter.returnWeek() > 12)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.stone-=30;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Na nasze tereny z pobliskich gór przybyli bandyci i zajęli kamieniołom, będziemy musieli go odbić albo poszukać nowego złoża. Tracisz 30 kamienia.", "Bandyci z pobliskich gór.", JOptionPane.INFORMATION_MESSAGE);
    }
}

/**
Event: Obifte opady.
 */
class RiversFlooded extends Event{   //głośny event
    RiversFlooded(Menu menu) {
        super(menu);
        this.loud = true;
    }
    @Override
    boolean check_conditions(){
        if(Math.random() < 0.1 && this.menu.rcounter.returnWeek() > 16)
            return true;
        return false;
    }
    @Override
    void run(){//ilość zasobów
        this.menu.buildingResources.wood-=40;
        this.menu.buildingResources.stone-=40;
        JFrame okno = new JFrame();
        JOptionPane.showMessageDialog(okno, "Ostatnie obfite opady deszczu spowodowały\n wylew rzek zarówno tych w lasach, jak i górach.\n Cały kamieniołom został zalany, a tartak nie ma dostępu do materiałów. Musimy poczekać na suszę albo liczyć na ciepłe słońce.\n Tracisz 40 drewna i 40 kamienia.", "Obifte opady.", JOptionPane.INFORMATION_MESSAGE);
    }
}