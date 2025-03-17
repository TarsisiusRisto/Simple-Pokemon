import java.util.ArrayList;

public class Player {
    ArrayList<Pokemon> pokeDex = new ArrayList<>();
    int px, py;
    String name;
    int pokeBalls = 10;

    Player(String name){
        this.px = 0;
        this.py = 0;
        this.name = name;
    }
}
