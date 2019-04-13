package bohdan.papizhanskiy.schedule.service;

import bohdan.papizhanskiy.schedule.dto.request.AudienceRequest;
import bohdan.papizhanskiy.schedule.dto.response.AudienceResponse;
import bohdan.papizhanskiy.schedule.entity.Audience;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.repository.AudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AudienceService {


    @Autowired
    private AudienceRepository audienceRepository;

    private Audience audienceRequestToAudience(Audience audience, AudienceRequest audienceRequest) throws WrongInputException {
        if (audience == null) {
            audience = new Audience();
        }

        audience.setAudienceNumber(audienceRequest.getAudienceNumber());
        audience.setAudienceAddress(audienceRequest.getAudienceAddress());


        return audienceRepository.save(audience);
    }

    public List<AudienceResponse> findAll() {
        return audienceRepository.findAll().stream().map(AudienceResponse::new).collect(Collectors.toList());
    }

    public AudienceResponse save(AudienceRequest audienceRequest) throws WrongInputException {
        return new AudienceResponse(audienceRequestToAudience(null, audienceRequest));
    }

    public Audience findOne(Long id) throws WrongInputException {
        return audienceRepository.findById(id).orElseThrow(() -> new WrongInputException("Audience with " + id + " not exists"));
    }

    public void delete(Long id) throws WrongInputException {
        audienceRepository.delete(findOne(id));
    }

    public AudienceResponse update(Long id, AudienceRequest audienceRequest) throws WrongInputException {
        return new AudienceResponse(audienceRequestToAudience(findOne(id), audienceRequest));
    }
}
