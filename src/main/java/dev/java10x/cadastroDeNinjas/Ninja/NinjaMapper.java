package dev.java10x.cadastroDeNinjas.Ninja;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public Ninja map(NinjaDTO ninjaDTO){
        Ninja ninja = new Ninja();
        ninja.setId(ninjaDTO.getId());
        ninja.setNome(ninjaDTO.getNome());
        ninja.setEmail(ninjaDTO.getEmail());
        ninja.setIdade(ninjaDTO.getIdade());
        ninja.setMissao(ninjaDTO.getMissao());
        ninja.setImgUrl(ninjaDTO.getImgUrl());
        ninja.setRank(ninjaDTO.getRank());
        return ninja;
    }

    public NinjaDTO map(Ninja ninja){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninja.getId());
        ninjaDTO.setNome(ninja.getNome());
        ninjaDTO.setEmail(ninja.getEmail());
        ninjaDTO.setIdade(ninja.getIdade());
        ninjaDTO.setMissao(ninja.getMissao());
        ninjaDTO.setImgUrl(ninja.getImgUrl());
        ninjaDTO.setRank(ninja.getRank());
        return ninjaDTO;
    }
}
