package model.dto;

public class ParticipantResultDto {
    private String name;
    private int income;

    public static ParticipantResultDto of(String name, int income) {
        return new ParticipantResultDto(name,income);
    }

    public String getName() {
        return name;
    }

    public int getIncome() {
        return income;
    }

    protected ParticipantResultDto(String name, int income) {
        this.name = name;
        this.income = income;
    }
}
