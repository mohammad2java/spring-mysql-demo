package rizvi.mysql;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rizvi.mysql.model.Student;
import rizvi.mysql.repo.StudentRepo;

@SpringBootApplication
public class SpringMysqlDemoApplication  implements CommandLineRunner{

@Autowired	
private StudentRepo repo;	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("saving student");
		Student student =  new Student("Amir", 35, "Mumbai");
		repo.save(student);
		System.out.println("saved student");		
		
		System.out.println("calling procedure");
		Student ret = repo.callProc(35);
		System.out.println("result: "+ret);
		
		System.out.println("calling function");
		Date retDate = repo.callFunct();
		System.out.println("result: "+retDate);
	}

}
