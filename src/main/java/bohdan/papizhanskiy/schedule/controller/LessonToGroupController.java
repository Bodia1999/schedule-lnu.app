package bohdan.papizhanskiy.schedule.controller;

import bohdan.papizhanskiy.schedule.dto.request.LessonToGroupRequest;
import bohdan.papizhanskiy.schedule.dto.response.LessonToGroupResponse;
import bohdan.papizhanskiy.schedule.entity.LessonToGroup;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.service.LessonToGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/lessonToGroup")
public class LessonToGroupController {

    @Autowired
    private LessonToGroupService lessonToGroupService;

    @GetMapping
    public List<LessonToGroupResponse> findAll(){
        return lessonToGroupService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestParam Long id ) throws WrongInputException {
        lessonToGroupService.delete(id);
    }

    @PutMapping
    public LessonToGroupResponse update (@RequestParam Long id , @RequestBody LessonToGroupRequest lessonToGroupRequest) throws WrongInputException {
        return lessonToGroupService.update(lessonToGroupRequest, id);
    }

    @PostMapping
    public LessonToGroupResponse save(@RequestBody LessonToGroupRequest lessonToGroupRequest) throws WrongInputException {
        return lessonToGroupService.save(lessonToGroupRequest);

    }

    @PostMapping("/findOne")
    public LessonToGroup findOne(@RequestParam Long id) throws WrongInputException {
        return lessonToGroupService.findOne(id);
    }
}
