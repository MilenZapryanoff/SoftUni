package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationSeedDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    private static String CONSTELLATIONS_FILE_PATH = "src/main/resources/files/json/constellations.json";
    private final ConstellationRepository constellationRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATIONS_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        ConstellationSeedDto[] constellationSeedDtos = gson.fromJson(readConstellationsFromFile(), ConstellationSeedDto[].class);
        for (ConstellationSeedDto currentConstellationDto : constellationSeedDtos) {
            if (isValid(currentConstellationDto)) {
                Constellation constellation = modelMapper.map(currentConstellationDto, Constellation.class);
                constellationRepository.save(constellation);
                stringBuilder.append(String.format("Successfully imported constellation %s - %s%n", constellation.getName(), constellation.getDescription()));
            } else {
                stringBuilder.append(String.format("Invalid constellation%n"));
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public Constellation findById(Long constellation) {
        return constellationRepository.findById(constellation).orElse(null);
    }

    private boolean isValid(ConstellationSeedDto currentConstellationDto) {
        return validationUtil.isValid(currentConstellationDto)
                && constellationRepository.countByName(currentConstellationDto.getName()) == 0;
    }
}
