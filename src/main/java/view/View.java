package view;

import java.util.Scanner;

public class View {

    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    private String inputPlayers = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private String inputBettingAmount = "%s의 배팅 금액은?";
    private String printFirstTowDeal = "%s에게 2장의 카드를 나누었습니다";
    private String printParticipantHand = "%s: %s";
    private String inputOneMoreCard = "%s는 한장의 카드를 더 받겠습니까?(y,n)";
    private String printCroupierGetOneMoreCard = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private String printSumOfHand = "%s: %s - 결과: %d";
    private String printParticipantBurst = "%s는 버스트 상태가 되어 게임을 더 이상 진행 할 수가 없습니다";
    private String printEndResult = "## 최종 수익";
    private String printReward = "%s: %d";

    public String inputPlayers() {
        while (true) {
            System.out.println(inputPlayers);

            String players = scanner.next();
            if (Validator.validateName(players)) {
                return players;
            }

            System.out.println("잘못된 이름 형식입니다.");
        }
    }

    public int inputBettingAmount(String player) {
        while (true) {
            System.out.println(String.format(inputBettingAmount, player));
            String bet = scanner.next();
            if (Validator.validateBetAmount(bet)) {
                return Integer.parseInt(bet);
            }

            System.out.println("잘못된 금액입니다. 0 초과의 금액을 입력해주세요");
        }
    }

    public void printFirstTowDeal(String participants, String[] handList) {
        System.out.println(String.format(printFirstTowDeal,participants));
        for (String hand : handList) {
            System.out.println(hand);
        }
    }

    public String inputOneMoreCard() {
        while (true) {
            System.out.println(inputOneMoreCard);

            String yesOrNO = scanner.next();
            if (Validator.validateYesOrNo(yesOrNO)) {
                return yesOrNO;
            }

            System.out.println("y, n만 입력하세요.");
        }
    }

    public void printParticipantCard(String name, String hand) {
        System.out.println(String.format(printParticipantHand,name,hand));
    }

    public void printCroupierGetOneMoreCard() {
        System.out.println(printCroupierGetOneMoreCard);
    }

    public void printParticipantBurst(String name) {
        System.out.println(String.format(printParticipantBurst, name));
    }
    // todo: DTO로 바꾸기.
    public void printSumOfHand(String[] nameList, String[] handList, int[] sumList) {
        for (int i = 0; i < nameList.length; i++) {
            System.out.println(String.format(printSumOfHand, nameList[i], handList[i], sumList[i]));
        }
    }
    public void printEndResult(String[] nameList, int[] rewardList) {
        System.out.println(printEndResult);
        for (int i = 0; i < nameList.length; i++) {
            System.out.println(String.format(printReward,nameList[i],rewardList[i]));
        }
    }
}
