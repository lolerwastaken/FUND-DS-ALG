package logic;

public class Station {
    private String name;
    private int number;

    public Station(String name, int number) {
        setName(name);
        setNumber(number);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        if (number < 0) {
            this.number = 0;
        } else {
            this.number = number;
        }
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
