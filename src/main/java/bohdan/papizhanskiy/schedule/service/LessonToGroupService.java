package bohdan.papizhanskiy.schedule.service;

import bohdan.papizhanskiy.schedule.dto.request.LessonToGroupRequest;
import bohdan.papizhanskiy.schedule.dto.response.LessonToGroupResponse;
import bohdan.papizhanskiy.schedule.entity.LessonToGroup;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.repository.LessonToGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonToGroupService {

    @Autowired
    private LessonToGroupRepository lessonToGroupRepository;


    @Autowired
    private LessonService lessonService;

    @Autowired
    private GroupService groupService;

    public LessonToGroup findOne(Long id) throws WrongInputException {
        return lessonToGroupRepository.findById(id)
                .orElseThrow(() -> new WrongInputException("LessonToGroup for order with id " + id + " not exists"));
    }

    public LessonToGroupResponse save(LessonToGroupRequest lessonToGroupRequest) throws WrongInputException {
        return new LessonToGroupResponse(lessonToGroupRequestToLessonToGroup(lessonToGroupRequest,null));
    }

    public LessonToGroupResponse update (LessonToGroupRequest lessonToGroupRequest, Long id) throws WrongInputException {
        return new LessonToGroupResponse(lessonToGroupRequestToLessonToGroup(lessonToGroupRequest,findOne(id)));
    }

    private LessonToGroup lessonToGroupRequestToLessonToGroup(LessonToGroupRequest lessonToGroupRequest, LessonToGroup lessonToGroup) throws WrongInputException {
        if (lessonToGroup == null) {
            lessonToGroup = new LessonToGroup();
        }
        lessonToGroup.setGroup(groupService.findOne(lessonToGroupRequest.getGroupId()));

//        lessonToGroup.setLesson(lessonService.findOne(lessonToGroupRequest.getLessonId()));


//        productForOrder = productForOrderRepository.save(productForOrder);
//        for (Long order : productForOrderRequest.getOrderId() ){
//            Order order1 = orderService.findOne(order);
//            productForOrder.getOrders().add(order1);
//        }
//        productForOrder.setLaptop(laptopService.findOne(productForOrderRequest.getLaptopId()));
        return lessonToGroupRepository.save(lessonToGroup);

    }

    public List<LessonToGroupResponse> findAll (){
        return lessonToGroupRepository.findAll().stream().map(LessonToGroupResponse::new).collect(Collectors.toList());
    }

    public void delete(Long id )throws WrongInputException{
        lessonToGroupRepository.delete(findOne(id));
    }

    public List<LessonToGroupResponse> findAllByGroupId(Long id){
        return lessonToGroupRepository.findAllByGroup_Id(id).stream().map(LessonToGroupResponse::new).collect(Collectors.toList());
    }

//    public List<LessonToGroupResponse> findAllByLessonId(Long id){
//        return lessonToGroupRepository.findAllByLessonId(id).stream().map(LessonToGroupResponse::new).collect(Collectors.toList());
//    }
}
