package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.card.BaseCard;
import logic.card.DrawTwoCard;
import logic.game.CardColor;
import logic.game.GameLogic;
import logic.game.CardSymbol;

class DrawTwoCardTest {
	
	DrawTwoCard d1;
	DrawTwoCard d2;
	DrawTwoCard d3;
	DrawTwoCard d4;
	DrawTwoCard d5;

	ArrayList<BaseCard> deck;
	ArrayList<BaseCard> hand;
	
	
	@BeforeEach
	void setUp() throws Exception {
		d1 = new DrawTwoCard(CardColor.RED);
		d2 = new DrawTwoCard(CardColor.BLUE);
		d3 = new DrawTwoCard(CardColor.GREEN);
		d4 = new DrawTwoCard(CardColor.YELLOW);
		d5 = new DrawTwoCard(CardColor.RED);
		deck = new ArrayList<BaseCard>();
		hand = new ArrayList<BaseCard>();
		
		deck.add(d1);
		deck.add(d2);
		deck.add(d3);
		deck.add(d4);
		deck.add(d5);
		
		GameLogic.getInstance().setHand(hand);
		GameLogic.getInstance().setDeck(deck);
	}

	@Test
	void testConstructor() {
		assertEquals(CardColor.RED,d1.getColor());
		assertEquals(CardSymbol.DRAW,d1.getSymbol());
		assertEquals(CardColor.BLUE,d2.getColor());
		assertEquals(CardSymbol.DRAW,d2.getSymbol());
	}
	
	@Test
	void testPlay() {
		d1.play();
		assertEquals(2,GameLogic.getInstance().getHand().size());
		assertEquals(CardColor.RED,GameLogic.getInstance().getTopCard().getColor());
		assertEquals(CardSymbol.DRAW,GameLogic.getInstance().getTopCard().getSymbol());
		
		d4.play();
		assertEquals(4,GameLogic.getInstance().getHand().size());
		assertEquals(CardColor.YELLOW,GameLogic.getInstance().getTopCard().getColor());
		assertEquals(CardSymbol.DRAW,GameLogic.getInstance().getTopCard().getSymbol());
	}
	
	@Test
	void testRuleCheck() {
		GameLogic.getInstance().setTopCard(d1);
		assertEquals(true, d1.ruleCheck());
		assertEquals(false, d2.ruleCheck());
		assertEquals(true, d5.ruleCheck());
	}

}
