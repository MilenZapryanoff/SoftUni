package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerSeedDto;
import softuni.exam.models.dto.SellerSeedRootDto;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    private static final String SELLERS_FILE_PATH = "src/main/resources/files/xml/sellers.xml";
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    //направили сме @Component xmlParser в utils за да обработваме XML-ите
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
//**     проверка дали са наляти данните в съответната таблица в DB */
        if (sellerRepository.count() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String readSellersFromFile() throws IOException {
//**     изчитане на файл и връщането му като String */
        return Files.readString(Path.of(SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

/**   3. Parse-ване на данните от XML-а
 *      3.1 с използване на Stream + /XmlParser, + Validator, + ModelMapper/  */

//        xmlParser.fromFile(SELLERS_FILE_PATH, SellerSeedRootDto.class)
//                .getSellers()
//                .stream()
//                .filter(sellerSeedDto -> {
//                    boolean isValid = validationUtil.isValid(sellerSeedDto);
//                    if (isValid) {
//                        stringBuilder.append(String.format("Successfully imported seller - %s - %s%n", sellerSeedDto.getLastName(), sellerSeedDto.getEmail()));
//                    } else {
//                        stringBuilder.append(String.format("Invalid seller%n"));
//                    }
//                    return isValid;
//                })
//                .map(sellerSeedDto -> modelMapper.map(sellerSeedDto, Seller.class))
//                .forEach(sellerRepository::save);


/**     3.2 БЕЗ използване на Stream /XmlParser, + с Validator 3.2.1 /без валидатор 3.2.2, + ModelMapper )/
 *      По този начин лесно мога да си намапвам ръчно полета при нужда (в случай, че нещо не се мапва, както трябва
 *      или при необходимост от търсене и сетване на някой от обектите) */

        SellerSeedRootDto sellerSeedRootDto = xmlParser.fromFile(SELLERS_FILE_PATH, SellerSeedRootDto.class);

        List<SellerSeedDto> sellers = sellerSeedRootDto.getSellers();
        for (SellerSeedDto currentSellerDto : sellers) {

/**          3.2.1  С използване на Validator -> */
            boolean isValid = validationUtil.isValid(currentSellerDto);
            if (isValid) {

/**          3.2.2  БЕЗ използване на Validator
 *           За целта ползвам моите валидации от isValid() метода в клас SellerSeedDto   */

//->           if (currentSeller.isValid()) {
                Seller seller = modelMapper.map(currentSellerDto, Seller.class);
                sellerRepository.save(seller);
                stringBuilder.append(String.format("Successfully imported seller - %s - %s%n", seller.getLastName(), seller.getEmail()));
            } else {
                stringBuilder.append(String.format("Invalid seller%n"));
            }
        }

        return stringBuilder.toString();
    }

    /**  използваме този метод за да си намерим/сетнем продавача при seed-ването на данните в OfferServiceImpl */
    @Override
    public Seller findById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }
}

