package bohdan.papizhanskiy.schedule.service;

import bohdan.papizhanskiy.schedule.dto.request.TeacherRequest;
import bohdan.papizhanskiy.schedule.dto.response.LessonResponse;
import bohdan.papizhanskiy.schedule.dto.response.TeacherResponse;
import bohdan.papizhanskiy.schedule.entity.Teacher;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher findOne(Long id) throws WrongInputException {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new WrongInputException("Laptop with id " + id + " not exists"));
    }

    public List<TeacherResponse> findAll() {
        return teacherRepository.findAll().stream().map(TeacherResponse::new).collect(Collectors.toList());
    }

    public TeacherResponse save(TeacherRequest teacherRequest) throws WrongInputException {
        return new TeacherResponse(teacherRequestToTeacher(null, teacherRequest));
    }

    public TeacherResponse update(Long id, TeacherRequest teacherRequest) throws WrongInputException {
        return new TeacherResponse(teacherRequestToTeacher(findOne(id), teacherRequest));
    }

    private Teacher teacherRequestToTeacher(Teacher teacher, TeacherRequest teacherRequest) throws WrongInputException {
        if (teacher == null){
            teacher = new Teacher();
        }
        teacher.setName(teacherRequest.getName());
       teacher.setSurname(teacherRequest.getSurname());
       teacher.setPatronymic(teacherRequest.getPatronymic());


        return teacherRepository.save(teacher);
    }

    public void delete(Long id) throws WrongInputException {
        teacherRepository.delete(findOne(id));
    }
}
