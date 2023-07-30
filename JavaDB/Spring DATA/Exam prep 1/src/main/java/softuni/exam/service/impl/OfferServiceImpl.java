package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferSeedDto;
import softuni.exam.models.dto.OfferSeedRootDto;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository offerRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final CarService carService;
    private final SellerService sellerService;

    public OfferServiceImpl(OfferRepository offerRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, CarService carService, SellerService sellerService) {
        this.offerRepository = offerRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.carService = carService;
        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
//**     проверка дали са наляти данните в съответната таблица в DB */
        if (offerRepository.count() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String readOffersFileContent() throws IOException {
//**     изчитане на файл и връщането му като String */
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

/**   4. Parse-ване на данните от XML-а
 *      4.1 с използване на Stream + /XmlParser, + Validator, + ModelMapper/  */

//        xmlParser.fromFile(OFFERS_FILE_PATH, OfferSeedRootDto.class)
//                .getOffers()
//                .stream()
//                .filter(offerSeedDto -> {
//                    boolean isValid = validationUtil.isValid(offerSeedDto);
//                    if (isValid) {
//                        stringBuilder.append(String.format("Successfully imported offer - %s - %s%n", offerSeedDto.getAddedOn(), offerSeedDto.isHasGoldStatus()));
//                    } else {
//                        stringBuilder.append(String.format("Invalid offer%n"));
//                    }
//                    return isValid;
//                })
//                .map(offerSeedDto -> {
//                    Offer offer = modelMapper.map(offerSeedDto, Offer.class);
//                    offer.setCar(carService.findById(offerSeedDto.getCar().getId()));
//                    offer.setSeller(sellerService.findById(offer.getSeller().getId()));
//                    return offer;
//                })
//                .forEach(offerRepository::save);


/**     4.2 БЕЗ използване на Stream /XmlParser, + с Validator 3.2.1 /без валидатор 3.2.2, + ModelMapper )/
 *      По този начин лесно мога да си намапвам ръчно полета при нужда (в случай, че нещо не се мапва, както трябва
 *      или при необходимост от търсене и сетване на някой от обектите) */

        OfferSeedRootDto offerSeedRootDto = xmlParser.fromFile(OFFERS_FILE_PATH, OfferSeedRootDto.class);

        List<OfferSeedDto> offers = offerSeedRootDto.getOffers();
        for (OfferSeedDto currentOfferDto : offers) {

/**         4.2.1  С използване на Validator -> */
            boolean isValid = validationUtil.isValid(currentOfferDto);
            if (isValid) {

/**          4.2.2  БЕЗ използване на Validator
 *           За целта ползвам моите валидации от isValid() метода в клас SellerSeedDto   */

//->            if (currentOffer.isValid()) {
                Offer offer = modelMapper.map(currentOfferDto, Offer.class);

/**             търся и сет-вам колата след като я намеря по ID */
                offer.setCar(carService.findById(offer.getCar().getId()));
/**             търся и сет-вам продавача след като я намеря по ID */
                offer.setSeller(sellerService.findById(offer.getSeller().getId()));

                offerRepository.save(offer);
                stringBuilder.append(String.format("Successfully imported offer - %s - %s%n", offer.getAddedOn(), offer.getHasGoldStatus()));
            } else {
                stringBuilder.append(String.format("Invalid offer%n"));
            }
        }

        return stringBuilder.toString();
    }
}
