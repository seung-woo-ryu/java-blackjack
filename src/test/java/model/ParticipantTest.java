package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import model.enums.Rank;
import model.enums.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParticipantTest {

    @Test
    void hit_성공() {
        // given
        Deck deck = new Deck();
        deck.init();
        Hand hand = new Hand();
        String name = "player";
        Participant participant = new Player(hand, deck, name);
        int beforeSum = participant.getSumOfHand();
        // when
        participant.hit();
        int afterSum = participant.getSumOfHand();
        // then
        Assertions.assertThat(beforeSum).isNotEqualTo(afterSum);
    }
    @Test
    void 보유하고_있는_카드_점수_계산() {
        // given
        Deck deck = new Deck();
        deck.init();
        Hand hand = new Hand();

        String name = "player";
        Participant participant = new Player(hand, deck, name);
        // when
        int beforeSum = participant.getSumOfHand();
        int targetSum = 0;
        // then
        Assertions.assertThat(beforeSum).isEqualTo(targetSum);
    }
    @Test
    void 첫_핸드_문자열_Exception_반환() {
        // given
        Deck deck = new Deck();
        deck.init();

        Hand hand = new Hand();
        hand.addCard(new Card(Suit.CLUB, Rank.JACK));

        String name = "player";

        Participant participant = new Player(hand, deck, name);
        // when, then
        Assertions.assertThatThrownBy(
            () -> participant.getFirstHand()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어_첫_핸드_문자열_반환_성공() {
        // given
        Deck deck = new Deck();
        deck.init();

        Hand hand = new Hand();
        hand.addCard(new Card(Suit.CLUB, Rank.JACK));
        hand.addCard(new Card(Suit.CLUB, Rank.NINE));

        String name = "player";
        String target = "10CLUB, 9CLUB";

        Participant participant = new Player(hand, deck, name);

        // when
        boolean equals = participant.getFirstHand()
            .equals(target);
        // then
        Assertions.assertThat(equals).isTrue();
    }
    @Test
    void 딜러_첫_핸드_문자열_반환_성공() {
        // given
        Deck deck = new Deck();
        deck.init();

        Hand hand = new Hand();
        hand.addCard(new Card(Suit.CLUB, Rank.JACK));
        hand.addCard(new Card(Suit.CLUB, Rank.NINE));

        String target = "10CLUB";

        Participant participant = new Croupier(hand, deck);

        // when
        boolean equals = participant.getFirstHand()
            .equals(target);
        // then
        Assertions.assertThat(equals).isTrue();
    }
}