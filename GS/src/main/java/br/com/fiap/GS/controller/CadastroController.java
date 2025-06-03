package br.com.fiap.GS.controller;

import br.com.fiap.GS.model.Cadastro;
import br.com.fiap.GS.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @GetMapping
    public List<Cadastro> listarTodos() {
        return cadastroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cadastro> buscarPorId(@PathVariable Long id) {
        return cadastroService.buscarPorId(id);
    }

    @PostMapping
    public Cadastro criar(@RequestBody Cadastro cadastro) {
        return cadastroService.salvar(cadastro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        cadastroService.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cadastro> atualizar(@PathVariable Long id, @RequestBody Cadastro cadastroAtualizado) {
        Optional<Cadastro> cadastroExistente = cadastroService.buscarPorId(id);

        if (cadastroExistente.isPresent()) {
            Cadastro cadastro = cadastroExistente.get();
            cadastro.setCidadeNome(cadastroAtualizado.getCidadeNome());
            cadastro.setNumeroHabitantes(cadastroAtualizado.getNumeroHabitantes());

            Cadastro cadastroSalvo = cadastroService.salvar(cadastro);
            return ResponseEntity.ok(cadastroSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}