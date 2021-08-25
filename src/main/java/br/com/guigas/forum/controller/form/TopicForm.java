package br.com.guigas.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.guigas.forum.model.Course;
import br.com.guigas.forum.model.Topic;
import br.com.guigas.forum.repository.CourseRepository;

public class TopicForm {

	@NotEmpty
	@NotNull
	@Length(min = 5)
	private String title;
	@NotEmpty
	@NotNull
	@Length(min = 5)
	private String message;
	@NotEmpty
	@NotNull
	@Length(min = 5)
	private String courseName;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Topic convert(CourseRepository courseRepository) {
		Course course = courseRepository.findByName(courseName);
		return new Topic(this.title, this.message, course);
	}

}
