package model.enums;

public enum Suit {
    HEART("HEART"),
    DIAMOND("DIAMOND"),
    CLUB("CLUB"),
    SPADE("SPADE");

    private String name;

    Suit(String name) {
        this.name = name;
    }
}
