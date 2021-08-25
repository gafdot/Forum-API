package br.com.guigas.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.guigas.forum.controller.dto.DetailedTopicDto;
import br.com.guigas.forum.controller.dto.TopicDto;
import br.com.guigas.forum.controller.form.TopicForm;
import br.com.guigas.forum.controller.form.UpdateTopicForm;
import br.com.guigas.forum.model.Topic;
import br.com.guigas.forum.repository.CourseRepository;
import br.com.guigas.forum.repository.TopicRepository;

@RestController
@RequestMapping(value = "/topics")
public class TopicController {

	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private CourseRepository courseRepository;

	@GetMapping
	public List<TopicDto> getTopics(String courseName) {
		if (courseName == null) {
			return TopicDto.convert(topicRepository.findAll());
		} else {
			System.out.println(courseName);
			return TopicDto.convert(topicRepository.findByCourseName(courseName));
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<TopicDto> postTopic(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
		Topic topic = form.convert(courseRepository);
		topicRepository.save(topic);
		URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicDto(topic));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DetailedTopicDto> getOneTopic(@PathVariable("id") Long code) {
		Optional<Topic> optional = topicRepository.findById(code);
		if (optional.isPresent()) {
			Topic topic = optional.get();
			return ResponseEntity.ok(new DetailedTopicDto(topic));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicDto> updateTopic(@PathVariable Long id, @RequestBody @Valid UpdateTopicForm form) {
		Optional<Topic> optional = topicRepository.findById(id);
		if (optional.isPresent()) {
			Topic topic = form.update(id, topicRepository);
			return ResponseEntity.ok(new TopicDto(topic));
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Optional<Topic> optional = topicRepository.findById(id);
		if (optional.isPresent()) {
			topicRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}
}
