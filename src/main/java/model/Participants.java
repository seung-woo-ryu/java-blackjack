package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import model.participant.Croupier;
import model.participant.Participant;
import model.participant.Player;

public class Participants {

    private List<Participant> participants;

    public Participants(String participants,Deck deck) {
        this.participants = new ArrayList<>();
        addPlayers(participants, deck);
        addCroupier(deck);
    }

    private void addCroupier(Deck deck) {
        this.participants.add(new Croupier(new Hand(), deck));
    }

    private void addPlayers(String participants, Deck deck) {
        String[] split = participants.split(",");
        for (String name : split) {
            this.participants.add(new Player(new Hand(), deck, name));
        }
    }

    public String getParticipants() {
        List<String> collect = participants.stream()
            .map(p -> p.getName())
            .collect(Collectors.toList());

        return String.join(",", collect);
    }

    public List<String> getFirstHands() {
        return participants.stream()
            .map(p -> p.getFirstHand())
            .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();

        for (Participant participant : participants) {
            if (participant instanceof Player) {
                players.add((Player) participant);
            }
        }
        return players;
    }

    public Croupier getCroupier() {
        for (Participant participant : participants) {
            if (participant instanceof Croupier) {
                return (Croupier) participant;
            }
        }

        throw new IllegalArgumentException("딜러가 항상 존재해야합니다.");
    }
}
