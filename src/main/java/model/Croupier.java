package model;

public class Croupier extends Participant{

    public Croupier(Hand hand, Deck deck) {
        super(hand, deck,"딜러");
    }

    public boolean isLowerThan16() {
        return getSumOfHand() <= 16;
    }
}
