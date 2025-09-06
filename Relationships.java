public class Relationships {
    public  static final int[][] grid = {
            // W  H  1  2  3
            // White Blood Cell, Human, Bacteria 1, Bacteria 2, Bacteria 3
            {0, -3, -3, -2, -3}, // White Blood Cell effects
            {0, 0, 2, 1, 1},    // Human effects
            {3, 2, 0, -1, 0},   // Bacteria 1 effects
            {2, 1, -1, 0, 0},   // Bacteria 2 effects
            {3, 1, 0, -3, 0},   // Bacteria 3 effects
    };
    public static int reversepolynomial(int x){
        return -(x*x-10*x)/5;
    }
    public static int powerCalculator(Character cell1 , Character cell2){
        //System.out.println( cell1.index +","+ cell2.index);
        //System.out.println(type_power(cell1.index, cell2.index));
        if (reversepolynomial(cell2.age)!=0){
            return (type_power(cell1.index, cell2.index)* reversepolynomial(cell1.age))/reversepolynomial(cell2.age);
        }
        return (type_power(cell1.index, cell2.index)* reversepolynomial(cell1.age));
    }



    public static int type_power(int t1, int t2) {
        return grid[t2][t1];
    }
}