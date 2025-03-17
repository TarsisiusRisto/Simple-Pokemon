import java.util.Random;
import java.util.Scanner;

public class Main {
    static int map[][];
    public static void main (String[] args){
        Scanner inStr = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);

        boolean done = false; 

        int mapSize;
        System.out.print("Enter the size of the map :");
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

        Player player = new Player(name);
        Charmander charmander = new Charmander();
        player.pokeDex.add(charmander);
        System.out.println("");
        initMap();

        while (!done) {
            showMap(player);
            String input;
            System.out.print("Enter Command :");
            input = inStr.nextLine();
            if(input.equalsIgnoreCase("w") && player.py != 0){
                player.py--;
            }else if(input.equalsIgnoreCase("a") && player.px != 0){
                player.px--;
            }else if(input.equalsIgnoreCase("s") && player.py != map.length -1 ){
                player.py++;
            }else if(input.equalsIgnoreCase("d") && player.px != map.length - 1){
                player.px++;
            }
            if(input.equalsIgnoreCase("i")){
                System.out.println("Pokedex : ");
                for(int i = 0; i < player.pokeDex.size(); i++){
                    System.out.println((i+1) + "." + player.pokeDex.get(i).getClass().getSimpleName());
                    if(player.pokeDex.get(i) instanceof Charmander){
                        Charmander poke1;
                        poke1 = (Charmander) player.pokeDex.get(i);
                        System.out.println("HP : " + poke1.hp); 
                        System.out.println("CP : " + poke1.cp); 
                        System.out.println("XP : " + poke1.exp); 
                        System.out.println("Level : " + poke1.lvl); 
                        System.out.println(" "); 
                    }else if(player.pokeDex.get(i) instanceof Bulbasaur){
                        Bulbasaur poke2;
                        poke2 = (Bulbasaur) player.pokeDex.get(i);
                        System.out.println("HP : " + poke2.hp); 
                        System.out.println("CP : " + poke2.cp); 
                        System.out.println("XP : " + poke2.exp); 
                        System.out.println("Level : " + poke2.lvl); 
                        System.out.println(" "); 
                    }else if(player.pokeDex.get(i) instanceof Squirtle){
                        Squirtle poke3;
                        poke3 = (Squirtle) player.pokeDex.get(i);
                        System.out.println("HP : " + poke3.hp); 
                        System.out.println("CP : " + poke3.cp); 
                        System.out.println("XP : " + poke3.exp); 
                        System.out.println("Level : " + poke3.lvl); 
                        System.out.println(" "); 
                    }
                }
            }else if(input.equalsIgnoreCase("h")){
                for (int i =0; i < player.pokeDex.size(); i++){
                    if(player.pokeDex.get(i).evolve){
                        player.pokeDex.get(i).hp = 50;
                    }else {
                        player.pokeDex.get(i).hp = 40;
                    }
                }
            }else if(input.equalsIgnoreCase("c")){
                for (int i =0; i < player.pokeDex.size(); i++){
                    if(player.pokeDex.get(i).evolve){
                        player.pokeDex.get(i).hp = 50;
                    }else {
                        player.pokeDex.get(i).hp = 30;
                    }
                }
            }else if(input.equalsIgnoreCase("exit")){
                done = true;
            }else if(map[player.py][player.px] == 1){
                Random random = new Random();
                int rand = random.nextInt(100) + 1;
                if (rand <= 40){
                    int randPokemon = random.nextInt(100) + 1;
                    if(randPokemon <= 45){
                        encounter ("Charmander", new Charmander(), player);
                    }else if(randPokemon <= 90 ){
                        encounter ("Squirtle", new Squirtle(), player);
                    }else{
                        encounter ( "Bulbasaur", new Bulbasaur(), player);
                    }
                }
            }
        }

    }
    static void initMap(){
        Random random = new Random();
        for(int i = 0;  i < map.length; i++){
            for(int j = 0; j < map[i].length; j++ ){
                int rand = random.nextInt(2);
                map[i][j] = rand;
            }
        }
    }

    static void showMap(Player player){
        for(int i = 0;  i < map.length; i++){
            for(int j = 0; j < map[i].length; j++ ){
                if(i == player.py && j == player.px){
                    System.out.print("[P]");
                }else if(map[i][j] == 1){
                    System.out.print("[*]");
                }else{
                    System.out.print("[ ]");
                }
            }
            System.out.println("");
        }
        System.out.println("PokeBalls : " + player.pokeBalls);
    }

    static void battle(Pokemon pokemon, Pokemon enemy, Player player, int index){
        Scanner inInt = new Scanner(System.in);
        boolean playerTurn = true;
        boolean battleDone = false;

        while (battleDone == false) {
            if (playerTurn) {
                System.out.println("");
                System.out.println("Your Pokemon : " + pokemon);
                System.out.println("Wild Pokemon : " + enemy);
                System.out.println("Choose Action : ");
                System.out.println("1. Skill 1");
                System.out.println("2. Skill 2" );
                System.out.println("3. Skill 3");
                System.out.println("4. Catch Pokemon");
                System.out.println("5. Escape");
                System.out.println(">>>>");
                int input = inInt.nextInt();

                // Player Move
                System.out.println("");
                if(input == 1){
                    pokemon.skill1(enemy);
                }else if(input == 2){
                    pokemon.skill2(enemy);
                }else if(input == 3){
                    pokemon.skill3(enemy);
                }else if(input == 4){
                    int result = catchPokemon();
                    if(result == 0){
                        System.out.println("Wild Pokemon : " + enemy.getClass().getSimpleName() + "Catched");
                        player.pokeDex.add(enemy);
                        battleDone = true;
                    }else if(result == 1 ){
                        System.out.println("Wild Pokemon : " + enemy.getClass().getSimpleName() + "Failed to catch");
                    }else{
                        System.out.println("Wild Pokemon : " + enemy.getClass().getSimpleName() + "Escape");
                    }
                }else if(input == 5){
                    battleDone = true;
                }
                playerTurn = false;
            }else{ 
                // Enemy Move
                Random random = new Random();
                int rand = random.nextInt(2);
                if (rand == 0) enemy.skill1(pokemon);
                else enemy.skill2(pokemon);
                playerTurn = true;
            }
             // cek hp 
             if (pokemon.hp <= 0){
                battleDone = true;
                System.out.println(pokemon.getClass().getSimpleName() + " Fainted!");
            }else if (enemy.hp <= 0) {
                System.out.println(enemy.getClass().getSimpleName() + " Fainted!");
                battleDone = true;
                Random random = new Random();
                int exp = random.nextInt(pokemon.lvl * 10 ) + 10;
                System.out.println("Pokemon " + pokemon.getClass().getSimpleName() + " Gained " + exp + " Experience" );
                //pokemon cek level
                pokemon.exp += exp;
                pokemon.checkLevel();
                
                //evolusi

            }
        }
    }
    static int catchPokemon(){
        Random random = new Random();
        int randCatch = random.nextInt(100) + 1;
        if(randCatch <= 50){
            return 0;
        }else if(randCatch <= 80){
            return 1;
        }else{
            return 2;
        }
    }

    static void encounter(String pokmeonName, Pokemon pokemon, Player player){
        Scanner inStr = new Scanner(System.in);
        // Random random = new Random();
        if(player.pokeDex.size() == 1){
            battle(player.pokeDex.get(0), pokemon, player, 0);
            return;
        }
        System.out.println("Choose your Pokemon: ");
        for(int i = 0; i < player.pokeDex.size(); i++){
            System.out.println((i+1)+ ". " + player.pokeDex.get(i).getClass().getSimpleName() + " - level " + player.pokeDex.get(i).lvl);
        }
        System.out.println(">>>");
        int input = inStr.nextInt();
        battle(player.pokeDex.get(input-1), pokemon, player, input-1);
    }
}