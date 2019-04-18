package bohdan.papizhanskiy.schedule.service;


import bohdan.papizhanskiy.schedule.dto.request.GroupRequest;
import bohdan.papizhanskiy.schedule.dto.response.GroupResponse;
import bohdan.papizhanskiy.schedule.entity.Group;
import bohdan.papizhanskiy.schedule.exception.WrongInputException;
import bohdan.papizhanskiy.schedule.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService  {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private LessonToGroupService lessonToGroupService;

    private Group groupRequestToGroup(Group group, GroupRequest groupRequest) throws WrongInputException {
        if (group == null) {
            group = new Group();
        }

        group.setName(groupRequest.getName());
//        for (Long lessonToGroup : groupRequest.getLessonToGroupId() ){
//            LessonToGroup lessonToGroup1 = lessonToGroupService.findOne(lessonToGroup);
//            group.getLessonToGroup().add(lessonToGroup1);
//        }


        return groupRepository.save(group);
    }

    public List<GroupResponse> findAll() {
        return groupRepository.findAll().stream().map(GroupResponse::new).collect(Collectors.toList());
    }

    public GroupResponse save(GroupRequest groupRequest) throws WrongInputException {
        return new GroupResponse(groupRequestToGroup(null, groupRequest));
    }

    public Group findOne(Long id) throws WrongInputException {
        return groupRepository.findById(id).orElseThrow(() -> new WrongInputException("Group with " + id + " not exists"));
    }

    public void delete(Long id) throws WrongInputException {
        groupRepository.delete(findOne(id));
    }

    public GroupResponse update(Long id, GroupRequest groupRequest) throws WrongInputException {
        return new GroupResponse(groupRequestToGroup(findOne(id), groupRequest));
    }

}
