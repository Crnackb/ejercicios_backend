package edu.unimagdalena.jpa.repositories;

import edu.unimagdalena.jpa.AbstractIntegrationDBTest;
import edu.unimagdalena.jpa.entities.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class UsuarioRepositoryTest extends AbstractIntegrationDBTest {

    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioRepositoryTest(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAll();
    }

    void initUsuarios(){
        Usuario usuario = Usuario.builder()
                .email("jv@unimgdalena.edu.co")
                .nombre("Jonathan")
                .apellidos("Vega")
                .edad(23)
                .password("12345")
                .repPassword("12345")
                .rol("Estudiante")
                .build();
        usuarioRepository.save(usuario);

        Usuario usuario2 = Usuario.builder()
                .email("js@unimgdalena.edu.co")
                .nombre("Javier")
                .apellidos("Santodomingo")
                .edad(19)
                .password("1234")
                .repPassword("1234")
                .rol("Estudiante")
                .build();
        usuarioRepository.save(usuario2);

        usuarioRepository.flush();
    }
   
    @Test
    void givenAnUser_whenSave_thenUserwithId(){
        // Given
        Usuario usuario = Usuario.builder()
                .email("jv@unimgdalena.edu.co")
                .nombre("Jonathan")
                .apellidos("Vega")
                .edad(23)
                .password("12345")
                .repPassword("12345")
                .rol("Estudiante")
                .build();

        // When
        Usuario userSaved = usuarioRepository.save(usuario);

        // Then
        assertThat(userSaved.getIdUsuario()).isNotNull();
    }

    @Test
    @DisplayName("dado un conjunto de usuarios al buscarlo todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllUsers(){
        //GIVEN
        Usuario usuario = Usuario.builder()
                .nombre("Julian")
                .apellidos("Pizarro")
                .nombre("julianpizarro")
                .password("123")
                .build();
        usuarioRepository.save(usuario);

        Usuario usuario2 = Usuario.builder().nombre("Jose")
                .apellidos("Pertuz")
                .nombre("josepertuz")
                .password("123")
                .build();
        usuarioRepository.save(usuario2);
        usuarioRepository.flush();
        //WHEN
        List<Usuario> usuarios = usuarioRepository.findAll();

        //THEN
        assertThat(usuarios).hasSize(2);
    }
    @Test
    void givenUsuarios_whenBuscarPorNombreyApellido_thenObtienesUnaListaDeUsuarios(){
        Usuario usuario = Usuario.builder()
                .email("js@unimgdalena.edu.co")
                .nombre("Javier")
                .apellidos("Santodomingo")
                .edad(19)
                .password("1234")
                .repPassword("1234")
                .rol("Estudiante")
                .build();
        usuarioRepository.save(usuario);
        Usuario usuario2 = Usuario.builder()
                .email("jv@unimgdalena.edu.co")
                .nombre("Jonathan")
                .apellidos("Vega")
                .edad(23)
                .password("12345")
                .repPassword("12345")
                .rol("Estudiante")
                .build();
        usuarioRepository.save(usuario);

        List<Usuario> usuarios = usuarioRepository.findByNombreAndApellidos("Javier", "Santodomingo");

        assertThat(usuarios).isNotEmpty();
        assertThat(usuarios).first().hasFieldOrPropertyWithValue("nombre","Julian");
    }
}