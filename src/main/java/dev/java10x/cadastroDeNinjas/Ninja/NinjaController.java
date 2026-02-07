package dev.java10x.cadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bemVindo")
public class NinjaController {

    @GetMapping("/positivo")
    public String boasVindas(){
        return "ola";
    }

    @GetMapping("/negativo")
    public String pessimasVindas(){
        return "Vai embora";
    }
}
