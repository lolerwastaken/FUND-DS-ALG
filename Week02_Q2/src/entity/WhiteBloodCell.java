package entity;

public class WhiteBloodCell extends EaterCell {
    public WhiteBloodCell() {
        //TODO: Implement this constructor
        super();
    }

    public WhiteBloodCell(int hp, int attack, int def) {
        //TODO: Implement this constructor
        super(hp, attack, def);
    }

    public void suck(Cell c){
        //TODO: Implement this method
        if (c instanceof WhiteBloodCell) return; // c is a white blood cell -> do nothing
        super.suck(c);
    }

}
