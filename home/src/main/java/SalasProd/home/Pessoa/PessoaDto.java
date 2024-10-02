package SalasProd.home.Pessoa;

import SalasProd.home.Interfaces.Classificacao;
import SalasProd.home.Pessoa.Pessoa;

public record PessoaDto(String nome, String email, Classificacao tipo) {
    public PessoaDto(Pessoa pessoa){
        this(pessoa.getNome(),pessoa.getEmail(),pessoa.getTipo());
    }
}
