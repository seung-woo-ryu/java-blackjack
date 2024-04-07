package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.card.Card;
import model.card.enums.Rank;
import model.card.enums.Suit;

public class Deck {

    private List<Card> cardList;

    public void init() {
        // todo: 인스턴스 생성 -> init말고 init된 인스턴스를 반환하는 메서드 필. 전자는 생성 후 init 안하면 문제 발생.
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
        if (!cardList.isEmpty()) {
            return cardList.remove(0);
        }

        throw new IllegalArgumentException("덱에 카드가 존재하지 않습니다");
    }

}
