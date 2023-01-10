package emuch.efs;

abstract class Event {
    Menu menu;
    boolean loud;
    Event (Menu menu) {
        this.menu = menu;
    }
    abstract boolean check_conditions();
    abstract void run();
}