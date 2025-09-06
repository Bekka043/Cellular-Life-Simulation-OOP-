import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    static ArrayList<Character> characters = new ArrayList<Character>();
    private static int turn = 0;


    public static void addGroup(ArrayList<Character> allOfThem) {
        characters.addAll(allOfThem);
    }

    public static void addCharacter(Character character) {
        characters.add(character);
    }



    public static void kill(Character character) {
        characters.remove(character);
        character.killedCount();
    }

    public static void updategeneral() {
        turn++;

        //for (Character character : characters) {
        //    character.update();
        //}
        for (int i = 0; i < characters.size(); i++) {
            characters.get(i).update();
        }
        characters.removeIf(character -> character.hp <= 0);
    }

    public static void printState() {
        System.out.println("Living Micro Organisms:");

        for (Character character : characters) {
            System.out.println(character.type + " --> Age: " + character.age + " , HP: " + character.hp);
        }
    }

    public static void printStatistics() {




        System.out.println(" Bacteria: " + (Bacteria.bacteriaCount-Bacteria.deadBacteria)+" living /"+ Bacteria.bacteriaCount);
        System.out.println(" Human Cells: " + (HumanCell.humanCellCount-HumanCell.deadHumanCell)+" living /"+ HumanCell.humanCellCount);
        System.out.println(" White Blood Cells: " + (WhiteBloodCell.whiteBloodCellCount-WhiteBloodCell.deadWbs)+" living /"+ WhiteBloodCell.whiteBloodCellCount);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER NUMBER OF BACTERIAS:");

        for ( int bac = scanner.nextInt(); bac>0; bac--){
            addCharacter(new Bacteria(0, 100));
        }
        System.out.println("ENTER NUMBER OF WHITE BLOOD CELLS:");

        for ( int wbs = scanner.nextInt(); wbs>0; wbs--){
            addCharacter(new WhiteBloodCell(0, 100));
        }
        System.out.println("ENTER NUMBER OF HUMAN CELLS:");

        for ( int hc = scanner.nextInt(); hc>0; hc--){
            addCharacter(new HumanCell(0, 100));
        }





        System.out.println("ENTER NUMBER OF LOOPS:");
        for (int i = scanner.nextInt();i>0;i--){
            updategeneral();
        }


        while (true) {
            printState();
            System.out.println("---------------------------------");
            printStatistics();
            System.out.println("---------------------------------");

            if (characters.isEmpty()){
                System.out.println("The Eco System has died out ");

                break;}


            System.out.println("Press: (1)Next Loop  \n (2) Add Loops \n  (3) Add Bacteria 3 \n (4) add Human Cell \n (5) Add White Blood Cell \n (6)X Exit Social Game X ") ;
            int command = scanner.nextInt();


            if (command == 6 ) {

                System.out.println("Thanks For Playing!");

                break;




            } else if (command == 1) {
                updategeneral();
            } else if (command == 3) {
                addCharacter(new Bacteria(0, 100));

            } else if (command == 4) {
                addCharacter(new HumanCell(0, 100));
            } else if (command == 5) {
                addCharacter(new WhiteBloodCell(0, 100));
            }
            else if (command==2){
                System.out.println("How Many Loops:");
                for (int i = scanner.nextInt();i>0;i--){
                    updategeneral();
                }
            }

        }

        scanner.close();
    }
}