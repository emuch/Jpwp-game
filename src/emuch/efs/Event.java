package emuch.efs;

abstract class Event {
    double probability;
    Menu menu;
    Event (Menu menu) {
        this.menu = menu;
    }
    abstract boolean check_conditions();
    abstract void run();
}
