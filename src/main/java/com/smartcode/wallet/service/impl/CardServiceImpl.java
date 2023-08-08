package com.smartcode.wallet.service.impl;

import com.smartcode.wallet.exceptions.DuplicationException;
import com.smartcode.wallet.exceptions.ResourceNotFoundException;
import com.smartcode.wallet.exceptions.ValidationException;
import com.smartcode.wallet.mapper.CardMapper;
import com.smartcode.wallet.model.CardDto;
import com.smartcode.wallet.model.CardEntity;
import com.smartcode.wallet.repository.CardRepository;
import com.smartcode.wallet.service.CardService;
import com.smartcode.wallet.util.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    @Transactional
    @Override
    public CardDto createCard(CardDto cardDto) {
        if (cardRepository.existsCardEntityByCardNumber(cardDto.getCardNumber())){
            throw new DuplicationException(Message.CARD_NOT_AVAILABLE);
        }
        CardEntity entity = cardMapper.toEntity(cardDto);
        CardEntity save = cardRepository.save(entity);
        return cardMapper.toDto(save);
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
        cardRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(Message.cardNotFound(id)));
        CardEntity cardEntity = cardRepository.deleteCardEntityById(id);
        return cardMapper.toDto(cardEntity);
    }
    @Override
    @Transactional(readOnly = true)
    public List<CardDto> getCardsByUserId(Integer userId) {
        List<CardEntity> cards = cardRepository.findAllByUserId(userId);
        List<CardDto> dtoCards = new ArrayList<>();
        for (CardEntity card : cards) {
            dtoCards.add(cardMapper.toDto(card));
        }
        return dtoCards;
    }
    @Override
    @Transactional(readOnly = true)
    public CardDto getCardById(Integer id) {
        CardEntity cardEntity = cardRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(Message.cardNotFound(id)));
        return cardMapper.toDto(cardEntity);
    }
}