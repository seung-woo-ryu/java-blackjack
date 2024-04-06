package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cardList;

    public void init() {
        generateCardList();
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(cardList);
    }

    private void generateCardList() {
        cardList = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardList.add(new Card(suit, rank));
            }
        }
    }

    public Card hit() {
        return cardList.re
    }
}
