package logic.utility;


import logic.card.BaseCard;
import logic.game.GameLogic;
import java.util.ArrayList;

public class GameLogicUtility {
	public static boolean drawRule() {
		ArrayList<BaseCard> hand = GameLogic.getInstance().getHand();
        for (BaseCard card : hand) {
            if (card.ruleCheck()) {
                return false;
            }
        }
        return true;
	}
}
