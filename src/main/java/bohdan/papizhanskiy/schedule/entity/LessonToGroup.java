package bohdan.papizhanskiy.schedule.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class LessonToGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(mappedBy = "lessonToGroups")
    private List<Lesson> lesson = new ArrayList<>();

    @ManyToOne
    private Group group;

}


