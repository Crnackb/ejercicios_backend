package edu.unimagdalena.jpa.repositories;


import edu.unimagdalena.jpa.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
    
}
