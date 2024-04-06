package model;

public abstract class Participant {

    private Hand hand;
    private Deck deck;
    private String name;

    public Participant(Hand hand, Deck deck, String name) {
        this.hand = hand;
        this.deck = deck;
        this.name = name;
    }

    public void hit() {
        Card hit = deck.hit();
        hand.addCard(hit);
    }

    public int getSumOfHand() {
        return hand.countGreedyPoints();
    }
}
