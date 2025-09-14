package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit {
	public RangeUnit(int startColumn,int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		setHP(2);
	}
	
	@Override
	public void attack(ArrayList<BaseUnit> targetPieces) {
		int attackRow = getRow();
		int attackColumn = getColumn();
		
		if (isWhite()) {
			attackRow += 1; // White unit, attack on a tile in a row above this unit.
		} else {
			attackRow -= 1; // Red unit, attack on a tile in a row below this unit.
		}
		
		// Check if attack position is valid
		if (attackRow < 0 || attackRow > 4 || attackColumn < 0 || attackColumn > 4) {
            return;
        }
		
		for (BaseUnit target : targetPieces) {
            if (target.getRow() == attackRow && target.getColumn() == attackColumn) {
                System.out.println(this.getName() + " attacks " + target.getName());
                target.setHP(target.getHP() - this.power);
            }
        }
		
	}
}
