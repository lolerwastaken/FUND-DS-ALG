package entity;

public class CancerCell {
    private int divideInterval;
    private int eatingSpeed;
    private int divideCounter;
    private boolean divideSuccess;

    public CancerCell(int divideInterval, int speed) {
        //TODO: Implement this constructor
        
		
    }

    public CancerCell(int hp, int att, int def, int divideInterval, int speed) {
        //TODO: Implement this constructor
        
		
    }

    public void suck(Cell c){
        //TODO: Implement this method
        
		
    }

    public void mutate(){
        //TODO: Implement this method
        
		
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
        if(divideInterval<0) divideInterval =0;
        this.divideInterval = divideInterval;
    }

    public int getEatingSpeed() {
        return eatingSpeed;
    }

    public void setEatingSpeed(int eatingSpeed) {
        if(eatingSpeed<0) eatingSpeed =0;
        this.eatingSpeed = eatingSpeed;
    }

    public int getDivideCounter() {
        return divideCounter;
    }

    public void setDivideCounter(int divideCounter) {
        if(divideCounter<0) divideCounter =0;
        this.divideCounter = divideCounter;
    }
}
