package br.com.guigas.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.guigas.forum.model.Topic;

public class TopicDto {

	private Long id;
	private String message;
	private String title;
	private LocalDateTime date;

	public TopicDto(Topic topic) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.date = topic.getCreationDate();
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public String getTitle() {
		return title;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public static List<TopicDto> convert(List<Topic> topics) {
		return topics.stream().map(TopicDto::new).collect(Collectors.toList());
	}

}
