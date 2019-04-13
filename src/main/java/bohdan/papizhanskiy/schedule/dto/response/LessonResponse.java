package bohdan.papizhanskiy.schedule.dto.response;

import bohdan.papizhanskiy.schedule.entity.Lesson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LessonResponse {

    private Long id;
    private String name;
    private TimeResponse timeResponse;
    private TeacherResponse teacherResponse;
    private AudienceResponse audienceResponse;

    public LessonResponse(Lesson lesson){
        id = lesson.getId();
        name = lesson.getName();
        timeResponse = new TimeResponse(lesson.getTime());
        teacherResponse = new TeacherResponse(lesson.getTeacher());
        audienceResponse = new AudienceResponse(lesson.getAudience());
    }
}
