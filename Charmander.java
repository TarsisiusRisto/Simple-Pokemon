import java.util.Random;

public class Charmander extends Pokemon{
     Charmander() {
        super();
        this.hp = 40;
        this.cp = 40;
    }
    @Override
    public void skill1(Pokemon enemy) {
        Random random = new Random();
        System.out.println("Charmander Perform Tackle");
        
        //kurangi hp lawan
        int damage = random.nextInt(5) + 5;
        enemy.hp -= damage; // 4 - 9
        this.cp -= 3;
        if (enemy.hp < 0) enemy.hp = 0;
        System.out.println("Charmander attack with " + damage + " damage.");
    }
     @Override
    public void skill2(Pokemon enemy) {
        Random random = new Random();
        System.out.println("Charmander Perform Ember ");
        
        //kurangi hp lawan
        int damage = random.nextInt(10) + 5;
        enemy.hp -= damage; // 11 - 16
        this.cp -= 4;
        if (enemy.hp < 0) enemy.hp = 0;
        System.out.println("Charmander attack with " + damage + " damage.");
    }
    @Override
    public void skill3(Pokemon enemy) {
        System.out.println("Pokemon Belum Evolve");
    }
    @Override 
    public String toString() {
        return this.getClass().getSimpleName() + " { " + " hp = " + hp + " cp = " + cp + '}';
    }
}
