package edu.unimagdalena.jpa.repositories;

import edu.unimagdalena.jpa.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombreAndApellidos(String nombre, String apellido);
}
