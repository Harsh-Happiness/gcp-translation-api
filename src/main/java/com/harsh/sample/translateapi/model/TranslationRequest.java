package com.harsh.sample.translateapi.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TranslationRequest {

	private String sourceLangCode;
	private String targetLangCode;
	private Map<String,String> langTexts = new HashMap<>();

	@JsonAnySetter
	public void addExtra(final String key, final String value){
		this.langTexts.put(key, value);
	}

	@JsonAnyGetter
	public Map<String, String> getExtra() {
		return Collections.unmodifiableMap(this.langTexts);
	}

	public String getSourceLangCode() {
		return sourceLangCode;
	}

	public void setSourceLangCode(String sourceLangCode) {
		this.sourceLangCode = sourceLangCode;
	}

	public String getTargetLangCode() {
		return targetLangCode;
	}

	public void setTargetLangCode(String targetLangCode) {
		this.targetLangCode = targetLangCode;
	}
}
