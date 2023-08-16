package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicSeedDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class MechanicsServiceImpl implements MechanicsService {
    private static final String MECHANICS_FILE_PATH = "src/main/resources/files/json/mechanics.json";
    private final MechanicsRepository mechanicsRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.mechanicsRepository = mechanicsRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        MechanicSeedDto[] mechanicSeedDtos = gson.fromJson(readMechanicsFromFile(), MechanicSeedDto[].class);

        for (MechanicSeedDto currentMechanicDto : mechanicSeedDtos) {
            if (isValid(currentMechanicDto)) {
                Mechanic mechanic = modelMapper.map(currentMechanicDto, Mechanic.class);
                mechanicsRepository.save(mechanic);
                stringBuilder.append(String.format("Successfully imported mechanic %s %s%n", currentMechanicDto.getFirstName(), currentMechanicDto.getLastName()));
            } else {
                stringBuilder.append(String.format("Invalid mechanic%n"));
            }
        }
        return stringBuilder.toString();
    }


    /**
     * изнесох проверката на цялото currentMechanicDto в отделен метод
     * в него използвам валидациите на Validator-a, както и моите проверки за уникалност на полета
     */
    private boolean isValid(MechanicSeedDto currentMechanicDto) {
        if (validationUtil.isValid(currentMechanicDto)
                && mechanicsRepository.countByFirstName(currentMechanicDto.getFirstName()) == 0
                && mechanicsRepository.countByEmail(currentMechanicDto.getEmail()) == 0
                && mechanicsRepository.countByPhone(currentMechanicDto.getPhone()) == 0) {
            return true;
        }
        return false;
    }

    /** правя допълнителна проверка която използвам при импорта на задачите в TasksServiceImpl
     * дали има такъв механик по първо име */
    @Override
    public boolean isMechanicValid(String name) {
        if (mechanicsRepository.countByFirstName(name) > 0) {
            return true;
        }
        return false;
    }
    /** търся кой е механика по първо име за да го сетна при импорта на задачите в TasksServiceImpl */
    @Override
    public Mechanic findByFirstName(String firstName) {
        return mechanicsRepository.findByFirstName(firstName);
    }
}
