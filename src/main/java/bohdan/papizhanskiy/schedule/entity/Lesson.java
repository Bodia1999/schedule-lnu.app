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
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Time time;

    @ManyToOne
    private Teacher teacher;


    @ManyToOne
    private Audience audience;


    @OneToMany(mappedBy = "lesson")
    private List<LessonToGroup> lessonToGroups = new ArrayList<>();

   
}
