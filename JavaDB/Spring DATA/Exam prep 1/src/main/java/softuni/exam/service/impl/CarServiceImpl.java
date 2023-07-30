package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private static final String CARS_FILE_PATH = "src/main/resources/files/json/cars.json";

    private final CarRepository carRepository;
    //направили сме @Bean Gson в utils за да обработваме XML-ите
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CarServiceImpl(CarRepository carRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
//**     проверка дали са наляти данните в съответната таблица в DB */
        if (carRepository.count() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String readCarsFileContent() throws IOException {
//**     изчитане на файл и връщането му като String */
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

/**   1. Parse-ване на данните от JSON-а
 *      1.1 с използване на Stream + /GSON, + Validator, + ModelMapper/  */

//        Arrays.stream(gson.fromJson(readCarsFileContent(), CarSeedDto[].class))
//                .filter(carSeedDto -> {
//                    boolean isValid = validationUtil.isValid(carSeedDto);
//                    if (isValid) {
//                        stringBuilder.append(String.format("Successfully imported car - %s - %s%n", carSeedDto.getMake(), carSeedDto.getModel()));
//                    } else {
//                        stringBuilder.append(String.format("Invalid car%n"));
//                    }
//                    return isValid;
//                })
//                .map(carSeedDto -> modelMapper.map(carSeedDto, Car.class))
//                .forEach(carRepository::save);

/**     1.2 БЕЗ използване на Stream /GSON, + с Validator 3.2.1 /без валидатор 3.2.2, + ModelMapper )/
 *      По този начин лесно мога да си намапвам ръчно полета при нужда (в случай, че нещо не се мапва, както трябва
 *      или при необходимост от търсене и сетване на някой от обектите) */


        CarSeedDto[] carSeedDtos = gson.fromJson(readCarsFileContent(), CarSeedDto[].class);
        for (CarSeedDto currentCarDto : carSeedDtos) {

/**          1.2.1  С използване на Validator -> */
            boolean isValid = validationUtil.isValid(currentCarDto);
            if (isValid) {

/**          1.2.2  БЕЗ използване на Validator
 *           За целта ползвам моите валидации от isValid() метода в клас CarSeedDto   */

//->            if (currentCarDto.isValid()) {
                Car car = modelMapper.map(currentCarDto, Car.class);
                carRepository.save(car);
                stringBuilder.append(String.format("Successfully imported car - %s - %s%n", currentCarDto.getMake(), currentCarDto.getModel()));
            } else {
                stringBuilder.append(String.format("Invalid car%n"));
            }
        }

        return stringBuilder.toString();
    }

/**  използваме този метод за да си намерим/сетнем колата при seed-ването на данните в PictureServiceImpl и
 *   OfferServiceImpl */
    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder stringBuilder = new StringBuilder();
        
        List<Car> cars = carRepository.findAllCarsOrderByPicturesCountThenByMake();
        for (Car car : cars) {
            stringBuilder.append(String.format("Car make - %s, model - %s%n", car.getMake(), car.getModel()));
            stringBuilder.append(String.format("    Kilometers - %s%n", car.getKilometers()));
            stringBuilder.append(String.format("    Registered on - %s%n", car.getRegisteredOn()));
            stringBuilder.append(String.format("    Number of pictures - %s%n", car.getPictures().size()));
        }
        return stringBuilder.toString();
    }
}
