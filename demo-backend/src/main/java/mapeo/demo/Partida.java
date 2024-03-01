package mapeo.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Partidas")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartida;
    private String creador;
    private String deporte;
    private String ciudad;
    private String provincia;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    @Temporal(TemporalType.TIME)
    private LocalTime horaComienzo;
    @Temporal(TemporalType.TIME)
    private LocalTime horaFinal;
    @ManyToMany
    @JoinTable(
            name = "usuariosPorPartidas",
            joinColumns = @JoinColumn(name = "idPartida"),
            inverseJoinColumns = @JoinColumn(name = "idUsuario")
    )
    private List<Usuario> participantes;

    @ManyToMany
    @JoinTable(
            name = "suplentesPorPartidas",
            joinColumns = @JoinColumn(name = "idPartida"),
            inverseJoinColumns = @JoinColumn(name = "idUsuario")
    )
    private List<Usuario> suplentes;
    private String comentarios;

    public Partida() {
    }

    public Long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraComienzo() {
        return horaComienzo;
    }

    public void setHoraComienzo(LocalTime horaComienzo) {
        this.horaComienzo = horaComienzo;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

    public List<Usuario> getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(List<Usuario> suplentes) {
        this.suplentes = suplentes;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
