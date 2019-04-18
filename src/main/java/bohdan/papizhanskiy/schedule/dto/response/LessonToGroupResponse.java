package bohdan.papizhanskiy.schedule.dto.response;

import bohdan.papizhanskiy.schedule.entity.LessonToGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class LessonToGroupResponse {

    private Long id;

    private GroupResponse groupResponse;

    public LessonToGroupResponse(LessonToGroup lessonToGroup) {
        id = lessonToGroup.getId();
        groupResponse = new GroupResponse(lessonToGroup.getGroup());
//        groupResponse = lessonToGroup.getGroups().stream().map(GroupResponse::new).collect(Collectors.toList());
    }
}
