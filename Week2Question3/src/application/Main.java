package application;

import java.util.Scanner;

import logic.game.GameLogic;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ONE start!");
		System.out.println("Duel standby!");
		
		GameLogic.getInstance().gameStart();
		
		while(!GameLogic.getInstance().isGameOver()) {
			System.out.println("====================================================");
			System.out.println("The top pile is " + GameLogic.getInstance().getTopCard().getColor() + " " +  GameLogic.getInstance().getTopCard().getSymbol());
			System.out.println("You have "+ GameLogic.getInstance().getDeck().size() + " cards left in the deck.");
			
			if(GameLogic.getInstance().checkDrawRule()) {
				System.out.println("You have no playble card this turn.");
				System.out.println("You have to draw a card.");
				
				GameLogic.getInstance().draw(1);
			}
			else {
				System.out.println("Play a card.");
				for(int i = 0;i<GameLogic.getInstance().getHand().size();i++) {
					System.out.println(i+") "+ GameLogic.getInstance().getHand().get(i).getColor() + " " +  GameLogic.getInstance().getHand().get(i).getSymbol());
				}
				
				int input = sc.nextInt();
				try {
					if(input >= GameLogic.getInstance().getHand().size()) {
						throw new IndexOutOfBoundsException();
					}
					if(GameLogic.getInstance().getHand().get(input).ruleCheck()) {
						GameLogic.getInstance().getHand().remove(input).play();
					}
					else {
						System.out.println("The card is illegal. Please, select another card.");
					}
				}catch(IndexOutOfBoundsException e) {
					System.out.println("The index is out of bounds.");
				}
			}
		}
		
		if(GameLogic.getInstance().getDeck().size() == 0) {
			System.out.println("The deck is out. You lose.");
		}
		else if(GameLogic.getInstance().getHand().size() == 0) {
			System.out.println("You have no card left in your hand. You win.");
		}
	}
}
