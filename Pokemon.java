public abstract class Pokemon implements hasEvolve{
    public int hp = 10, cp = 10, lvl = 1, exp = 0;
    protected boolean evolve = false;

    Pokemon(){

    }
    public void skill1(Pokemon enemy){
        System.out.println("Pokemon perform skill 1");
    }
    public void skill2(Pokemon enemy){
        System.out.println("Pokemon perform skill 2");
    }
    public void checkLevel(){
        if (this.exp >= this.lvl * 10){
            System.out.println(this.getClass().getSimpleName() + "level Up!");
            levelUp();
        }
    }
    public boolean checkEvolve(){
        if(this.lvl >= 5 && evolve == false){
            return true;
        }
        return false;
    }
    private void levelUp(){
        this.exp = 0;
        this.lvl++;
    }
    public String toString(){
        return this.getClass().getSimpleName() + "{" + "hp = " + hp + "cp =" + cp + "}";
    }
}
