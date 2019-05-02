package bohdan.papizhanskiy.schedule.specification;


import bohdan.papizhanskiy.schedule.dto.request.LessonFilterRequest;
import bohdan.papizhanskiy.schedule.entity.Audience;
import bohdan.papizhanskiy.schedule.entity.Lesson;
import bohdan.papizhanskiy.schedule.entity.Teacher;
import bohdan.papizhanskiy.schedule.entity.Time;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class LessonSpecification implements Specification<Lesson> {


    private LessonFilterRequest lessonFilterRequest;

    public LessonSpecification(LessonFilterRequest lessonFilterRequest) {
        this.lessonFilterRequest = lessonFilterRequest;
    }

    @Override
    public Predicate toPredicate(Root<Lesson> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        Predicate byAudienceNumber = filterByAudienceNumber(root, criteriaBuilder);
        if (byAudienceNumber != null) predicates.add(byAudienceNumber);
        Predicate byDayOfTheWeek = filterByDayOfTheWeek(root, criteriaBuilder);
        if (byDayOfTheWeek != null) predicates.add(byDayOfTheWeek);
        Predicate byLessonName = filterByLessonName(root, criteriaBuilder);
        if (byLessonName != null) predicates.add(byLessonName);
        Predicate byTeacherName = filterByTeacherSurname(root, criteriaBuilder);
        if (byTeacherName!=null) predicates.add(byTeacherName);
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }


    private Predicate filterByAudienceNumber(Root<Lesson> root, CriteriaBuilder criteriaBuilder) {
        String audienceNumber = lessonFilterRequest.getAudienceNumber();
        if (audienceNumber == null || audienceNumber.trim().isEmpty()) {
            return null;
        }

        Join<Lesson, Audience> audienceRoot = root.join("audience");

        return criteriaBuilder.like(audienceRoot.get("audienceNumber"), lessonFilterRequest.getAudienceNumber());

    }

    private Predicate filterByDayOfTheWeek(Root<Lesson> root, CriteriaBuilder criteriaBuilder) {
        String dayOfTheWeek = lessonFilterRequest.getDayOfTheWeek();
        if (dayOfTheWeek == null || dayOfTheWeek.trim().isEmpty()) {
            return null;
        }

        Join<Lesson, Time> timeRoot = root.join("time");
        return criteriaBuilder.like(timeRoot.get("dayOfWeek"), lessonFilterRequest.getDayOfTheWeek()+'%');
    }

    private Predicate filterByLessonName(Root<Lesson> root, CriteriaBuilder criteriaBuilder) {
        String lessonName = lessonFilterRequest.getLessonName();
        if (lessonName == null || lessonName.trim().isEmpty()) {
            return null;
        }

        return criteriaBuilder.like(root.get("name"), '%' + lessonName + '%');
    }

    private Predicate filterByTeacherSurname(Root<Lesson> root, CriteriaBuilder criteriaBuilder) {
        String teacherSurname = lessonFilterRequest.getTeacherSurname();
        if (teacherSurname == null || teacherSurname.trim().isEmpty()) return null;
        Join<Lesson, Teacher> teacherRoot = root.join("teacher");

        return criteriaBuilder.like(teacherRoot.get("surname"), '%' + teacherSurname + '%');
    }


}
