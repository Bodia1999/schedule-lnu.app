package bohdan.papizhanskiy.schedule.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LessonFilterRequest {

    private String audienceNumber;

    private String lessonName;

    private String dayOfTheWeek;

    private String teacherSurname;

    private PaginationRequest pagination;

}
