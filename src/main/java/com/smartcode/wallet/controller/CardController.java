package com.smartcode.wallet.controller;

import com.smartcode.wallet.model.CardDto;
import com.smartcode.wallet.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;
    @PostMapping
    public ResponseEntity<String> createCard(@RequestBody CardDto cardDto){

        var card = cardService.createCard(cardDto);
        return ResponseEntity.ok("Card creation in progress ");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CardDto>> getCardsByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(cardService.getCardByUserId(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<List<CardDto>> deleteCardsByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(cardService.deleteCardsByUserId(userId));
    }

    @DeleteMapping
    public ResponseEntity<CardDto> deleteCardByUserId(@RequestParam Integer Id){
        return ResponseEntity.ok(cardService.deleteCardById(Id));
    }
}
