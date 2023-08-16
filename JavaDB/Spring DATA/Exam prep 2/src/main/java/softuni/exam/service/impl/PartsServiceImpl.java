package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartSeedDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class PartsServiceImpl implements PartsService {
    private static final String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";
    private final PartsRepository partsRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PartsServiceImpl(PartsRepository partsRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.partsRepository = partsRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        PartSeedDto[] partSeedDtos = gson.fromJson(readPartsFileContent(), PartSeedDto[].class);

        for (PartSeedDto currentPartDto : partSeedDtos) {
            if (isValid(currentPartDto)) {
                Part part = modelMapper.map(currentPartDto, Part.class);
                partsRepository.save(part);
                stringBuilder.append(String.format("Successfully imported part %s - %s%n", currentPartDto.getPartName(), currentPartDto.getPrice()));
            } else {
                stringBuilder.append(String.format("Invalid part%n"));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * изнесох проверката на цялото currentPartDto в отделен метод
     * в него използвам валидациите на Validator-a, както и моите проверки за уникалност на полета
     */
    private boolean isValid(PartSeedDto currentPartDto) {
        if (validationUtil.isValid(currentPartDto)
                && partsRepository.countByPartName(currentPartDto.getPartName()) == 0) {
            return true;
        }
        return false;
    }

    /** търся коя е частта по ID за да я сетна при импорта на задачите в TasksServiceImpl */
    @Override
    public Part findById(Long id) {
        return partsRepository.findById(id).orElse(null);
    }
}
