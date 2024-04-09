package model.participant;

import java.util.List;
import java.util.stream.Collectors;
import model.Deck;
import model.Hand;

public class Player extends Participant{
    private int betAmount;
    public Player(Hand hand, Deck deck, String name) {
        super(hand, deck, name);
    }
    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }
    public int getBetAmount() {
        return betAmount;
    }
    @Override
    public String getFirstHand() {
        List<String> collect = hand.getFirstTwo()
            .stream()
            .map(card -> card.toString())
            .collect(Collectors.toList());

        return getName() + ": " + String.join(", ", collect);
    }
}
