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
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startTime;

    private String endTime;

    private String dayOfWeek;

    @OneToMany(mappedBy = "time")
    private List<Lesson> lessons = new ArrayList<>();

}
