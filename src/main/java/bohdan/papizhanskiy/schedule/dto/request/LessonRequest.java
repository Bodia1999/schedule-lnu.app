package bohdan.papizhanskiy.schedule.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class LessonRequest {
    private String name;

    private Long teacherId;

    private Long timeId;

    private Long audienceId;
}
