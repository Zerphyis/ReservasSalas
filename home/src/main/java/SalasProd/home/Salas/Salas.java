package SalasProd.home.Salas;

import SalasProd.home.Interfaces.Classificacao;

import SalasProd.home.Pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="sala")
public class Salas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @ManyToOne // Mapeando o relacionamento ManyToOne
    @JoinColumn(name = "pessoa_id") // Definindo a coluna de junção
    private Pessoa pessoa;

    private LocalDateTime horaInicio;
    private LocalDateTime horaFim;

    @Enumerated(EnumType.STRING)
    private Classificacao tipo;

    public Salas(SalasDto salas) {
        this.horaInicio = salas.inicio();
        this.tipo = salas.tipo();
        this.pessoa = salas.pessoa();
    }

    public int calcularDuracaoReserva() {
        Duration duracao = Duration.between(horaInicio, horaFim);
        return (int) duracao.toHours();
    }

    public void verificarReservaEmail(SalaService service) {
        LocalDateTime now = LocalDateTime.now();
        if (this.horaFim.isBefore(now)) {
            String tipoReserva = tipo == Classificacao.EXECUTIVA ? "EXECUTIVA" : "COMUM";
            service.enviarEmail(pessoa.getEmail(), tipoReserva);
        }
    }

    public void confirmarReserva(SalaService service) {
        String nomeReservista = this.pessoa.getNome();
        int horasReservadas = calcularDuracaoReserva();
        service.enviarEmailConfirmacao(this.pessoa.getEmail(), nomeReservista, horasReservadas);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalDateTime horaFim) {
        this.horaFim = horaFim;
    }

    public Classificacao getTipo() {
        return tipo;
    }

    public void setTipo(Classificacao tipo) {
        this.tipo = tipo;
    }
}