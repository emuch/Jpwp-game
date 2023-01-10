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
    }
    void check_events() {
        //this.menu.labelmenupanel.eventLabel.setText("Brak wydarzeń");
        boolean was_loud = false;
        for (Event event : this.elist.list) {
            if (event.loud && was_loud)
                break;
            if (event.check_conditions()) {
                event.run();
                was_loud = event.loud;
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
        return (int)Math.floor(1263+this.time/(4*12));
    }
}