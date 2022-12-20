package emuch.efs;

class Castle extends MapObject {
    Castle(Menu menu) {
        super(menu);
        woodcost = 25;
        stonecost = 25;
        goldcost = 25;
        multiplier = 2;
    }
    @Override
    void upgrade() {
        level++;
        this.menu.buildingResources.wood-=woodcost;
        this.menu.buildingResources.stone-=stonecost;
        this.menu.buildingResources.gold-=goldcost;
        this.menu.buildingResources.woodGain+=level*multiplier;
        this.menu.buildingResources.stoneGain+=level*multiplier;
        this.menu.buildingResources.goldGain+=level*multiplier;
        woodcost = woodcost * multiplier;
        stonecost = stonecost * multiplier;
        goldcost = goldcost * multiplier;
    }
}
