package kseoni.ch.pkmn.repositories;

import kseoni.ch.pkmn.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, UUID> {

    List<StudentEntity> findAll();

    List<StudentEntity> findByGroup(String group);

    List<StudentEntity> findByFirstNameAndSurNameAndFamilyName(String firstName, String surName, String familyName);

    List<StudentEntity> findByFirstNameAndSurNameAndFamilyNameAndGroup(
            String firstName, String surName, String familyName, String group);

    public void deleteCardById(UUID id);

    public boolean existsById(UUID id);

    public Optional<StudentEntity> findById(UUID id);
}
