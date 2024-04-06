package model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParticipantTest {

    @Test
    void hit_성공() {
        // given
        Deck deck = new Deck();
        deck.init();
        Hand hand = new Hand();
        Player player = new Player(hand, deck);
        int beforeSum = player.getSumOfHand();
        // when
        player.hit();
        int afterSum = player.getSumOfHand();
        // then
        Assertions.assertThat(beforeSum).isNotEqualTo(afterSum);
    }

    @Test
    void 보유하고_있는_카드_점수_계산() {
        // given
        Deck deck = new Deck();
        deck.init();
        Hand hand = new Hand();
        Player player = new Player(hand, deck);
        // when
        int beforeSum = player.getSumOfHand();
        int targetSum = 0;
        // then
        Assertions.assertThat(beforeSum).isEqualTo(targetSum);
    }

}