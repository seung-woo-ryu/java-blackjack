package model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {
    @Test
    void 카드가_에이스이면_TRUE_반환 () {
        // given
        Card card = new Card(Suit.CLUB, Rank.ACE);
        // when
        boolean isAce = card.isAce();
        // then
        Assertions.assertThat(isAce).isTrue();
    }

    @Test
    void 카드가_에이스가_아니면_FALSE_반환 () {
        // given
        Card card = new Card(Suit.CLUB, Rank.EIGHT);
        // when
        boolean isAce = card.isAce();
        // then
        Assertions.assertThat(isAce).isFalse();
    }

}