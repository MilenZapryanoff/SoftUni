package softuni.exam.service;


import softuni.exam.models.entity.Mechanic;

import java.io.IOException;


public interface MechanicsService {

    boolean areImported();

    String readMechanicsFromFile() throws IOException;

    String importMechanics() throws IOException;

    boolean isMechanicValid(String name);

    Mechanic findByFirstName(String firstName);
}
