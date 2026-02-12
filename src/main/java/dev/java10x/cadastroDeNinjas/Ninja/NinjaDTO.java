package dev.java10x.cadastroDeNinjas.Ninja;

import dev.java10x.cadastroDeNinjas.Missao.Missao;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private  String rank;
    private Missao missao;
}
