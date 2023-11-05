package alura.memoteca.api.controller;

import alura.memoteca.api.pensamento.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/pensamentos")
public class PensamentoController {

    @Autowired
    private PensamentoRepository repository;

    @PostMapping
    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public void cadastrarPensamento (@RequestBody @Valid DadosCadastroPensamento pensamento) {
        repository.save(new Pensamento(pensamento));
    }

    @GetMapping("/{id}")
    public DadosListagemPensamentos buscarPorId (@PathVariable Long id) {
        var pensamento = repository.getReferenceById(id);
        return new DadosListagemPensamentos(pensamento);
    }

    @GetMapping
    public Page<DadosListagemPensamentos> listar (Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPensamentos::new);
    }

    //TODO retornar tipo Page, no momento retorna lista de pensamentos
    @GetMapping("/favoritos")
    public List<DadosListagemPensamentos> listarFavoritos(){
        return repository.findPensamentosByFavorito("true").stream().map(DadosListagemPensamentos::new).toList();
    }

    @PutMapping("/editar")
    @Transactional
    public void editar (@RequestBody @Valid DadosEditarPensamento dados) {
        var pensamento = repository.getReferenceById(dados.id());
        pensamento.atualizarDados(dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
