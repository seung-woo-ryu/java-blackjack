package model;

import java.lang.reflect.Field;
import java.util.List;
import model.card.Card;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void _52장_카드_덱_생성() throws NoSuchFieldException, IllegalAccessException {
        int deckSize = 52;
        Deck deck = new Deck();
        deck.init();

        Field declaredField = Deck.class.getDeclaredField("cardList");

        declaredField.setAccessible(true);

        List<Card> cardList = (List<Card>) declaredField.get(deck);

        Assertions.assertThat(cardList).isNotNull();
        Assertions.assertThat(cardList.size()).isEqualTo(deckSize);
    }

    @Test
    void 맨_위의_카드_한장_주기() throws NoSuchFieldException, IllegalAccessException {
        // given
        int deckSize = 52;
        int hitCount = 3;

        Deck deck = new Deck();
        deck.init();

        Field declaredField = Deck.class.getDeclaredField("cardList");

        declaredField.setAccessible(true);

        List<Card> cardList = (List<Card>) declaredField.get(deck);
        // when
        for (int i = 0; i < 3; i++) {
            deck.hit();
        }
        // then
        Assertions.assertThat(cardList).isNotNull();
        Assertions.assertThat(cardList.size()).isEqualTo(deckSize - hitCount);
    }
}