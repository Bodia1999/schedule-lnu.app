package bohdan.papizhanskiy.schedule.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AudienceRequest {

    private String audienceNumber;

    private String audienceAddress;
}
