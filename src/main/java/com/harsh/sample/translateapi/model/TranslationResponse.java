package com.harsh.sample.translateapi.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TranslationResponse {
	private String status;
	private String errorInfo;
	private Map<String,String> respTexts = new HashMap<>();
	private String convertedLangCode;
	private String prevLangCode;

	public TranslationResponse(String message) {
	}

	public TranslationResponse() {
	}

	public String getConvertedLangCode() {
		return convertedLangCode;
	}

	public void setConvertedLangCode(String convertedLangCode) {
		this.convertedLangCode = convertedLangCode;
	}

	public String getPrevLangCode() {
		return prevLangCode;
	}

	public void setPrevLangCode(String prevLangCode) {
		this.prevLangCode = prevLangCode;
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

	@JsonAnySetter
	public void addRespTexts(final String key, final String value){
		this.respTexts.put(key, value);
	}

	@JsonAnyGetter
	public Map<String, Object> getRespTexts() {
		return Collections.unmodifiableMap(this.respTexts);
	}

}
