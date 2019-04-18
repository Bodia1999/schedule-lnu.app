package bohdan.papizhanskiy.schedule.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class LessonRequest {
    private String name;

    private Long teacherId;

    private Long timeId;

    private Long audienceId;

    private List<Long> lessonToGroupId = new ArrayList<>();
}
