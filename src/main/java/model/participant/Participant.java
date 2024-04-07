package model.participant;

import model.card.Card;
import model.Deck;
import model.Hand;

public abstract class Participant {

    public String getName() {
        return name;
    }

    protected Hand hand;
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

    public abstract String getFirstHand();
    public boolean isBlackjack() {
        return hand.isBlackjack();
    }
    public boolean isBurst() {
        return hand.isBurst();
    }
}
