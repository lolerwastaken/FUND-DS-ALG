package logic;

public class Item {
    private String name;
    private int pricePerPiece;

    public Item(String name, int pricePerPiece) {
        setName(name);
        setPricePerPiece(pricePerPiece);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPricePerPiece(int pricePerPiece) {
        if (pricePerPiece < 1) {
            this.pricePerPiece = 1;
        } else {
            this.pricePerPiece = pricePerPiece;
        }
    }

    public String getName() {
        return name;
    }

    public int getPricePerPiece() {
        return pricePerPiece;
    }

}
