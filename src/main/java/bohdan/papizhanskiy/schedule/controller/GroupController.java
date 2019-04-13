package bohdan.papizhanskiy.schedule.controller;

import bohdan.papizhanskiy.schedule.dto.request.GroupRequest;
import bohdan.papizhanskiy.schedule.dto.response.GroupResponse;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<GroupResponse> findAll() {
        return groupService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        groupService.delete(id);
    }

    @PutMapping
    public GroupResponse update(@RequestParam Long id, @RequestBody GroupRequest groupRequest) throws WrongInputException {
        return groupService.update(id, groupRequest);
    }

    @PostMapping
    public GroupResponse save(@RequestBody GroupRequest groupRequest) throws WrongInputException {
        return groupService.save(groupRequest);

    }

    @PostMapping("/findOne")
    public GroupResponse findOne(@RequestParam Long id) throws WrongInputException {
        return new GroupResponse(groupService.findOne(id));
    }
}
