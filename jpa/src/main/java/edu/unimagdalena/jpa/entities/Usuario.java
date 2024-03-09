package edu.unimagdalena.jpa.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String repPassword;

    @Column(nullable = false)
    private Boolean enable;

    @Column(nullable = true)
    private String foto;

    @Column(nullable = false)
    private String rol;

    @Temporal(TemporalType.DATE)
    private LocalDate createAt;

    @ManyToMany(mappedBy = "participantes")
    private List<Partida> partidas;

    @OneToMany(mappedBy = "usuario")
    private List<Sugerencia> sugerencias;

    @OneToMany(mappedBy = "usuario")
    private List<Sugerencia> mensajes;

}
