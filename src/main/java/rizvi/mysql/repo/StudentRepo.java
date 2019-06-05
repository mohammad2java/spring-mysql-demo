package rizvi.mysql.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import rizvi.mysql.model.Student;

@Component
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	@Query(value="call myproc22(:age)",nativeQuery=true)
	public Student callProc(int age);
	
	
	@Query(value="select getDate()",nativeQuery=true)
	public Date callFunct();

}
