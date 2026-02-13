package dev.java10x.cadastroDeNinjas.Ninja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @Autowired
    NinjaService ninjaService;

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listar(){
        return this.ninjaService.listar();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<String> buscar(@PathVariable Long id){
        return this.ninjaService.buscar(id);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody NinjaDTO ninja){
        return this.ninjaService.criar(ninja);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return this.ninjaService.atualizar(id, ninja);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        return this.ninjaService.deletar(id);
    }
}
