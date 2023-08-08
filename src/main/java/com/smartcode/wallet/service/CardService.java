package com.smartcode.wallet.service;

import com.smartcode.wallet.model.CardDto;

import java.util.List;

public interface CardService {

    CardDto createCard(CardDto cardDto);

    List<CardDto> getCardsByUserId(Integer userId);

    List<CardDto> deleteCardsByUserId(Integer userId);
    CardDto deleteCardById(Integer id);

    CardDto getCardById(Integer id);
}