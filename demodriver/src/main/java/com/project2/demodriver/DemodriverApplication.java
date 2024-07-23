package com.project2.demodriver;

import com.project2.demodriver.entity.Student;
import com.project2.demodriver.entity.StudentDAO;
import com.project2.demodriver.entity.StudentDAOImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class DemodriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemodriverApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner->{

//			createstudent(studentDAO);
//			findstudent(studentDAO);



//			findAllStudent(studentDAO);

//			lastNameStudent(studentDAO);

//			updateStudent(studentDAO);

			deleteObject(studentDAO);
		};
	}

	private void deleteObject(StudentDAO studentDAO) {

		studentDAO.deleteBylastname();
	}

	private void updateStudent(StudentDAO studentDAO) {

		studentDAO.updateObject(1);

	}

	private void lastNameStudent(StudentDAO studentDAO) {

		List<Student> temp=studentDAO.findByLastName("laila");

		for(Student x:temp)
		{
			System.out.println(x);
		}
	}


	private void findAllStudent(StudentDAO studentDAO) {

		List<Student> tempList=studentDAO.findAll();
		for(Student x:tempList)
		{
			System.out.println(x);
		}

	}

	private void findstudent(StudentDAO studentDAO) {

		Student temp1=new Student("jayakumar","hus","jk@google.com");
		studentDAO.save(temp1);
		int x=temp1.getId();
		Student y=studentDAO.findById(x);
		System.out.println(y);





	}


	private  void createstudent(StudentDAO    studentDAO)
	{
		Student obj=new Student("Vaishnuuu","moon","amazon@gamil.com");

		studentDAO.save(obj);
	}

}
