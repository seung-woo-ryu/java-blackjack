package model;

import model.enums.Rank;
import model.enums.Suit;

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

    public boolean isTenValue() {
        return this.rank.getValue() == 10;
    }

    public int getValue() {
        return rank.getValue();
    }
}
