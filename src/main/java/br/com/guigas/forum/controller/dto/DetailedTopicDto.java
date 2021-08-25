package br.com.guigas.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.guigas.forum.model.Topic;
import br.com.guigas.forum.model.TopicStatus;

public class DetailedTopicDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime date;
	private TopicStatus status;
	private String authorName;
	private String courseName;
	private List<AnswerDto> answers;

	public DetailedTopicDto(Topic topic) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.date = topic.getCreationDate();
		this.status = topic.getStatus();
		this.authorName = topic.getAuthor().getName();
		this.courseName = topic.getCourse().getName();
		this.answers = topic.getAnswers().stream().map(AnswerDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public TopicStatus getStatus() {
		return status;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getCourseName() {
		return courseName;
	}

	public List<AnswerDto> getAnswers() {
		return answers;
	}

}
