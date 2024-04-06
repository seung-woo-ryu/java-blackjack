package model;

public abstract class Participant {

    private Hand hand;
    private Deck deck;

    public Participant(Hand hand, Deck deck) {
        this.hand = hand;
        this.deck = deck;
    }

    public void hit() {
        Card hit = deck.hit();
        hand.addCard(hit);
    }

    public int getSumOfHand() {
        return hand.countGreedyPoints();
    }
}
