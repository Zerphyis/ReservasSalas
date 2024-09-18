package SalasProd.home.Pessoa;

import SalasProd.home.Interfaces.Classificacao;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    public Long id;
    @Column(unique = true)
    public String email;
    public String nome;
    @Enumerated(EnumType.STRING)
    public Classificacao tipo;

    public Pessoa(PessoaDto person){
        this.nome=person.nome();
        this.email= person.email();
        this.tipo=person.tipo();
    }



}

