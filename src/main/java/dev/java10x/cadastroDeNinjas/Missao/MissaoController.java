package dev.java10x.cadastroDeNinjas.Missao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/missao")
public class MissaoController {

    @Autowired
    MissaoService missaoService;

    @GetMapping("/listar")
    public ResponseEntity<List<MissaoDTO>> listar(){
        return this.missaoService.listar();
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<String> detalhes(@PathVariable Long id){
        return this.missaoService.detalhes(id);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody MissaoDTO missao){
        return this.missaoService.criar(missao);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        return this.missaoService.atualizar(id, missaoDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        return this.missaoService.deletar(id);
    }
}
