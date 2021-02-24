package com.harsh.sample.translateapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

@SpringBootApplication
public class TranslateapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslateapiApplication.class, args);
		// Instantiates a client
//		Translate translate = TranslateOptions.builder().apiKey("AIzaSyCom4bHxaPIyqD4K30S1cJVB5CJWxciGjM").build().service();
//
//		// The text to translate
//		String text = "Hello, world!";
//
//		// Translates some text into Russian
//		Translation translation = translate.translate(
//				text,
//				TranslateOption.sourceLanguage("en"),
//				TranslateOption.targetLanguage("hi")
//		);
//
//		System.out.printf("Text: %s%n", text);
//		System.out.printf("Translation: %s%n", translation.translatedText());
	}

}
