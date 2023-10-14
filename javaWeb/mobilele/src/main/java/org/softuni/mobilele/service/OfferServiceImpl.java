package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {
        //TODO: to create offer
        throw new UnsupportedOperationException("Coming soon");
    }
}
