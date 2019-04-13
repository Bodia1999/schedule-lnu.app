package bohdan.papizhanskiy.schedule.repository;

import bohdan.papizhanskiy.schedule.entity.Audience;
import bohdan.papizhanskiy.schedule.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long>, JpaSpecificationExecutor<Time> {
}
