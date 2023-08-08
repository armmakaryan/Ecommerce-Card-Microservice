package com.smartcode.wallet.repository;

import com.smartcode.wallet.model.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Integer> {
    List<CardEntity> findAllByUserId(Integer userId);
    List<CardEntity> deleteCardEntitiesByUserId(Integer userId);
    CardEntity deleteCardEntityById(Integer id);
    CardEntity findByUserId(Integer userId);

    boolean existsCardEntityByCardNumber(String cardNumber);
}