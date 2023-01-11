package emuch.efs;
/**
Parametry kamieniolomu
*/
class Stonemine extends MapObject {
    Stonemine(Menu menu) {
        
        super(menu);
        woodcost = 25;
        stonecost = 0;
        goldcost = 25;
        multiplier = 2;
    }
    @Override
    /**
    Parametry upgrade kamieniolomu
    */
    void upgrade() {
        level++;
        this.menu.buildingResources.wood-=woodcost;
        this.menu.buildingResources.gold-=goldcost;
        this.menu.buildingResources.stoneGain+=level*multiplier;
        woodcost = woodcost * multiplier;
        goldcost = goldcost * multiplier;
    }
}