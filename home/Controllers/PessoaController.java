package SalasProd.home.Controllers;


import SalasProd.home.Pessoa.Pessoa;
import SalasProd.home.Pessoa.PessoaDto;
import SalasProd.home.Repositorio.PessoaRepository;
import SalasProd.home.Salas.SalasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PessoaController {
    @Autowired
    PessoaRepository Repositorio;


@PostMapping
public ResponseEntity<Pessoa> criarUsuario(@RequestBody PessoaDto usuario){
    Pessoa novoUsuario= new Pessoa(usuario);
        Repositorio.save(novoUsuario);

        return ResponseEntity.ok(novoUsuario);
    }
}
