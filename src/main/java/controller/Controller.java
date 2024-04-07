package controller;

import java.util.List;
import model.Deck;
import model.Participants;
import model.participant.Croupier;
import model.participant.Player;
import view.View;

public class Controller {

    private View view;
    private Participants participants;
    private Deck deck;
    public Controller(View view, Deck deck) {
        this.view = view;
        this.deck = deck;
    }

    public void run() {
        initPlayers();

        betAmount();

        printFirstTowDeal();

        progressPlayer();
        progressCroupier();

        countResult();
        printResult();
    }

    private void betAmount() {
        List<Player> players = participants.getPlayers();
        for (Player player : players) {
            int betAmount = view.inputBettingAmount(player.getName());
            player.setBetAmount(betAmount);
        }
    }

    private void printResult() {
    }

    private void countResult() {
    }

    private void progressCroupier() {
        Croupier croupier = participants.getCroupier();

        if (croupier.isLowerThan16()) {
            croupier.hit();
        }
    }

    private void progressPlayer() {
        for (Player player : participants.getPlayers()) {
            if (player.isBlackjack()) {
                continue;
            }

            getOneMoreCard(player);
        }
    }

    private void getOneMoreCard(Player player) {
        boolean isContinue;
        do {
            isContinue = view.inputOneMoreCard().equals("y");
            if (isContinue) {
                player.hit();
            }
        }
        while (isContinue && !player.isBurst());

        if (player.isBurst()) {
            view.printParticipantBurst(player.getName());
        }
    }

    private void printFirstTowDeal() {
        String participantNameList = participants.getParticipants();
        List<String> handList = participants.getFirstHands();
        view.printFirstTowDeal(participantNameList, handList);
    }

    private void initPlayers() {
        String players = view.inputPlayers();
        participants = new Participants(players,deck);
    }
}
