package SalasProd.home.Controllers;


import SalasProd.home.Pessoa.Pessoa;
import SalasProd.home.Pessoa.PessoaDto;
import SalasProd.home.Repositorio.PessoaRepository;
import SalasProd.home.Salas.SalasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public ResponseEntity<List<Pessoa>> listarUsuarios() {
        List<Pessoa> pessoas = Repositorio.findAll();
        return ResponseEntity.ok(pessoas);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarDados(@PathVariable Long id, @RequestBody PessoaDto usuarioAtualizado) {
        if (!Repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        var usuarioExistente = Repositorio.getReferenceById(id);
        usuarioExistente.atualizar(usuarioAtualizado);
        Repositorio.save(usuarioExistente);
        return ResponseEntity.ok(usuarioExistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!Repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Repositorio.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
