package br.com.guigas.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guigas.forum.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

	public List<Topic> findByCourseName(String courseName);

}
