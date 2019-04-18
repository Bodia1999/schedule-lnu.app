package bohdan.papizhanskiy.schedule.repository;

import bohdan.papizhanskiy.schedule.entity.Audience;
import bohdan.papizhanskiy.schedule.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>, JpaSpecificationExecutor<Group> {
}
