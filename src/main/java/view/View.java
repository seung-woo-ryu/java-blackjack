package view;

public class View {

    private String inputParticipantName = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private String inputBet = "${p_n}의 배팅 금액은?";
    private String printDealEnd = "${p_n, p_n}에게 2장의 카드를 나누었습니다";
    private String printParticipantHand = "${p_n}: ${카드,카드}";
    private String inputOneMoreCard = "${p_n}는 한장의 카드를 더 받겠습니까?(y,n)";
    private String printCroupierOneMoreCard = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private String printSumOfHand = "${p_n}: ${카드, 카드} - 결과: ${카드_합}";
    private String printParticipantBurst = "${p_n}는 버스트 상태가 되어 게임을 더 이상 진행 할 수가 없습니다";
    private String printEndResult =
        """
            ## 최종 수익
            ${p_n}: ${수익}
            ${p_n}: ${수익}
            ${p_n}: ${수익}
            """;
}
