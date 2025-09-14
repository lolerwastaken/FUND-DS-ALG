package logic.unit;

import java.util.ArrayList;

public class BaseUnit {
	private int row;
	private int column;
	private boolean isWhite;
	private String name;
	protected int hp;
	protected int power;
	protected boolean isFlying;
	
	public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
		setRow(startRow);
		setColumn(startColumn);
		setHP(2);
		this.name=name;
		this.power=1;
		this.isFlying=false;
		this.isWhite=isWhite;
	}
	
	public boolean move(int direction) {
		if (direction < 0 || direction > 3) {
            return false;
        }

        int newRow = row;
        int newColumn = column;

        switch (direction) {
            case 0: // move up
                newRow += 1;
                break;
            case 1: // move right
                newColumn += 1;
                break;
            case 2: // move down
                newRow -= 1;
                break;
            case 3: // move left
                newColumn -= 1;
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
	
	public void attack(ArrayList<BaseUnit> targetPieces) {
		for (BaseUnit target : targetPieces) {
            if (!target.isFlying && target.getRow() == row && target.getColumn() == column) {
                System.out.println(this.getName() + " attacks " + target.getName());
                target.setHP(target.getHP() - this.power);
            }
        }
	}
	
	public void setRow(int row) { this.row=Math.max(0, Math.min(4, row)); }
	public int getRow() { return row; }
	
	public void setColumn(int column) { this.column=Math.max(0, Math.min(4, column)); }
	public int getColumn() { return column; }
	
	public void setName(String name) { this.name=name; }
	public String getName() { return name; }
	
	public void setHP(int hp) { this.hp=hp; }
	public int getHP() { return hp;}
	
	public int getPower() { return power; }
	
	public boolean isFlying() { return isFlying; }
	
	public boolean isWhite() { return isWhite; }
	
	
}
