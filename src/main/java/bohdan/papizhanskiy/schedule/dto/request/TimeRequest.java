package bohdan.papizhanskiy.schedule.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class TimeRequest {
    private String startTime;

    private String endTime;

    private String dayOfWeek;


//    private Long lessonId;
}
