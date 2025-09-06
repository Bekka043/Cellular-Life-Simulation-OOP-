class HumanCell extends Character {

    public static int humanCellCount=0;

    public static int deadHumanCell=0;


    public void killedCount(){
        deadHumanCell+=1;
    }
    public HumanCell(int age, int hp) {
        super(age, hp, "Human Cell",1);
        humanCellCount+=1;

    }


}