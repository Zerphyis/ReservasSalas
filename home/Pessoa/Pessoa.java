package SalasProd.home.Pessoa;

import SalasProd.home.Interfaces.Classificacao;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@EqualsAndHashCode(of = "id")
@Entity
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

    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Classificacao getTipo() {
        return tipo;
    }

    public void setTipo(Classificacao tipo) {
        this.tipo = tipo;
    }
}

