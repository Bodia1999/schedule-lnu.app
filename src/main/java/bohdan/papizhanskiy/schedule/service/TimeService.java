package bohdan.papizhanskiy.schedule.service;

import bohdan.papizhanskiy.schedule.dto.request.TeacherRequest;
import bohdan.papizhanskiy.schedule.dto.request.TimeRequest;
import bohdan.papizhanskiy.schedule.dto.response.TeacherResponse;
import bohdan.papizhanskiy.schedule.dto.response.TimeResponse;
import bohdan.papizhanskiy.schedule.entity.Teacher;
import bohdan.papizhanskiy.schedule.entity.Time;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time findOne(Long id) throws WrongInputException {
        return timeRepository.findById(id)
                .orElseThrow(() -> new WrongInputException("Time with id " + id + " not exists"));
    }

    public List<TimeResponse> findAll() {
        return timeRepository.findAll().stream().map(TimeResponse::new).collect(Collectors.toList());
    }

    public TimeResponse save(TimeRequest timeRequest) throws WrongInputException {
        return new TimeResponse(timeRequestToTime(null, timeRequest));
    }

    public TimeResponse update(Long id, TimeRequest timeRequest) throws WrongInputException {
        return new TimeResponse(timeRequestToTime(findOne(id), timeRequest));
    }

    private Time timeRequestToTime(Time time, TimeRequest timeRequest) throws WrongInputException {
        if (time == null){
            time = new Time();
        }

        time.setStartTime(timeRequest.getStartTime());
        time.setEndTime(timeRequest.getEndTime());
        time.setDayOfWeek(timeRequest.getDayOfWeek());



        return timeRepository.save(time);
    }

    public void delete(Long id) throws WrongInputException {
        timeRepository.delete(findOne(id));
    }

}
