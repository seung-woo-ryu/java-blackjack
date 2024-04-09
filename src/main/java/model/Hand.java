package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.card.Card;

public class Hand {

    private int BURST_LIMIT = 21;
    private int TEN_VALUE = 10;
    private int FIRST_HAND_COUNT = 2;
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
        return myHand.size() == FIRST_HAND_COUNT && isConsistOfAce()&& isConsistOfTenValue();
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
        int sumIfAce11 = sum + TEN_VALUE;

        if (isConsistOfAce() && sumIfAce11 <= BURST_LIMIT) {
            return sumIfAce11;
        }

        return sum;
    }

    private int getSumOfHand() {
        return myHand.stream()
            .mapToInt(card -> card.getValue())
            .sum();
    }

    public List<Card> getFirstTwo() {
        if (myHand.size() != 2) {
            throw new IllegalArgumentException("아직 처음 패를 받지 못했습니다");
        }

        return myHand.subList(0, 2);
    }

    public String toStringHandInfo() {
        return myHand.stream()
            .map(card -> card.toString())
            .collect(Collectors.joining(","))
            .toString();
    }
}
