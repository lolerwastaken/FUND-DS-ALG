public class Bot {
	//TODO: Implement all remaining code.
	private Part head;
    private Part arms;
    private Part legs;

    public Bot(Part head, Part arms, Part legs) {
        setHead(head);
        setArms(arms);
        setLegs(legs);
    }

    public boolean isDead() {
        return head.getHp() == 0 && arms.getHp() == 0 && legs.getHp() == 0;
    }

    public Part getHead() {
        return head;
    }

    public void setHead(Part h) {
        this.head = new Part(h.getHp(), h.getStr(), h.getDef());
    }

    public Part getArms() {
        return arms;
    }

    public void setArms(Part a) {
        this.arms = new Part(a.getHp(), a.getStr(), a.getDef());
    }

    public Part getLegs() {
        return legs;
    }

    public void setLegs(Part l) {
        this.legs = new Part(l.getHp(), l.getStr(), l.getDef());
    }

    public void attack(Part target) {
        if (target == null) {
            return;
        }
        if (target.getHp() == 0) {
            System.out.println("Target is already destroyed. Nothing changes.");
            return;
        }

        double attackPower = arms.getStr() + 0.25*legs.getStr() + 0.50*head.getStr();
        double damageDealt = attackPower - target.getDef(); // 0 damage if it doesn't fully pierce through the defense

        if (damageDealt < 0) {
            damageDealt = 0;
        }

        int damageTaken = (int) damageDealt;
        target.setHp(target.getHp() - damageTaken);
        System.out.println("Target takes "+damageTaken+" damage.");

        if (target.getHp() == 0) {
                System.out.println("Target is destroyed.");
        }
    }
	
    @Override
    public String toString() {
        return "{" +
                " head=" + head +
                ", arms=" + arms +
                ", legs=" + legs +
                '}';
    }

}
