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
    public List<MissaoDTO> listar(){
        return this.missaoService.listar();
    }

    @GetMapping("/detalhes/{id}")
    public MissaoDTO detalhes(@PathVariable Long id){
        return this.missaoService.detalhes(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        this.missaoService.deletar(id);
    }

    @PostMapping("/criar")
    public MissaoDTO criar(@RequestBody MissaoDTO missao){
        return this.missaoService.criar(missao);
    }

    @PutMapping("/atualizar/{id}")
    public MissaoDTO atualizar(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        return this.missaoService.atualizar(id, missaoDTO);
    }
}
