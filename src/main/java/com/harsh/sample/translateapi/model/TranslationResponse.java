package com.harsh.sample.translateapi.model;

public class TranslationResponse {
	private String translatedText;

	public TranslationResponse(String translatedText) {
		super();
		this.translatedText = translatedText;
	}

	public TranslationResponse() {}

	public String getTranslatedText() {
		return translatedText;
	}

	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}

}
