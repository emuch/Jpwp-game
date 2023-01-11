package emuch.efs;
/**
Parametry kopalni zlota
*/
class Goldmine extends MapObject{
    Goldmine(Menu menu) {
        
        super(menu);
        woodcost = 25;
        stonecost = 25;
        goldcost = 0;
        multiplier = 2;
    }
    @Override
    /**
    Parametry upgrade kopalni zlota
    */
    void upgrade() {
        level++;
        this.menu.buildingResources.wood-=woodcost;
        this.menu.buildingResources.stone-=stonecost;
        this.menu.buildingResources.goldGain+=level*multiplier;
        woodcost = woodcost * multiplier;
        stonecost = stonecost * multiplier;
    }
}