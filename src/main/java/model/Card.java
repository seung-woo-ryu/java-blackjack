package model;

import java.util.Objects;
import model.enums.Rank;
import model.enums.Suit;

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return suit == card.suit && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
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
