package com.smartcode.wallet.controller;

import com.smartcode.wallet.model.CardDto;
import com.smartcode.wallet.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardDto> createCard(@RequestBody CardDto cardDto){
        return ResponseEntity.ok(cardService.createCard(cardDto));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<CardDto>> getCardsByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(cardService.getCardsByUserId(userId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CardDto> getCardById(@PathVariable Integer id){
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<List<CardDto>> deleteCardsByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(cardService.deleteCardsByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardDto> deleteCardById(@PathVariable Integer id){
        return ResponseEntity.ok(cardService.deleteCardById(id));
    }
}