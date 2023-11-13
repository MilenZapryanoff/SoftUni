package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LanguageInit implements CommandLineRunner {

    private final LanguageRepository languageRepository;

    public LanguageInit(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (languageRepository.count() == 0) {
            LanguageName[] languages = LanguageName.values();
            for (LanguageName currentLanguage : languages) {
                Language language = new Language();
                language.setName(currentLanguage);
                languageRepository.save(language);
            }
        }
    }
}