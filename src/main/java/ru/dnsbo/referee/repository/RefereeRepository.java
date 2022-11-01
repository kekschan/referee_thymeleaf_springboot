package ru.dnsbo.referee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dnsbo.referee.models.Referee;

import java.util.List;
import java.util.Optional;

public interface RefereeRepository extends JpaRepository<Referee, Long> {

    List<Referee> findAllByFirstName(String firstName);

    @Override
    List<Referee> findAll();

    Optional<Referee> findById(Long id);

}
