package model;

import java.util.ArrayList;
import java.util.List;
import model.card.Card;

public class Hand {

    private int BURST_LIMIT = 21;
    private List<Card> myHand;

    public Hand() {
        this.myHand = new ArrayList<>();
    }

    public void addCard(Card card) {
        if (myHand.contains(card)) {
            throw new IllegalArgumentException("중복된 카드가 존재합니다");
        }

        myHand.add(card);
    }

    public boolean isBlackjack() {
        return myHand != null && myHand.size() == 2 && (isConsistOfAce()&& isConsistOfTenValue());
    }


    private boolean isConsistOfTenValue() {
        for (Card card : myHand) {
            if (card.isTenValue()) {
                return true;
            }
        }
        return false;
    }
    private boolean isConsistOfAce() {
        for (Card card : myHand) {
            if (card.isAce()) {
                return true;
            }
        }
        return false;
    }

    public boolean isBurst() {
        return countGreedyPoints() > BURST_LIMIT;
    }

    public int countGreedyPoints() {
        int sum = getSumOfHand();
        // todo: 보기 어렵다..
        if (isConsistOfAce() && sum + 10 <= BURST_LIMIT) {
            return sum + 10;
        }

        return sum;
    }

    private int getSumOfHand() {
        int sum = 0;

        for (Card card : myHand) {
            sum += card.getValue();
        }

        return sum;
    }

    public List<Card> getFirstTwo() {
        if (myHand.size() != 2) {
            throw new IllegalArgumentException("아직 처음 패를 받지 못했습니다");
        }

        return myHand.subList(0, 2);
    }
}
