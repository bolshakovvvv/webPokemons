package kseoni.ch.pkmn.controllers;

import kseoni.ch.pkmn.models.Card;
import kseoni.ch.pkmn.models.Student;
import kseoni.ch.pkmn.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Card>> getCardByName(@PathVariable String name) {
        return ResponseEntity.ok(cardService.getCardsByName(name));
    }

    @GetMapping("/owner")
    public ResponseEntity<Card> getCardsByOwner(@RequestBody Student owner) {
        return ResponseEntity.ok(cardService.getCardByOwner(owner));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable UUID id) {
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @PostMapping
    public ResponseEntity<Card> saveCard(@RequestBody Card card) {
        return ResponseEntity.ok(cardService.saveCard(card));
    }
}
