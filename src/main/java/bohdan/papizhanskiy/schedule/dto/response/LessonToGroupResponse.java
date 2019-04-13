package bohdan.papizhanskiy.schedule.dto.response;

import bohdan.papizhanskiy.schedule.entity.LessonToGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LessonToGroupResponse {

    private Long id;

    private LessonResponse lessonResponse;

    public LessonToGroupResponse(LessonToGroup lessonToGroup) {
        id = lessonToGroup.getId();
        lessonResponse = new LessonResponse(lessonToGroup.getLesson());
    }
}
