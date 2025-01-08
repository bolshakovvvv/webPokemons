package kseoni.ch.pkmn.repositories;

import kseoni.ch.pkmn.entities.CardEntity;

import kseoni.ch.pkmn.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardEntityRepository extends JpaRepository<CardEntity, Long> {

    List<CardEntity> findByName(String name);

    Optional<CardEntity> findByNameAndNumber(String name, String number);

    public void deleteCardById(UUID id);

    public boolean existsById(UUID id);

    public CardEntity findById(UUID id);

    CardEntity findByPokemonOwner(StudentEntity student);

}
