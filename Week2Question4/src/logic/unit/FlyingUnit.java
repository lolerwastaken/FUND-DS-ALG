package logic.unit;

public class FlyingUnit extends BaseUnit {
	public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		setHP(2);
		this.isFlying=true;
	}
	
	public boolean move(int direction) {
		if (direction < 0 || direction > 3) {
            return false;
        }

        int newRow = getRow();
        int newColumn = getColumn();

        switch (direction) {
            case 0: // move up
                newRow += 2;
                break;
            case 1: // move right
                newColumn += 2;
                break;
            case 2: // move down
                newRow -= 2;
                break;
            case 3: // move left
                newColumn -= 2;
                break;
        }

        // check borders
        if (newRow < 0 || newRow > 4 || newColumn < 0 || newColumn > 4) {
            return false;
        }

        setRow(newRow);
        setColumn(newColumn);
        
        return true;
	}
}
