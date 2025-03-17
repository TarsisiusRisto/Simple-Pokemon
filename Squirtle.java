import java.util.Random;

public class Squirtle extends Pokemon implements hasEvolve{
    Squirtle(){
        super();
        this.hp = 40;
        this.cp = 40;
    }
    @Override
    public void skill1(Pokemon enemy){
        Random random = new Random();
        System.out.println("Squirtle perform Tackle");

        int damage = random.nextInt(5) + 5;
        enemy.hp -= damage;
        this.cp -= 3;
        if(enemy.hp < 0 ) enemy.hp =0;
        System.out.println("Squirtle attack with " + damage + " damage");

    }
    @Override
    public void skill2(Pokemon enemy){
        Random random = new Random();
        System.out.println("Squirtle perform Bubblebeam");
        int damage = random.nextInt(10) + 5;
        enemy.hp -= damage;
        this.cp -= 4; 
        if(enemy.hp < 0 ) enemy.hp = 0;
        System.out.println("Squirtle attack with " + damage + " damage");

    }
    @Override
    public void skill3(Pokemon enemy){
        System.out.println("Pokemon has not evolved yet");
    }
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + "{" + "hp = " + hp + " cp = " + cp + "}";
    }
}
