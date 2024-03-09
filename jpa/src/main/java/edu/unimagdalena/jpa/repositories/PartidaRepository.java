package edu.unimagdalena.jpa.repositories;


import edu.unimagdalena.jpa.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
