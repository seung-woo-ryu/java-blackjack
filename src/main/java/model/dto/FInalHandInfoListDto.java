package model.dto;

import java.util.List;

public class FInalHandInfoListDto {

    public List<FinalHandInfoDto> getFinalHandInfoDtoList() {
        return finalHandInfoDtoList;
    }

    private List<FinalHandInfoDto> finalHandInfoDtoList;

    public FInalHandInfoListDto(List<FinalHandInfoDto> finalHandInfoDtoList) {
        this.finalHandInfoDtoList = finalHandInfoDtoList;
    }
}
