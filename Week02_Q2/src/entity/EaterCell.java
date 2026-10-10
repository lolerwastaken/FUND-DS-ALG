package entity;

public class EaterCell extends Cell {
    public EaterCell() {
        //TODO: Implement this constructor
        super();
    }

    public EaterCell(int hp, int attack, int def) {
        //TODO: Implement this constructor
        super(hp, attack, def);
    }

    public void suck(Cell c) {
        //TODO: Implement this method
        int damage = this.getAttack() - c.getDef(); // difference between this's attack and c's defence
        if (damage < 0) damage = 0; // difference is negative, set it to zero
        if (damage > c.getHp()) damage = c.getHp(); // this cell will never drain c's more than c's hp
        c.setHp(c.getHp() - damage); // Reduce c's hp by this difference
        this.setHp(this.getHp() + damage); // Increase this's hp by this difference
    }
}
