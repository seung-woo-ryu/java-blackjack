package view;

public class Validator {

    private static final String Y = "y";
    private static final String N = "n";
    public static boolean validateName(String players) {
        String[] split = players.split(",");
        for (String name : split) {
            if (name.contains(" ")) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateBetAmount(String bet) {
        try {
            int intBet = Integer.parseInt(bet);
            return intBet > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validateYesOrNo(String yesOrNO) {
        return Y.equals(yesOrNO) || N.equals(yesOrNO);
    }
}
