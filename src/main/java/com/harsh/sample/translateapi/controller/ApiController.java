package com.harsh.sample.translateapi.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger logger =LoggerFactory.getLogger(ApiController.class);

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
		translate = TranslateOptions.builder().apiKey("AIzaSyDoWmPNu3z8EiPApQHjmWaoyhhTYKD9Yd8").build().service();
	}

	@RequestMapping(value="/" , method = {RequestMethod.GET})
	public String welcome(){
		return "This is translation page.";
	}


    @RequestMapping(value="/translateText" , method = {RequestMethod.POST})
    public TranslationResponse translateRequestText(@RequestBody TranslationRequest request){
    	try {
    	Set<String> supportedLanguages = new HashSet<>();
        for (String language : LANGUAGES) {
          supportedLanguages.add(language);
        }
    	if(supportedLanguages.contains(request.getSourceLangCode())
				&& supportedLanguages.contains(request.getTargetLangCode())) {
			logger.info("Source language is : [{}] And Target Language is : [{}]", request.getSourceLangCode(), request.getTargetLangCode());
    		TranslationResponse response = new TranslationResponse();

			for(Map.Entry<String, String> entries : request.getExtra().entrySet() ) {
				String txtToConvert = entries.getValue();
				logger.info("key is : [{}]  and text to convert is : [{}]", entries.getKey() , txtToConvert);
				Translation translation = translate.translate(
						txtToConvert,
						TranslateOption.sourceLanguage(request.getSourceLangCode()),
						TranslateOption.targetLanguage(request.getTargetLangCode())
				);

				response.addRespTexts(entries.getKey(), translation.translatedText());
			}

			response.setPrevLangCode(request.getSourceLangCode());
			response.setConvertedLangCode(request.getTargetLangCode());
			response.setStatus("OK");
			return response;
    	}
    	else {
    		throw new TranslationException("Invalid language codes entered");
    	}
    	}
    	catch(TranslationException e) {
    		return new TranslationResponse(e.getMessage());
    	}

    }

//    TODO : web Client impl
}
