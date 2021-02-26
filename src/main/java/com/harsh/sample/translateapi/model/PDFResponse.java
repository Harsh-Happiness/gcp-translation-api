package com.harsh.sample.translateapi.model;

public class PDFResponse {
    private String text;

    public PDFResponse(String s) {
        text = s;
    }

    public PDFResponse() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
