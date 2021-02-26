package com.harsh.sample.translateapi.model;

public class PDFRequest {
    private String fileName;
    private String targetLangCode;

    public String getTargetLangCode() {
        return targetLangCode;
    }

    public void setTargetLangCode(String targetLangCode) {
        this.targetLangCode = targetLangCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
