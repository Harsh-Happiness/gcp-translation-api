package com.harsh.sample.translateapi.model;

public class TranslationRequest {

	private String text;

	private String sourceLanguageCode;
	
	private String targetLangaugeCode;

	public TranslationRequest(String text, String sourceLanguageCode, String targetLangaugeCode) {
		super();
		this.text = text;
		this.sourceLanguageCode = sourceLanguageCode;
		this.targetLangaugeCode = targetLangaugeCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSourceLanguageCode() {
		return sourceLanguageCode;
	}

	public void setSourceLanguageCode(String sourceLanguageCode) {
		this.sourceLanguageCode = sourceLanguageCode;
	}

	public String getTargetLangaugeCode() {
		return targetLangaugeCode;
	}

	public void setTargetLangaugeCode(String targetLangaugeCode) {
		this.targetLangaugeCode = targetLangaugeCode;
	}

}
