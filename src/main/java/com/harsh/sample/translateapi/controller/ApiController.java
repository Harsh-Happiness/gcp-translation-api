package com.harsh.sample.translateapi.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.harsh.sample.translateapi.model.TranslationRequest;
import com.harsh.sample.translateapi.model.TranslationResponse;
import com.google.cloud.translate.Translate.TranslateOption;

@RestController
public class ApiController {

    @RequestMapping(value="/convertText" , method = {RequestMethod.POST})
    public String translateRequest(@RequestBody String text){
    	Translate translate = TranslateOptions.builder().apiKey("AIzaSyCom4bHxaPIyqD4K30S1cJVB5CJWxciGjM").build().service();

		// Translates some text 
		Translation translation = translate.translate(
				text,
				TranslateOption.sourceLanguage("en"),
				TranslateOption.targetLanguage("hi")
		);

		System.out.printf("Text: %s%n", text);
		System.out.printf("Translation: %s%n", translation.translatedText());
		
		return translation.translatedText();
    }
    
    @RequestMapping(value="/convertText" , method = {RequestMethod.GET})
    public String getTranslateRequest(@RequestParam String text){
    	Translate translate = TranslateOptions.builder().apiKey("AIzaSyCom4bHxaPIyqD4K30S1cJVB5CJWxciGjM").build().service();

		// Translates some text
    	
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
    	Translate translate = TranslateOptions.builder().apiKey("AIzaSyCom4bHxaPIyqD4K30S1cJVB5CJWxciGjM").build().service();

		// Translates some text 
		Translation translation = translate.translate(
				request.getText(),
				TranslateOption.sourceLanguage(request.getSourceLanguageCode()),
				TranslateOption.targetLanguage(request.getTargetLangaugeCode())
		);
		
		return new TranslationResponse(translation.translatedText());
    }
}
