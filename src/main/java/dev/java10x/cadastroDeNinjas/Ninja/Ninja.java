package dev.java10x.cadastroDeNinjas.Ninja;

import dev.java10x.cadastroDeNinjas.Missao.Missao;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ninja")
public class Ninja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String imgUrl;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "missaoId")
    private Missao missao;

    private String rank;
}
