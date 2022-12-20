package emuch.efs;

class BuildingResources {
    int wood;
    int stone;
    int gold;
    int woodGain;
    int stoneGain;
    int goldGain;
    MapObject castle;
    MapObject sawmill;
    MapObject stonemine;
    MapObject goldmine;
    Menu menu;

    BuildingResources(Menu menu) throws Exception {
        this.menu = menu;
        switch(menu.difficulty){
            case 0:              //easy
                wood = 150;
                stone = 150;
                gold = 150;
                woodGain = 15;
                stoneGain = 15;
                goldGain = 15;
                break;
            case 1:              //normal
                wood = 100;
                stone = 100;
                gold = 100;
                woodGain = 10;
                stoneGain = 10;
                goldGain = 10;
                break;
            case 2:              //hard
                wood = 50;
                stone = 50;
                gold = 50;
                woodGain = 5;
                stoneGain = 5;
                goldGain = 5;
                break;
            default:
                throw new Exception("Invalid difficulty");
        }
        this.menu.labelmenupanel.resourceLabel.setText("D: "+wood+"+"+woodGain+" S: "+stone+"+"+stoneGain+" G: "+gold+"+"+goldGain);
        castle = new Castle(menu);
        sawmill = new Sawmill(menu);
        stonemine = new Stonemine(menu);
        goldmine = new Goldmine(menu);
    }
}
