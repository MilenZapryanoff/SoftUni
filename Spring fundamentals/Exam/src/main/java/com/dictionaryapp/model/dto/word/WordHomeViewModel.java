package com.dictionaryapp.model.dto.word;

import java.util.ArrayList;
import java.util.List;

public class WordHomeViewModel {

    private List<GermanWordDTO> germanWords;
    private List<SpanishWordDTO> spanishWords;
    private List<FrenchWordDTO> frenchWords;
    private List<ItalianWordDTO> italianWords;

    public WordHomeViewModel() {
        this.germanWords = new ArrayList<>();
        this.spanishWords = new ArrayList<>();
        this.frenchWords= new ArrayList<>();
        this.italianWords = new ArrayList<>();
    }

    public WordHomeViewModel(List<GermanWordDTO> germanWords, List<SpanishWordDTO> spanishWords, List<FrenchWordDTO> frenchWords, List<ItalianWordDTO> italianWords) {
        this.germanWords = germanWords;
        this.spanishWords = spanishWords;
        this.frenchWords = frenchWords;
        this.italianWords = italianWords;
    }

    public List<GermanWordDTO> getGermanWords() {
        return germanWords;
    }

    public void setGermanWords(List<GermanWordDTO> germanWords) {
        this.germanWords = germanWords;
    }

    public List<SpanishWordDTO> getSpanishWords() {
        return spanishWords;
    }

    public void setSpanishWords(List<SpanishWordDTO> spanishWords) {
        this.spanishWords = spanishWords;
    }

    public List<FrenchWordDTO> getFrenchWords() {
        return frenchWords;
    }

    public void setFrenchWords(List<FrenchWordDTO> frenchWords) {
        this.frenchWords = frenchWords;
    }

    public List<ItalianWordDTO> getItalianWords() {
        return italianWords;
    }

    public void setItalianWords(List<ItalianWordDTO> italianWords) {
        this.italianWords = italianWords;
    }
}
