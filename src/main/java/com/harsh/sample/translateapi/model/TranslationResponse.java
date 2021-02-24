package com.harsh.sample.translateapi.model;

public class TranslationResponse {
	private String translatedText;
	
	private String status;
	
	private String errorInfo;

	public TranslationResponse(String errorInfo) {
		super();
		this.errorInfo = errorInfo;
		this.status = "Error";
	}

	public TranslationResponse(String translatedText , String status) {
		super();
		this.translatedText = translatedText;
		this.status = status;
		this.errorInfo = errorInfo;
	}

	public TranslationResponse() {}

	public String getTranslatedText() {
		return translatedText;
	}

	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

}
