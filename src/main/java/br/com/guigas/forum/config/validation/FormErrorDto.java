package br.com.guigas.forum.config.validation;

public class FormErrorDto {

	private String field;
	private String errorType;

	public FormErrorDto(String field, String errorType) {
		this.field = field;
		this.errorType = errorType;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

}
