package softuni.exam.service;

import softuni.exam.models.entity.Star;

import java.io.IOException;

public interface StarService {

    boolean areImported();

    String readStarsFileContent() throws IOException;

    String importStars() throws IOException;

    String exportStars();

    Star findById(Long id);

    boolean countById(Long id);
}
