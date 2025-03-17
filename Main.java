import java.util.Scanner;

public class Main {
    static int map[][];
    public static void main (String[] args){
        Scanner inStr = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);

        boolean done = false; 

        int mapSize;
        System.out.println("Enter the size of the map :");
        mapSize = inInt.nextInt();
        map = new int[mapSize][mapSize];
        String name;
        System.out.println("Enter your name: ");
        name = inStr.nextLine();

        System.out.println("");
        System.out.println("Controller");
        System.out.println("1. W : Move up");
        System.out.println("2. A : Move Left");
        System.out.println("3. S: Move Bottom");
        System.out.println("4. D : Move Right");
        System.out.println("5. I : Pokedex");
        System.out.println("6. H : Heal");
        System.out.println("7. C : Add CP");
        System.out.println("8. EXIT : Exit Game");
        System.out.println("");


    }
}