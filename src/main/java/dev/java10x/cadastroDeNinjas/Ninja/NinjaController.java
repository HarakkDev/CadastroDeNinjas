package dev.java10x.cadastroDeNinjas.Ninja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @Autowired
    NinjaService ninjaService;

    @GetMapping("/listar")
    public List<NinjaDTO> listar(){
       return this.ninjaService.listar();
    }

    @GetMapping("/buscar/{id}")
    public NinjaDTO buscar(@PathVariable Long id){
        return this.ninjaService.buscar(id);
    }

    @PostMapping("/criar")
    public NinjaDTO criar(@RequestBody NinjaDTO ninja){
        return this.ninjaService.criar(ninja);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        this.ninjaService.deletar(id);
    }

    @PutMapping("/atualizar/{id}")
    public NinjaDTO atualizar(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return this.ninjaService.atualizar(id, ninja);
    }
}
