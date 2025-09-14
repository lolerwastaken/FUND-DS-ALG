package logic.unit;

public class MeleeUnit extends BaseUnit {
	public MeleeUnit(int startColumn, int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		setHP(5);
		this.power=2;
	}
}
