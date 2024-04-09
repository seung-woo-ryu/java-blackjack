package model.dto;

import java.util.List;

public class ParticipantResultListDto {

    List<ParticipantResultDto> participantResultDtoList;

    public ParticipantResultListDto(List<ParticipantResultDto> participantResultDtoList) {
        this.participantResultDtoList = participantResultDtoList;
    }

    public List<ParticipantResultDto> getParticipantResultDtoList() {
        return participantResultDtoList;
    }
}
