package br.com.guigas.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guigas.forum.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

	public Page<Topic> findByCourseName(String courseName, Pageable pageRequest);

}
