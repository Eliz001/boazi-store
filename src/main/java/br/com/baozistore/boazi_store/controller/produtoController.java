
package br.com.baozistore.boazi_store.controller;

import br.com.baozistore.boazi_store.model.produto;
import br.com.baozistore.boazi_store.repository.produtoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class produtoController {

    private final produtoRepository produtoRepository;

    public produtoController(produtoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public produto criar(@RequestBody produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping
    public List<produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<produto> buscar(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
