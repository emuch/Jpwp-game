package emuch.efs;

abstract class MapObject {
    int level;
    int woodcost;
    int stonecost;
    int goldcost;
    int multiplier;
    Menu menu;

    MapObject(Menu menu) {
        level = 1;
        this.menu = menu;
    }

    abstract void upgrade();
}
