package bohdan.papizhanskiy.schedule.controller;

import bohdan.papizhanskiy.schedule.dto.request.TeacherRequest;
import bohdan.papizhanskiy.schedule.dto.response.TeacherResponse;
import bohdan.papizhanskiy.schedule.entity.Teacher;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<TeacherResponse> findAll(){
        return teacherService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestParam Long id ) throws WrongInputException {
        teacherService.delete(id);
    }

    @PutMapping
    public TeacherResponse update (@RequestParam Long id , @RequestBody TeacherRequest teacherRequest) throws WrongInputException {
        return teacherService.update(id, teacherRequest);
    }

    @PostMapping
    public TeacherResponse save(@RequestBody TeacherRequest teacherRequest) throws WrongInputException {
        return teacherService.save(teacherRequest);

    }

    @PostMapping("/findOne")
    public TeacherResponse findOne(@RequestParam Long id) throws WrongInputException {
        return new TeacherResponse(teacherService.findOne(id));
    }
}
