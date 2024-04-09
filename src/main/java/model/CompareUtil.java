package model;

import java.util.List;
import model.participant.Croupier;
import model.participant.Player;

public class CompareUtil {

    public static void compare(Participants participants) {
        List<Player> players = participants.getPlayers();
        Croupier croupier = participants.getCroupier();

        for (Player player : players) {
            cal(player, croupier);
        }
    }

    private static void cal(Player player, Croupier croupier) {
        if (isPlayerWin(player,croupier)) {
            giveMoneyToPlayer(player, croupier);
        } else if (isCroupierWin(player,croupier)) {
            giveMoneyToCroupier(player, croupier);
        }
    }

    private static void giveMoneyToCroupier(Player player, Croupier croupier) {
        int betAmount = player.getBetAmount();
        player.calIncome(-betAmount);
        croupier.calIncome(betAmount);
    }

    private static void giveMoneyToPlayer(Player player, Croupier croupier) {
        int betAmount = player.getBetAmount();
        player.calIncome(betAmount);
        croupier.calIncome(-betAmount);
    }

    private static boolean isPlayerWin(Player player, Croupier croupier) {
        return !player.isBurst() &&
            (croupier.isBurst() || player.getSumOfHand() > croupier.getSumOfHand());
    }
    private static boolean isCroupierWin(Player player,Croupier croupier) {
        return player.isBurst() ||
            (!croupier.isBurst() && croupier.getSumOfHand() > player.getSumOfHand());
    }
}
