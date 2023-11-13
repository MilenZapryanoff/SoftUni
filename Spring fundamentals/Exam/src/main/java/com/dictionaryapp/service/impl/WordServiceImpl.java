package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.word.*;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.entity.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    private final LanguageRepository languageRepository;
    private final WordRepository wordRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public WordServiceImpl(LanguageRepository languageRepository, WordRepository wordRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.languageRepository = languageRepository;
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    /**
     * Creation of HomeViewModel of Lists<DTO>
     */
    @Override
    public WordHomeViewModel getHomeViewData() {
        List<GermanWordDTO> germanWords = wordRepository.findAllByLanguage_Name(LanguageName.GERMAN).stream().map(GermanWordDTO::createGermanDTOFromWord).toList();
        List<SpanishWordDTO> spanishWords = wordRepository.findAllByLanguage_Name(LanguageName.SPANISH).stream().map(SpanishWordDTO::createSpanishDTOFromWord).toList();
        List<FrenchWordDTO> frenchWords = wordRepository.findAllByLanguage_Name(LanguageName.FRENCH).stream().map(FrenchWordDTO::createFrenchDTOFromWord).toList();
        List<ItalianWordDTO> italianWords = wordRepository.findAllByLanguage_Name(LanguageName.ITALIAN).stream().map(ItalianWordDTO::createItalianDTOFromWord).toList();

        return new WordHomeViewModel(germanWords, spanishWords, frenchWords, italianWords);
    }

    /**
     * ADD new word implementation
     */
    @Override
    public void addWord(WordsAddBindingModel wordsAddBindingModel) {
        Language language = languageRepository.findByName(wordsAddBindingModel.getLanguage());

        if (language != null) {
            User currentUser = userRepository.findByUsername(loggedUser.getUsername());

            Word word = new Word();
            word.setTerm(wordsAddBindingModel.getTerm());
            word.setTranslation(wordsAddBindingModel.getTranslation());
            word.setExample(wordsAddBindingModel.getExample());
            word.setInputDate(wordsAddBindingModel.getInputDate());
            word.setAddedBy(currentUser);
            word.setLanguage(language);
            wordRepository.save(word);
        }
    }

    /**
     * Remove word implementation
     */
    @Override
    public void removeWord(Long id) {
        wordRepository.deleteById(id);
    }

    /**
     * Remove ALL words implementation
     */
    @Override
    public void removeAllWords() {
        wordRepository.deleteAll();
    }
}
