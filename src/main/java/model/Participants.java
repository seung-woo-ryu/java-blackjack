package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.dto.FinalHandInfoDto;
import model.dto.FInalHandInfoListDto;
import model.dto.ParticipantResultDto;
import model.dto.ParticipantResultListDto;
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

    public String toStringParticipantsNameWithDelimiter() {
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

    public void dealTwice() {
        for (Participant p : participants) {
            p.hit();
            p.hit();
        }
    }

    public FInalHandInfoListDto getFinalHandInfoListDto() {
        List<FinalHandInfoDto> collect = participants
            .stream()
            .map(participant -> new FinalHandInfoDto(
                participant.getName(),
                participant.getHand(),
                participant.getSumOfHand()))
            .collect(Collectors.toList());

        return new FInalHandInfoListDto(collect);
    }

    public ParticipantResultListDto getParticipantsResultDto() {
        List<ParticipantResultDto> collect = participants.stream()
            .map(participant -> ParticipantResultDto.of(participant.getName(), participant.getIncome()))
            .collect(Collectors.toList());
        return new ParticipantResultListDto(collect);
    }
}
