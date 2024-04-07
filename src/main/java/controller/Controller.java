package controller;

import java.util.List;
import model.Participants;
import model.participant.Croupier;
import model.participant.Player;
import view.View;

public class Controller {

    private View view;
    private Participants participants;

    public void run() {
        initPlayers();

        participants.betAmount();

        printFirstTowDeal();

        progressPlayer();
        progressCroupier();

        countResult();
        printResult();
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
        String[] handList = participants.getFirstHands();
        view.printFirstTowDeal(participantNameList, handList);
    }

    private void initPlayers() {
        String players = view.inputPlayers();
        participants = new Participants(players);
    }
}
