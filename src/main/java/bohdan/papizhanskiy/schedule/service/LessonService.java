package bohdan.papizhanskiy.schedule.service;

import bohdan.papizhanskiy.schedule.dto.request.LessonFilterRequest;
import bohdan.papizhanskiy.schedule.dto.request.LessonRequest;
import bohdan.papizhanskiy.schedule.dto.request.PaginationRequest;
import bohdan.papizhanskiy.schedule.dto.response.DataResponse;
import bohdan.papizhanskiy.schedule.dto.response.LessonResponse;
import bohdan.papizhanskiy.schedule.entity.Lesson;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.repository.LessonRepository;
import bohdan.papizhanskiy.schedule.specification.LessonSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TimeService timeService;

    @Autowired
    private AudienceService audienceService;


    public List<LessonResponse> findAll() {
        return lessonRepository.findAll().stream().map(LessonResponse::new).collect(Collectors.toList());
    }

    public LessonResponse save(LessonRequest lessonRequest) throws WrongInputException {
        return new LessonResponse(lessonRequestToLesson(null, lessonRequest));
    }

    public LessonResponse update(Long id, LessonRequest lessonRequest) throws WrongInputException {
        return new LessonResponse(lessonRequestToLesson(findOne(id), lessonRequest));
    }

    private Lesson lessonRequestToLesson(Lesson lesson, LessonRequest lessonRequest) throws WrongInputException {
        if (lesson == null) {
            lesson = new Lesson();
        }
        lesson.setName(lessonRequest.getName());
        lesson.setTeacher(teacherService.findOne(lessonRequest.getTeacherId()));
        lesson.setTime(timeService.findOne(lessonRequest.getTimeId()));
        lesson.setAudience(audienceService.findOne(lessonRequest.getAudienceId()));

        return lessonRepository.save(lesson);
    }

    public void delete(Long id) throws WrongInputException {
        lessonRepository.delete(findOne(id));
    }


    public Lesson findOne(Long id) throws WrongInputException {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new WrongInputException("Laptop with id " + id + " not exists"));
    }

    public DataResponse<LessonResponse> findByFilter(LessonFilterRequest lessonFilterRequest) {
        Page<Lesson> page = lessonRepository.findAll(new LessonSpecification(lessonFilterRequest),
                lessonFilterRequest.getPagination().mapToPageRequest());

        return new DataResponse<>(page.get().map(LessonResponse::new).collect(Collectors.toList()), page.getTotalPages(), page.getTotalElements());

    }

    public DataResponse<LessonResponse> findAll(PaginationRequest paginationRequest) {
        Page<Lesson> all = lessonRepository.findAll(paginationRequest.mapToPageRequest());
        return new DataResponse<>(all.get().map(LessonResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
    }
}
