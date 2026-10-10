public class Part {
    //TODO: Implement the remaining codes.
	private int hp;
    private int str;
    private int def;

    public Part(int hp, int str, int def) {
        if (hp < 0) {
            setHp(0);
        } else {
            setHp(hp);
        } // or setHp(Math.max(hp, 0));

        if (str < 0) {
            setStr(0);
        } else {
            setStr(str);
        } // or setStr(Math.max(str, 0));

        if (def < 0) {
            setDef(0);
        } else {
            setDef(def);
        } // or setDef(Math.max(def, 0));

    }

    public Part() {
        this.hp = 10;
        this.str = 2;
        this.def = 2;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp <= 0) {
            this.hp = 0;
            this.str = 0;
            this.def = 0;
        } else {
            this.hp = hp;
        }
    }
    public int getStr() {
        return str;
    }

    public void setStr(int quantity) {
        if (hp <= 0 || quantity < 0) {
            this.str = 0;
        } else {
            this.str = quantity;
        }
    }

    public int getDef() {
        return def;
    }

    public void setDef(int value) {
        if (hp <= 0 || value < 0) {
            this.def = 0;
        } else {
            this.def = value;
        }
    }

    @Override
    public String toString() {
        return
                "{ hp=" + hp +
                        ", str=" + str +
                        ", def=" + def +
                        '}';
    }
}
