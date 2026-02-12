package dev.java10x.cadastroDeNinjas.Missao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MissaoDTO {
    private Long id;
    private String nome;
    private String dificuldade;
}
