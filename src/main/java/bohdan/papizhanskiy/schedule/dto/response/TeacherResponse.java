package bohdan.papizhanskiy.schedule.dto.response;

import bohdan.papizhanskiy.schedule.entity.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class TeacherResponse {
    private Long id;

    private String name;

    private String surname;

    private String patronymic;


//    private List<LessonResponse> lessonResponses = new ArrayList<>();

    public TeacherResponse (Teacher teacher){
        id = teacher.getId();
        name = teacher.getName();
        surname = teacher.getSurname();
        patronymic = teacher.getPatronymic();
//        lessonResponses = teacher.getLessons().stream().map(LessonResponse::new).collect(Collectors.toList());
    }
}
