package com.smartcode.wallet.mapper;

import com.smartcode.wallet.model.CardDto;
import com.smartcode.wallet.model.CardEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardEntity toEntity(CardDto cardDto);
    CardDto toDto(CardEntity cardEntity);
}
