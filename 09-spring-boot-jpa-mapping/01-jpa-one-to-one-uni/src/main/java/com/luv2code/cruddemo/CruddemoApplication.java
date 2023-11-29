package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.dao.AppDAOImpl;
import com.luv2code.cruddemo.entity.InstructionDetail;
import com.luv2code.cruddemo.entity.Instructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			/*createInstructor(appDAO);*/
			/*findInstructorById(appDAO);*/
			/*deleteInstructor(appDAO);*/
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("DONE!");
	}

	private void findInstructorById(AppDAO appDAO) {
		int theId=1;
		Instructor instructor= appDAO.findInstructorById(theId);
		System.out.println(instructor);
		System.out.println(instructor.getInstructionDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor

		Instructor tempInstructor =
				new Instructor("Chad","Darby","darby@luvcode.com");

		InstructionDetail tempInstructorDetail =
								new InstructionDetail("www.luv2code.com",
										"Luv 2 code !!!");


	tempInstructor.setInstructionDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);

		// save the instructor

		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		appDAO.save(tempInstructor);
		System.out.println("DONE!");


	}
}
