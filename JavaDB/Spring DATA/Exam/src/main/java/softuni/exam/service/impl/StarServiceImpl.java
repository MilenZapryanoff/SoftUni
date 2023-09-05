package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarSeedDto;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

@Service
public class StarServiceImpl implements StarService {

    private static String STARS_FILE_PATH = "src/main/resources/files/json/stars.json";
    private final StarRepository starRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final ConstellationService constellationService;

    public StarServiceImpl(StarRepository starRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, ConstellationService constellationService) {
        this.starRepository = starRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.constellationService = constellationService;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        StarSeedDto[] starSeedDtos = gson.fromJson(readStarsFileContent(), StarSeedDto[].class);
        for (StarSeedDto currentStarDto : starSeedDtos) {
            if (isValid(currentStarDto)) {
                Star star = modelMapper.map(currentStarDto, Star.class);
                star.setConstellation(constellationService.findById(currentStarDto.getConstellation()));

                starRepository.save(star);
                stringBuilder.append(String.format(Locale.US, "Successfully imported star %s - %.2f light years%n", star.getName(), star.getLightYears()));
            } else {
                stringBuilder.append(String.format("Invalid star%n"));
            }
        }
        return stringBuilder.toString();
    }

    private boolean isValid(StarSeedDto currentStarDto) {
        return validationUtil.isValid(currentStarDto)
                && starRepository.countByName(currentStarDto.getName()) == 0;
    }

    @Override
    public Star findById(Long id) {
        return starRepository.findById(id).orElse(null);
    }

    @Override
    public boolean countById(Long id) {
        if (starRepository.countById(id) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String exportStars() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Star> stars = starRepository.findStarsByStarTypeOrderByLightYearsAsc();

        for (Star star : stars) {
            stringBuilder.append(String.format("Star: %s%n", star.getName()));
            stringBuilder.append(String.format(Locale.US, "   *Distance: %.2f light years%n", star.getLightYears()));
            stringBuilder.append(String.format("   **Description: %s%n", star.getDescription()));
            stringBuilder.append(String.format("   ***Constellation: %s%n", star.getConstellation().getName()));
        }

        return stringBuilder.toString();
    }
}
