package emuch.efs;
import java.util.ArrayList;

class Event_List {
    ArrayList<Event> list;
    Event_List(Menu menu) {
        list = new ArrayList<Event>();
        list.add(new Event1(menu));
        list.add(new Event1(menu));
    }
}
class Event1 extends Event{
    Event1(Menu menu) {
        super(menu);
        this.probability = 0.1;
    }
    @Override
    boolean check_conditions(){
        return true;
    }
    @Override
    void run(){
                
    }
}