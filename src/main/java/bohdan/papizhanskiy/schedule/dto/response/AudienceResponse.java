package bohdan.papizhanskiy.schedule.dto.response;

import bohdan.papizhanskiy.schedule.entity.Audience;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AudienceResponse {

    private Long id;

    private String audienceNumber;

    private String audienceAddress;

    public AudienceResponse(Audience audience){
        id = audience.getId();
        audienceNumber = audience.getAudienceNumber();
        audienceAddress = audience.getAudienceAddress();

    }
}
