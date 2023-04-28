package domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IssueDto {
    private String user_Info;
    private Boolean isWoori;
}
