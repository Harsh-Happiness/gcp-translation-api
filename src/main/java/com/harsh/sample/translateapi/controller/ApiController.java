package com.harsh.sample.translateapi.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.harsh.sample.translateapi.execption.TranslationException;
import com.harsh.sample.translateapi.model.TranslationRequest;
import com.harsh.sample.translateapi.model.TranslationResponse;
import com.google.cloud.translate.Translate.TranslateOption;

@RestController
public class ApiController {

	private static final String[] LANGUAGES = {
		    "af", "sq", "ar", "hy", "az", "eu", "be", "bn", "bs", "bg", "ca", "ceb", "ny", "zh-TW", "hr",
		    "cs", "da", "nl", "en", "eo", "et", "tl", "fi", "fr", "gl", "ka", "de", "el", "gu", "ht", "ha",
		    "iw", "hi", "hmn", "hu", "is", "ig", "id", "ga", "it", "ja", "jw", "kn", "kk", "km", "ko", "lo",
		    "la", "lv", "lt", "mk", "mg", "ms", "ml", "mt", "mi", "mr", "mn", "my", "ne", "no", "fa", "pl",
		    "pt", "ro", "ru", "sr", "st", "si", "sk", "sl", "so", "es", "su", "sw", "sv", "tg", "ta", "te",
		    "th", "tr", "uk", "ur", "uz", "vi", "cy", "yi", "yo", "zu"
		  };

	Translate translate = null;
	ApiController(){
		translate = TranslateOptions.builder().apiKey("AIzaSyBIc0lcZL4sRdJzkMvfcxTGvjvqcplMf20").build().service();
	}

	@RequestMapping(value="/" , method = {RequestMethod.GET})
	public String welcome(){
		return "this is home page";
	}
    @RequestMapping(value="/convertText" , method = {RequestMethod.GET})
    public String getTranslateRequest(@RequestParam String text){
    	if(text.length() > 0) {
    	text = text.replace("\"", "");
		Translation translation = translate.translate(
				text,
				TranslateOption.sourceLanguage("en"),
				TranslateOption.targetLanguage("hi")
		);

		System.out.printf("Text: %s%n", text);
		System.out.printf("Translation: %s%n", translation.translatedText());

		return translation.translatedText();
    	}
    	else {
    		return "Please provide the string in request.";
    	}
    }

    @RequestMapping(value="/translateText" , method = {RequestMethod.POST})
    public TranslationResponse translateRequestText(@RequestBody TranslationRequest request){

    	Translation translation;
    	try {
    	Set<String> supportedLanguages = new HashSet<>();
        for (String language : LANGUAGES) {
          supportedLanguages.add(language);
        }
    	if(supportedLanguages.contains(request.getSourceLanguageCode()) && supportedLanguages.contains(request.getTargetLangaugeCode())) {
		// Translates some text
    			translation = translate.translate(
				request.getText(),
				TranslateOption.sourceLanguage(request.getSourceLanguageCode()),
				TranslateOption.targetLanguage(request.getTargetLangaugeCode())
		);

    			return new TranslationResponse(translation.translatedText(),"Ok");
    	}
    	else {
    		throw new TranslationException("Invalid language codes entered");
    	}
    	}
    	catch(TranslationException e) {
    		return new TranslationResponse(e.getMessage());
    	}

    }
}
