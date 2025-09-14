package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.card.BaseCard;
import logic.card.DrawTwoCard;
import logic.card.NumberCard;
import logic.game.CardColor;
import logic.game.GameLogic;
import logic.game.CardSymbol;
import logic.utility.GameLogicUtility;

class GameLogicUtilityTest {

	@BeforeEach
	void setUp() throws Exception {
		
		
		GameLogic.getInstance().setTopCard(new NumberCard(CardColor.RED,CardSymbol.FOUR));
		GameLogic.getInstance().getHand().add(new NumberCard(CardColor.RED,CardSymbol.ONE));
		GameLogic.getInstance().getHand().add(new NumberCard(CardColor.BLUE,CardSymbol.ONE));
		GameLogic.getInstance().getHand().add(new NumberCard(CardColor.GREEN,CardSymbol.TWO));
	}
	
	@AfterEach
	void tearDown() {
		ArrayList<BaseCard> h = GameLogic.getInstance().getHand();
		int s = h.size();
		for (int i=0;i<s;i++) {
			h.remove(0);
		}
		
	}
	
	

	@Test
	void testRuleCheckNumberCardInHand() {
		assertFalse(GameLogicUtility.drawRule());
		GameLogic.getInstance().getHand().remove(0);
		assertTrue(GameLogicUtility.drawRule());
		GameLogic.getInstance().setTopCard(new NumberCard(CardColor.YELLOW,CardSymbol.TWO));
		assertFalse(GameLogicUtility.drawRule());
		
		GameLogic.getInstance().setTopCard(new DrawTwoCard(CardColor.RED));
		assertTrue(GameLogicUtility.drawRule());
		
		GameLogic.getInstance().setTopCard(new DrawTwoCard(CardColor.GREEN));
		assertFalse(GameLogicUtility.drawRule());
		
	}
	
	@Test
	void testRuleCheckDrawTwoCardInHand() {
		GameLogic.getInstance().setTopCard(new NumberCard(CardColor.YELLOW,CardSymbol.FOUR));
		GameLogic.getInstance().getHand().add(new DrawTwoCard(CardColor.YELLOW));
		assertFalse(GameLogicUtility.drawRule());
		
		GameLogic.getInstance().getHand().remove(0);
		GameLogic.getInstance().getHand().remove(0); //' in hand only contains green-2 and yellow
		GameLogic.getInstance().setTopCard(new NumberCard(CardColor.RED,CardSymbol.FOUR));
		assertTrue(GameLogicUtility.drawRule());
		
		GameLogic.getInstance().setTopCard(new DrawTwoCard(CardColor.RED));
		assertTrue(GameLogicUtility.drawRule());
		
		GameLogic.getInstance().setTopCard(new DrawTwoCard(CardColor.YELLOW));
		assertFalse(GameLogicUtility.drawRule());
		
	}
}
