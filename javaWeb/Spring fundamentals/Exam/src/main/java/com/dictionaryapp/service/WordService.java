package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.word.WordHomeViewModel;
import com.dictionaryapp.model.dto.word.WordsAddBindingModel;

public interface WordService {


    WordHomeViewModel getHomeViewData();

    void addWord(WordsAddBindingModel wordsAddBindingModel);

    void removeWord(Long id);

    void removeAllWords();
}
