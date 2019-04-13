package bohdan.papizhanskiy.schedule.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeacherRequest {

    private String name;

    private String surname;

    private String patronymic;

//    private Long lessonId;
}
