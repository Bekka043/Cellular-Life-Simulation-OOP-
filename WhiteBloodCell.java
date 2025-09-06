class WhiteBloodCell extends Character {

    public static int whiteBloodCellCount=0;
    public static int deadWbs=0;


    public void killedCount(){
        deadWbs+=1;
    }

    public WhiteBloodCell(int age, int hp) {
        super(age, hp, "White Blood Cell",0);
        whiteBloodCellCount +=1;

    }


    //public int getTypeIndex() {
    //    return 0; // Assuming White Blood Cell is index 0 in the Relationships grid
    //}
}