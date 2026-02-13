package dev.java10x.cadastroDeNinjas.Missao;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Lista as missões", description = "Teste")
    @GetMapping("/listar")
    public ResponseEntity<List<MissaoDTO>> listar(){
        return this.missaoService.listar();
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<String> detalhes(@PathVariable Long id){
        return this.missaoService.detalhes(id);
    }

    @PostMapping("/criar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da missão!")
    })
    public ResponseEntity<String> criar(@RequestBody MissaoDTO missao){
        return this.missaoService.criar(missao);
    }

    @PutMapping("/atualizar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID não encontrado")
    })
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        return this.missaoService.atualizar(id, missaoDTO);
    }


    @DeleteMapping("/deletar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID não encontrado")
    })
    public ResponseEntity<String> deletar(@PathVariable Long id){
        return this.missaoService.deletar(id);
    }
}
