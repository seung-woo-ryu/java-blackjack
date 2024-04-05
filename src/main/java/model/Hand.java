package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private int BURST_LIMIT = 21;
    private List<Card> myHand;

    public Hand() {
        this.myHand = new ArrayList<>();
    }

    public void addCard(Card card) {
        myHand.add(card);
    }

    public boolean isBlackjack() {
        return myHand != null && myHand.size() == 2 && isConsistOfAceAndTenValue();
    }


    private boolean isConsistOfAceAndTenValue() {
        boolean isAce = false;
        boolean isTenValue = false;
        for (Card card : myHand) {
            if (card.isAce()) {
                isAce = true;
            }
            if (card.getValue() == 10) {
                isTenValue = true;
            }
        }
        return isAce && isTenValue;
    }

    public boolean isBurst() {
        return countGreedyPoints() > BURST_LIMIT;
    }

    public int countGreedyPoints() {
        // 카드에 Ace가 있는지 확인.
        // 총 value 다 더함.
        // total value + 10 <= BURST_LIMIT ? total value + 10 ; total value

        return 32;
    }
}
