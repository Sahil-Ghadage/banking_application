package com.sahilg.banking.cards.service;

import com.sahilg.banking.cards.dto.CardsDTO;

public interface I_CardsService {

    void createCard(String mobileNumber);

    CardsDTO fetchCard(String mobileNumber);

    boolean updateCard(CardsDTO cardsDto);

    boolean deleteCard(String mobileNumber);

}
