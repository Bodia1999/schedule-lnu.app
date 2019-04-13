package bohdan.papizhanskiy.schedule.dto.response;


import bohdan.papizhanskiy.schedule.entity.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class GroupResponse {

    private Long id ;
    private String name;
    private List<LessonToGroupResponse> lessonToGroupResponses = new ArrayList<>();


    public GroupResponse(Group group){
        id= group.getId();
        name = group.getName();
        lessonToGroupResponses = group.getLessonToGroup().stream().map(LessonToGroupResponse::new).collect(Collectors.toList());
    }
}
