package dev.java10x.cadastroDeNinjas.Missao;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {
    public Missao map(MissaoDTO missaoDTO){
        Missao missao = new Missao();
        missao.setId(missaoDTO.getId());
        missao.setNome(missaoDTO.getNome());
        missao.setDificuldade(missaoDTO.getDificuldade());
        return missao;
    }

    public MissaoDTO map(Missao missao){
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missao.getId());
        missaoDTO.setNome(missao.getNome());
        missaoDTO.setDificuldade(missao.getDificuldade());
        return missaoDTO;
    }
}
