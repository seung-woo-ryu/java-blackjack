package controller;

import static model.CompareUtil.compare;

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

        startFirstTwoDeal();

        progressPlayer();
        progressCroupier();

        compare(participants);

        view.printSumOfHand(participants.getFinalHandInfoListDto());
        view.printFianlReward(participants.getParticipantsResultDto());
    }

    private void betAmount() {
        for (Player player : participants.getPlayers()) {
            int betAmount = view.inputBettingAmount(player.getName());
            player.setBetAmount(betAmount);
        }
    }
    private void progressCroupier() {
        Croupier croupier = participants.getCroupier();

        if (croupier.isLowerThan16()) {
            view.printCroupierGetOneMoreCard();
            croupier.hit();
        }
    }

    private void progressPlayer() {
        for (Player player : participants.getPlayers()) {
            if (player.isBlackjack()) {
                continue;
            }

            getOneMoreCard(player);

            if (player.isBurst()) {
                view.printParticipantBurst(player.getName());
            }
        }
    }

    private void getOneMoreCard(Player player) {
        boolean isContinue;
        do {
            String yesOrNo = view.inputOneMoreCard(player.getName());
            isContinue = yesOrNo.equals("y");

            if (isContinue) {
                player.hit();
                view.printParticipantCard(player);
            }
        }
        while (isContinue && !player.isBurst());
    }

    private void startFirstTwoDeal() {
        participants.dealTwice();

        view.printFirstTowDeal(participants.toStringParticipantsNameWithDelimiter(), participants.getFirstHands());
    }

    private void initPlayers() {
        String players = view.inputPlayers();
        participants = new Participants(players,deck);
    }
}
