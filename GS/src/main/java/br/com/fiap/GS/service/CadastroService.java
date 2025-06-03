package br.com.fiap.GS.service;

import br.com.fiap.GS.model.Cadastro;
import br.com.fiap.GS.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;

    public List<Cadastro> listarTodos() {
        return cadastroRepository.findAll();
    }

    public Optional<Cadastro> buscarPorId(Long id) {
        return cadastroRepository.findById(id);
    }

    public Cadastro salvar(Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    public void deletar(Long id) {
        cadastroRepository.deleteById(id);
    }
}
