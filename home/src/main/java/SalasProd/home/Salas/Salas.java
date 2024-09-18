package SalasProd.home.Salas;

import SalasProd.home.Interfaces.Classificacao;

import SalasProd.home.Pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Salas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    public Long id;
    public Pessoa pessoa;

    public Date horas;

 @Enumerated(EnumType.STRING)
    public Classificacao tipo;

 public Salas(SalasDto salas){
     this.horas=salas.hora();
     this.tipo=salas.tipo();
     this.pessoa=salas.pessoa();

 }
 public void verificarReservaEmail(SalaService service){
     Date now= new Date();
     if(this.horas.before(now)){
         String tipoReserva=tipo == Classificacao.EXECUTIVA? "EXECUTIVA":"COMUN";
         service.enviarEmail(pessoa.email,tipoReserva);
     }

 }
}
