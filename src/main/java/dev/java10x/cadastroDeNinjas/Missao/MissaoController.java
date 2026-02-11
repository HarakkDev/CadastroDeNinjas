package dev.java10x.cadastroDeNinjas.Missao;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Missao> listar(){
        return this.missaoService.listar();
    }

    @GetMapping("/detalhes/{id}")
    public Missao detalhes(@PathVariable Long id){
        return this.missaoService.detalhes(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        this.missaoService.deletar(id);
    }

    @PostMapping("/criar")
    public Missao criar(@RequestBody Missao missao){
        return this.missaoService.criar(missao);
    }

    @PutMapping("/atualizar/{id}")
    public Missao atualizar(@PathVariable Long id, @RequestBody Missao missao){
        return this.missaoService.atualizar(id, missao);
    }
}
