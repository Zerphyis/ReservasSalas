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
@Entity

public class Salas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    public Long id;
    public Pessoa pessoa;

    public LocalDateTime horaInicio;
    public LocalDateTime horaFim;

    @Enumerated(EnumType.STRING)
    public Classificacao tipo;

 public Salas(SalasDto salas){
     this.horaInicio = salas.inicio();
     this.tipo=salas.tipo();
     this.pessoa=salas.pessoa();

 }
    public int calcularDuracaoReserva() {
        Duration duracao = Duration.between(horaInicio, horaFim);
        return (int) duracao.toHours();
    }
 public void verificarReservaEmail(SalaService service) {
     LocalDateTime now = LocalDateTime.now();
     if (this.horaFim.isBefore(now)) {
         String tipoReserva = tipo == Classificacao.EXECUTIVA ? "EXECUTIVA" : "COMUN";
         service.enviarEmail(pessoa.email, tipoReserva);
     }
 }
     public void confirmarReserva(SalaService service) {
         String nomeReservista = this.pessoa.getNome();
         int horasReservadas = calcularDuracaoReserva();
         service.enviarEmailConfirmacao(this.pessoa.getEmail(), nomeReservista, horasReservadas);
     }


}
