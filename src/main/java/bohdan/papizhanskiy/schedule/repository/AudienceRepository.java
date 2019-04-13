package bohdan.papizhanskiy.schedule.repository;

import bohdan.papizhanskiy.schedule.entity.Audience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AudienceRepository extends JpaRepository<Audience,Long>, JpaSpecificationExecutor<Audience> {
}
