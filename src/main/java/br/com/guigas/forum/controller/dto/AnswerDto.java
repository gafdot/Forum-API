package br.com.guigas.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.guigas.forum.model.Answer;

public class AnswerDto {

	private Long id;
	private String authorName;
	private String message;
	private LocalDateTime creationDate;

	public AnswerDto(Answer answer) {
		this.id = answer.getId();
		this.authorName = answer.getAuthor().getName();
		this.message = answer.getMessage();
		this.creationDate = answer.getCreationDate();
	}

	public Long getId() {
		return id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

}
