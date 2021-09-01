package br.com.guigas.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.guigas.forum.model.Course;

@DataJpaTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private TestEntityManager em;

	@Test
	public void shouldReturnACourseWhenWeInputACorrectName() {
		
		Course html5 = new Course();
		html5.setName("HTML 5");
		html5.setSubject("Front-End");
		em.persist(html5);
		
		Course course = courseRepository.findByName("HTML 5");
		Assertions.assertNotNull(course);
		Assertions.assertEquals("HTML 5", course.getName());
	}

	@Test
	public void shouldNotReturnACourseWhenWeInputAWrongName() {
		Course course = courseRepository.findByName("HTML");
		Assertions.assertNull(course);
	}

}
