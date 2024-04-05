package model;

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public boolean isAce() {
        return this.rank.isAce();
    }

    public int getValue() {
        return rank.getValue();
    }
}
