package bohdan.papizhanskiy.schedule.repository;

import bohdan.papizhanskiy.schedule.entity.Audience;
import bohdan.papizhanskiy.schedule.entity.LessonToGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonToGroupRepository extends JpaRepository<LessonToGroup, Long>, JpaSpecificationExecutor<LessonToGroup> {
        List<LessonToGroup> findAllByGroup_Id(Long id);
}
