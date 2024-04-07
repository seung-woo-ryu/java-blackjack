package model;

import model.card.Card;
import model.card.enums.Rank;
import model.card.enums.Suit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HandTest {

    @Test
    void 카드_추가하기() {
        Assertions.assertDoesNotThrow(
            () -> {
                Hand hand = new Hand();
                Card card = new Card(Suit.CLUB, Rank.ACE);

                hand.addCard(card);
            }
        );
    }

    @Test
    void 블랙잭_판단_성공() {
        // given
        Hand hand = new Hand();
        Card ace = new Card(Suit.CLUB, Rank.ACE);
        Card jack = new Card(Suit.CLUB, Rank.JACK);

        hand.addCard(ace);
        hand.addCard(jack);
        // when
        boolean isBlackjack = hand.isBlackjack();
        // then
        Assertions.assertTrue(isBlackjack);
    }

    @Test
    void 블랙잭_아님_판단_성공() {
        // given
        Hand hand = new Hand();
        Card ace = new Card(Suit.CLUB, Rank.ACE);
        Card jack = new Card(Suit.CLUB, Rank.EIGHT);

        hand.addCard(ace);
        hand.addCard(jack);
        // when
        boolean isBlackjack = hand.isBlackjack();
        // then
        Assertions.assertFalse(isBlackjack);
    }

    @Test
    void 버스트_판단_성공() {
        // given
        Hand hand = new Hand();
        Card jack = new Card(Suit.CLUB, Rank.EIGHT);
        Card queen = new Card(Suit.CLUB, Rank.QUEEN);
        Card king = new Card(Suit.CLUB, Rank.KING);

        hand.addCard(jack);
        hand.addCard(queen);
        hand.addCard(king);
        // when
        boolean isBurst = hand.isBurst();
        // then
        Assertions.assertTrue(isBurst);
    }

    @Test
    void 버스트_아님_판단_성공() {
        // given
        Hand hand = new Hand();
        Card jack = new Card(Suit.CLUB, Rank.EIGHT);
        Card queen = new Card(Suit.CLUB, Rank.QUEEN);

        hand.addCard(jack);
        hand.addCard(queen);
        // when
        boolean isBurst = hand.isBurst();
        // then
        Assertions.assertFalse(isBurst);
    }

    @Test
    void 중복된_카드_추가시_EXCEPTION_발생() {
        // given
        Hand hand = new Hand();

        hand.addCard(new Card(Suit.CLUB,Rank.NINE));

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class,
            ()->{
                hand.addCard(new Card(Suit.CLUB,Rank.NINE));
            }
        );

    }
}