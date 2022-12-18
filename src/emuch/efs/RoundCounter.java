package emuch.efs;

class RoundCounter {
    Menu menu;
    Event_List elist;
    int time = 0;
    RoundCounter(Menu menu) {
        this.menu = menu;
        this.elist = new Event_List(menu);
    }
    void advance() {
        this.time++;
        this.check_events();
    }
    private void check_events() {
        for (Event event : this.elist.list) {
            if (event.check_conditions()) {
                event.run();
            };
        }
    }
    int returnTurn() {
        return this.time+1;
    }
    int returnWeek() {
        return this.time%4+1;
    }
    int returnMonth() {
        return (int)Math.floor(this.time/4)+1;
    }
    int returnYear() {
        return (int)Math.floor(this.time/(4*12))+1;
    }
}
