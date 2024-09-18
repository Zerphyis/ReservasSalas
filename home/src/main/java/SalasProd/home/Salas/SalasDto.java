package SalasProd.home.Salas;

import SalasProd.home.Interfaces.Classificacao;
import SalasProd.home.Pessoa.Pessoa;

import java.text.DateFormat;
import java.util.Date;

public record SalasDto (Pessoa pessoa, Date hora, Classificacao tipo){
    public SalasDto(Salas salas){
        this(salas.pessoa,salas.horas,salas.tipo);
    }
}
