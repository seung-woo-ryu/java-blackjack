package model;

import java.util.List;

public class Croupier extends Participant{

    public Croupier(Hand hand, Deck deck) {
        super(hand, deck,"딜러");
    }

    public boolean isLowerThan16() {
        return getSumOfHand() <= 16;
    }

    @Override
    public String getFirstHand() {
        return hand.getFirstTwo()
            .get(0)
            .toString();
    }
}
