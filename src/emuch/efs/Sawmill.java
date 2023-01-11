package emuch.efs;
/**
Parametry tartaku
*/
class Sawmill extends MapObject{
    Sawmill(Menu menu) {
        super(menu);
        woodcost = 0;
        stonecost = 25;
        goldcost = 25;
        multiplier = 2;
    }
    @Override
    /**
    Parametry upgrade tartaku
    */
    void upgrade() {
        level++;
        this.menu.buildingResources.stone-=stonecost;
        this.menu.buildingResources.gold-=goldcost;
        this.menu.buildingResources.woodGain+=level*multiplier;
        stonecost = stonecost * multiplier;
        goldcost = goldcost * multiplier;
    }
}