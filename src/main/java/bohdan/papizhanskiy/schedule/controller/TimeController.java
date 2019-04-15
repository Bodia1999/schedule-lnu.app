package bohdan.papizhanskiy.schedule.controller;

import bohdan.papizhanskiy.schedule.dto.request.TimeRequest;
import bohdan.papizhanskiy.schedule.dto.response.TimeResponse;
import bohdan.papizhanskiy.schedule.entity.Time;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/time")
public class TimeController {
    @Autowired
    private TimeService timeService;

    @GetMapping
    public List<TimeResponse> findAll() {
        return timeService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        timeService.delete(id);
    }

    @PutMapping
    public TimeResponse update(@RequestParam Long id, @RequestBody TimeRequest timeRequest) throws WrongInputException {
        return timeService.update(id, timeRequest);
    }

    @PostMapping
    public TimeResponse save(@RequestBody TimeRequest timeRequest) throws WrongInputException {
        return timeService.save(timeRequest);

    }

    @PostMapping("/findOne")
    public TimeResponse findOne(@RequestParam Long id) throws WrongInputException {
        return new TimeResponse(timeService.findOne(id));
    }
}
