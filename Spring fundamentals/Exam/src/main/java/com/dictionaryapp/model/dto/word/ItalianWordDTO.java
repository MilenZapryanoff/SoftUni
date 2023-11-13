package com.dictionaryapp.model.dto.word;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;

import java.time.LocalDate;

public class ItalianWordDTO {
    private Long id;
    private String term;
    private String translation;
    private String example;
    private LocalDate inputDate;
    private User addedBy;

    public ItalianWordDTO() {
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

    public static ItalianWordDTO createItalianDTOFromWord(Word word) {
        ItalianWordDTO italianWordDTO = new ItalianWordDTO();

        italianWordDTO.setId(word.getId());
        italianWordDTO.setTerm(word.getTerm());
        italianWordDTO.setTranslation(word.getTranslation());
        italianWordDTO.setExample(word.getExample());
        italianWordDTO.setInputDate(word.getInputDate());
        italianWordDTO.setAddedBy(word.getAddedBy());
        return italianWordDTO;
    }
}
