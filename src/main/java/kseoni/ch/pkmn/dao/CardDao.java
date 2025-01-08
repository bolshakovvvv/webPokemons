package kseoni.ch.pkmn.dao;

import kseoni.ch.pkmn.entities.CardEntity;
import kseoni.ch.pkmn.entities.StudentEntity;
import kseoni.ch.pkmn.repositories.CardEntityRepository;
import kseoni.ch.pkmn.repositories.StudentEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static kseoni.ch.pkmn.models.Student.fromEntity;

@Component
@RequiredArgsConstructor
public class CardDao {

    private final CardEntityRepository cardRepository;
    private final StudentEntityRepository studentEntityRepository;

    public CardEntity getCardById(UUID id) {
        return cardRepository.findById(id);
    }

    public List<CardEntity> getCardsByName(String name) {
        return cardRepository.findByName(name);
    }

    public CardEntity getCardByPokemonOwner_Id(UUID ownerId) {
        Optional<StudentEntity> optStudent = studentEntityRepository.findById(ownerId);
        StudentEntity student = optStudent.get();
        return cardRepository.findByPokemonOwner(student);
    }

    public Optional<CardEntity> getCardByNameAndNumber(String name, String number) {
        return cardRepository.findByNameAndNumber(name, number);
    }

    public CardEntity saveCard(CardEntity cardEntity) {
        return cardRepository.save(cardEntity);
    }

    public void deleteCardById(UUID id) {
        if (!cardRepository.existsById(id)) {
            throw new RuntimeException("Card with id " + id + " does not exist");
        }
        cardRepository.deleteCardById(id);
    }

    public List<CardEntity> getAllCards() {
        return cardRepository.findAll();
    }
}
