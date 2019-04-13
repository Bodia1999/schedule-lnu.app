package bohdan.papizhanskiy.schedule.dto.response;

import bohdan.papizhanskiy.schedule.entity.Time;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class TimeResponse {

    private Long id;
    private String startTime;

    private String endTime;

    private String dayOfWeek;


//    private List<LessonResponse> lessons = new ArrayList<>();

    public TimeResponse(Time time){
        id = time.getId();
        startTime = time.getStartTime();
        endTime = time.getEndTime();
        dayOfWeek = time.getDayOfWeek();
//        lessons = time.getLessons().stream().map(LessonResponse::new).collect(Collectors.toList());
    }
}
