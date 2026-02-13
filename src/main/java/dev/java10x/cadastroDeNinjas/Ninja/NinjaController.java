package dev.java10x.cadastroDeNinjas.Ninja;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "302", description = "Ninja encontrado"),
            @ApiResponse(responseCode = "401", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> buscar(@PathVariable Long id){
        return this.ninjaService.buscar(id);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody NinjaDTO ninja){
        return this.ninjaService.criar(ninja);
    }

    @PutMapping("/atualizar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrado para atualizar")
    })
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return this.ninjaService.atualizar(id, ninja);
    }

    @DeleteMapping("/deletar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrado para deletar")
    })
    public ResponseEntity<String> deletar(@PathVariable Long id){
        return this.ninjaService.deletar(id);
    }
}
