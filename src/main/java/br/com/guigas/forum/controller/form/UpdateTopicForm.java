package br.com.guigas.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.guigas.forum.model.Topic;
import br.com.guigas.forum.repository.TopicRepository;

public class UpdateTopicForm {

	@NotEmpty
	@NotNull
	@Length(min = 5)
	private String title;
	@NotEmpty
	@NotNull
	@Length(min = 5)
	private String message;

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

	public Topic update(Long id, TopicRepository topicRepository) {
		Topic topic = topicRepository.getOne(id);
		topic.setTitle(title);
		topic.setMessage(message);
		return topic;
	}

}
