package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerSeedDto;
import softuni.exam.models.dto.AstronomerSeedRootDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

@Service
public class AstronomerServiceImpl implements AstronomerService {
    private static String ASTRONOMERS_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";
    private final AstronomerRepository astronomerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final StarService starService;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, StarService starService) {
        this.astronomerRepository = astronomerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.starService = starService;
    }

    @Override
    public boolean areImported() {
        return astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        AstronomerSeedRootDto astronomerSeedRootDto = xmlParser.fromFile(ASTRONOMERS_FILE_PATH, AstronomerSeedRootDto.class);

        List<AstronomerSeedDto> astronomers = astronomerSeedRootDto.getAstronomers();
        for (AstronomerSeedDto currentAstronomerDto : astronomers) {
            if (isValid(currentAstronomerDto)) {
                Astronomer astronomer = modelMapper.map(currentAstronomerDto, Astronomer.class);

                astronomer.setObservingStar(starService.findById(currentAstronomerDto.getObservingStarId()));

                astronomerRepository.save(astronomer);
                stringBuilder.append(String.format(Locale.US, "Successfully imported astronomer %s %s - %.2f%n", astronomer.getFirstName(), astronomer.getLastName(), astronomer.getAverageObservationHours()));
            } else {
                stringBuilder.append(String.format("Invalid astronomer%n"));
            }
        }
        return stringBuilder.toString();
    }

    private boolean isValid(AstronomerSeedDto currentAstronomerDto) {
        if (validationUtil.isValid(currentAstronomerDto)
                && astronomerRepository.countByFirstNameAndLastName(currentAstronomerDto.getFirstName(), currentAstronomerDto.getLastName()) == 0
                && starService.countById(currentAstronomerDto.getObservingStarId())) {
            return true;
        }
        return false;
    }
}
