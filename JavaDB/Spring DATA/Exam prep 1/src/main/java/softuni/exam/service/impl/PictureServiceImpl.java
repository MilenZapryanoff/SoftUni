package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PictureSeedDto;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String PICTURES_FILE_PATH = "src/main/resources/files/json/pictures.json";
    private final ModelMapper modelMapper;
    private final PictureRepository pictureRepository;
    private final ValidationUtil validationUtil;
    private final CarService carService;
    //направили сме @Bean Gson в utils за да обработваме XML-ите
    private final Gson gson;


    public PictureServiceImpl(ModelMapper modelMapper, PictureRepository pictureRepository, ValidationUtil validationUtil, CarService carService, CarService carService1, Gson gson) {
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureRepository;
        this.validationUtil = validationUtil;
        this.carService = carService1;
        this.gson = gson;

    }

    @Override
    public boolean areImported() {
//**     проверка дали са наляти данните в съответната таблица в DB */
        if (pictureRepository.count() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
//**     изчитане на файл и връщането му като String */
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

/**   2. Parse-ване на данните от JSON-а
 *      2.1 с използване на Stream + /GSON, + Validator, + ModelMapper/  */


//        Arrays.stream(gson.fromJson(readPicturesFromFile(), PictureSeedDto[].class))
//                .filter(pictureSeedDto -> {
//                    boolean isValid = validationUtil.isValid(pictureSeedDto);
//                    if (isValid) {
//                        stringBuilder.append(String.format("Successfully imported picture - %s%n", pictureSeedDto.getName()));
//                    } else {
//                        stringBuilder.append(String.format("Invalid picture%n"));
//                    }
//                    return isValid;
//                })
//                .map(pictureSeedDto -> {
//                    Picture picture = modelMapper.map(pictureSeedDto, Picture.class);
//                    picture.setCar(carService.findById(pictureSeedDto.getCar()));
//                    return picture;
//                })
//                .forEach(pictureRepository::save);

/**     2.2 БЕЗ използване на Stream /GSON, + с Validator 3.2.1 /без валидатор 3.2.2, + ModelMapper )/
 *      По този начин лесно мога да си намапвам ръчно полета при нужда (в случай, че нещо не се мапва, както трябва
 *      или при необходимост от търсене и сетване на някой от обектите) */


        PictureSeedDto[] pictureSeedDtos = gson.fromJson(readPicturesFromFile(), PictureSeedDto[].class);
        for (PictureSeedDto currentPictureDto : pictureSeedDtos) {

/**          2.2.1  С използване на Validator -> */
            boolean isValid = validationUtil.isValid(currentPictureDto);
            if (isValid) {

/**          2.2.2  БЕЗ използване на Validator
 *           За целта ползвам моите валидации от isValid() метода в клас PictureSeedDto   */

//->            if (currentPictureDto.isValid()) {
                Picture picture = modelMapper.map(currentPictureDto, Picture.class);

/**             търсим колата за да я сетнем използвайки метод който сме си направили от carService */
                picture.setCar(carService.findById(currentPictureDto.getCar()));

                pictureRepository.save(picture);
                stringBuilder.append(String.format("Successfully imported picture - %s%n", currentPictureDto.getName()));
            } else {
                stringBuilder.append(String.format("Invalid picture%n"));
            }
        }

        return stringBuilder.toString();
    }
}
