package com.dictionaryapp.model.dto.word;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;

import java.time.LocalDate;

public class FrenchWordDTO {
    private Long id;
    private String term;
    private String translation;
    private String example;
    private LocalDate inputDate;
    private User addedBy;

    public FrenchWordDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public static FrenchWordDTO createFrenchDTOFromWord(Word word) {
        FrenchWordDTO frenchWordDTO = new FrenchWordDTO();

        frenchWordDTO.setId(word.getId());
        frenchWordDTO.setTerm(word.getTerm());
        frenchWordDTO.setTranslation(word.getTranslation());
        frenchWordDTO.setExample(word.getExample());
        frenchWordDTO.setInputDate(word.getInputDate());
        frenchWordDTO.setAddedBy(word.getAddedBy());
        return frenchWordDTO;
    }
}
