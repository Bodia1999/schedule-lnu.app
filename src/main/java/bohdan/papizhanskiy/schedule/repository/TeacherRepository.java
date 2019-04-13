package bohdan.papizhanskiy.schedule.repository;

import bohdan.papizhanskiy.schedule.entity.Audience;
import bohdan.papizhanskiy.schedule.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher> {
}
