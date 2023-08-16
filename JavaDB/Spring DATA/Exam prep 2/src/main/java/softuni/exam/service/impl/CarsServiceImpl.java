package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarSeedDto;
import softuni.exam.models.dto.CarSeedRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


@Service
public class CarsServiceImpl implements CarsService {
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";
    private final CarsRepository carsRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CarsServiceImpl(CarsRepository carsRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.carsRepository = carsRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        CarSeedRootDto carSeedRootDto = xmlParser.fromFile(CARS_FILE_PATH, CarSeedRootDto.class);

        List<CarSeedDto> cars = carSeedRootDto.getCars();
        for (CarSeedDto currentCarDto : cars) {
            if (isValid(currentCarDto)) {
                Car car = modelMapper.map(currentCarDto, Car.class);
                carsRepository.save(car);
                stringBuilder.append(String.format("Successfully imported car %s - %s%n", car.getCarMake(), car.getCarModel()));
            } else {
                stringBuilder.append(String.format("Invalid car%n"));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * изнесох проверката на цялото currentCarDto в отделен метод
     * в него използвам валидациите на Validator-a, както и моите проверки за уникалност на полета
     */
    private boolean isValid(CarSeedDto currentCarDto) {
        if (validationUtil.isValid(currentCarDto)
                && carsRepository.countByPlateNumber(currentCarDto.getPlateNumber()) == 0) {
            return true;
        }
        return false;
    }
    /** търся колата по ID за да я сетна при импорта на задачите в TasksServiceImpl */
    @Override
    public Car findById(Long id) {
        return carsRepository.findById(id).orElse(null);
    }
}
