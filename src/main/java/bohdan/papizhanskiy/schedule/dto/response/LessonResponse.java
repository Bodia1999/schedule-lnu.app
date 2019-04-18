package bohdan.papizhanskiy.schedule.dto.response;

import bohdan.papizhanskiy.schedule.entity.Lesson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class LessonResponse {

    private Long id;
    private String name;
    private TimeResponse timeResponse;
    private TeacherResponse teacherResponse;
    private AudienceResponse audienceResponse;
    private List<LessonToGroupResponse> lessonToGroupResponses = new ArrayList<>();

    public LessonResponse(Lesson lesson){
        id = lesson.getId();
        name = lesson.getName();
        timeResponse = new TimeResponse(lesson.getTime());
        teacherResponse = new TeacherResponse(lesson.getTeacher());
        audienceResponse = new AudienceResponse(lesson.getAudience());
        lessonToGroupResponses = lesson.getLessonToGroups().stream().map(LessonToGroupResponse::new).collect(Collectors.toList());
    }
}
