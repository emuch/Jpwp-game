package emuch.efs;
/**
Koszty konkretnych budynkow
*/
abstract class MapObject {
    int level;
    int woodcost;
    int stonecost;
    int goldcost;
    int multiplier;
    Menu menu;
    /**
    Zdefiniowane poziomy budynkow
    */
    MapObject(Menu menu) {
        
        level = 1;
        this.menu = menu;
    }

    abstract void upgrade();
}
