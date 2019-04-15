package bohdan.papizhanskiy.schedule.controller;

import bohdan.papizhanskiy.schedule.dto.request.LessonFilterRequest;
import bohdan.papizhanskiy.schedule.dto.request.LessonRequest;
import bohdan.papizhanskiy.schedule.dto.request.PaginationRequest;
import bohdan.papizhanskiy.schedule.dto.response.DataResponse;
import bohdan.papizhanskiy.schedule.dto.response.LessonResponse;
import bohdan.papizhanskiy.schedule.entity.Lesson;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping
    public List<LessonResponse> findAll(){
        return lessonService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestParam Long id ) throws WrongInputException {
        lessonService.delete(id);
    }

    @PutMapping
    public LessonResponse update (@RequestParam Long id , @RequestBody LessonRequest lessonRequest) throws WrongInputException {
        return lessonService.update(id, lessonRequest);
    }

    @PostMapping
    public LessonResponse save(@RequestBody LessonRequest lessonRequest) throws WrongInputException {
        return lessonService.save(lessonRequest);

    }

    @PostMapping("/findOne")
    public LessonResponse findOne(@RequestParam Long id) throws WrongInputException {
        return new LessonResponse(lessonService.findOne(id));
    }

    @PostMapping("/findByFilter")
    public DataResponse<LessonResponse> findByFilter(@RequestBody LessonFilterRequest lessonFilterRequest){
        return lessonService.findByFilter(lessonFilterRequest);
    }

    @PostMapping("/page")
    public DataResponse<LessonResponse> getPage(@RequestBody PaginationRequest request){
        return lessonService.findAll(request);
    }
}
