package bohdan.papizhanskiy.schedule.controller;

import bohdan.papizhanskiy.schedule.dto.request.AudienceRequest;
import bohdan.papizhanskiy.schedule.dto.response.AudienceResponse;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.service.AudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/audience")
@RestController
public class AudienceController {

    @Autowired
    private AudienceService audienceService;

    @GetMapping
    private List<AudienceResponse> findAll() {
        return audienceService.findAll();
    }

    @PostMapping
    public AudienceResponse save(@RequestBody AudienceRequest audienceRequest) throws WrongInputException {
        return audienceService.save(audienceRequest);
    }

    @PutMapping
    public AudienceResponse update(@RequestParam Long id, @RequestBody AudienceRequest audienceRequest) throws WrongInputException {
        return audienceService.update(id, audienceRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        audienceService.delete(id);
    }

    @PostMapping("/findOne")
    public AudienceResponse findOne(@RequestParam Long id) throws WrongInputException {
        return new AudienceResponse(audienceService.findOne(id));
    }

}
