package SalasProd.home.Salas;

import SalasProd.home.Interfaces.Classificacao;
import SalasProd.home.Pessoa.Pessoa;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public record SalasDto (Pessoa pessoa, LocalDateTime inicio,LocalDateTime fim, Classificacao tipo){
    public SalasDto(Salas salas){
        this(salas.pessoa,salas.horaInicio,salas.horaFim,salas.tipo);
    }
}
