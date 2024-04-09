package model.dto;

public class FinalHandInfoDto {

    public String getName() {
        return name;
    }

    public String getHand() {
        return hand;
    }

    public int getSum() {
        return sum;
    }

    public FinalHandInfoDto(String name, String hand, int sum) {
        this.name = name;
        this.hand = hand;
        this.sum = sum;
    }

    private String name;
    private String hand;
    private int sum;
}
