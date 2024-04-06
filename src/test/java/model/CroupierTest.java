package model;

import static org.junit.jupiter.api.Assertions.*;

import model.enums.Rank;
import model.enums.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CroupierTest {

    @Test
    void 딜러_카드_합_16이하_일때_true_반환() {
        // given
        Deck deck = new Deck();
        deck.init();
        Hand hand = new Hand();
        String name = "player";
        Croupier croupier = new Croupier(hand, deck);
        // when
        boolean lowerThan16 = croupier.isLowerThan16();
        // then
        Assertions.assertThat(lowerThan16).isTrue();
    }
    @Test
    void 딜러_카드_합_16초과_일때_false_반환() {
        // given
        Deck deck = new Deck();
        deck.init();
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.CLUB, Rank.EIGHT));
        hand.addCard(new Card(Suit.CLUB, Rank.NINE));

        Croupier croupier = new Croupier(hand, deck);
        // when
        boolean lowerThan16 = croupier.isLowerThan16();
        // then
        Assertions.assertThat(lowerThan16).isFalse();
    }
}