package edu.unimagdalena.jpa.repositories;

import edu.unimagdalena.jpa.entities.Mensaje;
import edu.unimagdalena.jpa.AbstractIntegrationDBTest;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;

public class MensajeRepositoryTest extends AbstractIntegrationDBTest {
    MensajeRepository mensajeRepository;

    @Autowired
    public MensajeRepositoryTest(MensajeRepository mensajeRepository){
        this.mensajeRepository = mensajeRepository;
    }


    void initMockMensaje() {
        Mensaje mensaje = Mensaje.builder()
                .creador("Javier")
                .destinatario("Jonathan")
                .contenido("Hola!")
                .createdAt(LocalDateTime.now())
                .build();
        mensajeRepository.save(mensaje);

        Mensaje mensaje2 = Mensaje.builder()
                .creador("Javier")
                .destinatario("Jonathan")
                .contenido("Hola!!")
                .createdAt(LocalDateTime.now())
                .build();
        mensajeRepository.save(mensaje2);
        mensajeRepository.flush();
    }

    @BeforeEach
    void setUp() {
        mensajeRepository.deleteAll();
    }

    @Test
    @DisplayName("Comprueba que el usuario guardado efectivamente tenga un ID asignado")
    public void givenAnMessage_whenSave_thenMessgewithId(){
        // Given
        Mensaje mensaje = Mensaje.builder()
                .creador("Javier2")
                .destinatario("Jonathan2")
                .contenido("rrrrrrrrrrrr2")
                .createdAt(LocalDateTime.now().minusWeeks(2))
                .build();
        // When
        Mensaje mensajeSaved = mensajeRepository.save(mensaje);
        // Then
        assertThat(mensajeSaved.getId()).isNotNull();
    }

    @AfterEach
    void tearDown() {
    }
}