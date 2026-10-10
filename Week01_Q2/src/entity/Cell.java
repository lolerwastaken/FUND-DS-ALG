package entity;

public class Cell {
    private int hp;
    private int attack;
    private int def;

    public Cell() {
        //TODO: Implement this constructor

        
    }

    public Cell(int hp, int attack, int def) {
        //TODO: Implement this constructor
        
		
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if(hp<0) hp =0;
        this.hp  = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if(attack <0) attack =0;
        this.attack = attack;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        if(def <0) def = 0;
        this.def = def;
    }
}
