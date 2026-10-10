package entity;

public class CancerCell extends EaterCell {
    private int divideInterval;
    private int eatingSpeed;
    private int divideCounter;
    private boolean divideSuccess;

    public CancerCell(int divideInterval, int speed) {
        //TODO: Implement this constructor
        super();
        setDivideInterval(divideInterval);
        setEatingSpeed(speed);
        setDivideCounter(0);
        setDivideSuccess(false);
    }

    public CancerCell(int hp, int att, int def, int divideInterval, int speed) {
        //TODO: Implement this constructor
        super(hp, att, def);
        setDivideInterval(divideInterval);
        setEatingSpeed(speed);
        setDivideCounter(0);
        setDivideSuccess(false);
    }

    public void suck(Cell c) {
        //TODO: Implement this method
        if (c instanceof CancerCell) return; // c is a cancer cell -> do nothing

        for (int i = 0; i < eatingSpeed; i++) { // Loop for eatingSpeed number of times
            super.suck(c); // Call the suck method of Cancer's superclass
            divideCounter += 1; // Increment divideCounter (by 1)
            if (divideCounter >= divideInterval) setDivideSuccess(true); // Self explanatory
        }

    }

    public void mutate(){
        //TODO: Implement this method
        eatingSpeed += 1; // Increment eatingSpeed by 1
    }

    public boolean isDivideSuccess() {
        return divideSuccess;
    }

    public void setDivideSuccess(boolean divideSuccess) {
        this.divideSuccess = divideSuccess;
    }

    public int getDivideInterval() {
        return divideInterval;
    }

    public void setDivideInterval(int divideInterval) {
        if (divideInterval < 0) divideInterval = 0;
        this.divideInterval = divideInterval;
    }

    public int getEatingSpeed() {
        return eatingSpeed;
    }

    public void setEatingSpeed(int eatingSpeed) {
        if (eatingSpeed < 0) eatingSpeed = 0;
        this.eatingSpeed = eatingSpeed;
    }

    public int getDivideCounter() {
        return divideCounter;
    }

    public void setDivideCounter(int divideCounter) {
        if (divideCounter < 0) divideCounter = 0;
        this.divideCounter = divideCounter;
    }
}
