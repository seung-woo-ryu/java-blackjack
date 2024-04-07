package model;

import java.util.ArrayList;
import java.util.List;
import model.participant.Croupier;
import model.participant.Participant;
import model.participant.Player;

public class Participants {

    private List<Participant> participants;

    public Participants(String participants) {
        // todo
    }

    public void betAmount() {
    }

    public String getParticipants() {
        return null;
    }

    public String[] getFirstHands() {
        return null;
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();

        for (Participant participant : participants) {
            if (participant instanceof Player) {
                players.add((participant);
            }
        }
        return null;
    }

    public Croupier getCroupier() {
        return null;
    }
}
