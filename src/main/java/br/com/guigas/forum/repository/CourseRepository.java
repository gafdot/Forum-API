package br.com.guigas.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guigas.forum.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	public Course findByName(String name);

}
