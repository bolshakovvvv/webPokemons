package kseoni.ch.pkmn.services;

import kseoni.ch.pkmn.models.Card;
import kseoni.ch.pkmn.models.Student;

import java.util.List;
import java.util.UUID;

public interface CardService {

    Card getCardById(UUID id);

    List<Card> getCardsByName(String name);

    Card getCardByOwnerId(UUID ownerId);

    Card saveCard(Card card);

    void deleteCardById(UUID id);

    public Card getCardByOwner(Student owner);

    List<Card> getAllCards();

}
