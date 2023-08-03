package com.smartcode.wallet.service.impl;

import com.smartcode.wallet.mapper.CardMapper;
import com.smartcode.wallet.model.CardDto;
import com.smartcode.wallet.model.CardEntity;
import com.smartcode.wallet.repository.CardRepository;
import com.smartcode.wallet.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Transactional
    @Override
    public CardDto createCard(CardDto cardDto) {
        CardEntity entity = cardMapper.toEntity(cardDto);
        CardEntity save = cardRepository.save(entity);
        return cardMapper.toDto(save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CardDto> getCardByUserId(Integer userId) {
        List<CardEntity> cards = cardRepository.findAllByUserId(userId);
        List<CardDto> dtoCards = new ArrayList<>();
        for (CardEntity card : cards) {
            dtoCards.add(cardMapper.toDto(card));
        }
        return dtoCards;
    }

    @Override
    @Transactional
    public List<CardDto> deleteCardsByUserId(Integer userId) {
        List<CardEntity> cardEntities = cardRepository.deleteCardEntitiesByUserId(userId);
        List<CardDto> dtoCards = new ArrayList<>();
        for (CardEntity card : cardEntities) {
            dtoCards.add(cardMapper.toDto(card));
        }
        return dtoCards;
    }

    @Override
    @Transactional
    public CardDto deleteCardById(Integer id) {
        CardEntity cardEntity = cardRepository.deleteCardEntityById(id);
        return cardMapper.toDto(cardEntity);
    }
}
