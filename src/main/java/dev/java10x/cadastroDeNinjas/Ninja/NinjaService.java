package dev.java10x.cadastroDeNinjas.Ninja;

import dev.java10x.cadastroDeNinjas.Missao.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;
    @Autowired
    private MissaoRepository missaoRepository;

    public List<Ninja> listar(){
        return ninjaRepository.findAll();
    }

    public Ninja buscar(Long id){
        if(!ninjaRepository.existsById(id)){
            throw new RuntimeException("Ninja com o ID '" + id + "' não encontrado");
        }
        return ninjaRepository.findById(id)
                .orElse(null);
    }

    public Ninja criar(Ninja ninja) {
        Long missaoId = ninja.getMissao().getId();
        if(!missaoRepository.existsById(missaoId)){
            throw new RuntimeException("Missão com o ID '" + missaoId + "' não encontrada");
        }
        return ninjaRepository.save(ninja);
    }

    public void deletar(Long id) {
        if(!ninjaRepository.existsById(id)){
            throw new RuntimeException("Ninja com o ID '" + id + "' não encontrado");
        }
        ninjaRepository.deleteById(id);
    }

    public Ninja atualizar(Long id, Ninja ninja) {
        if (ninjaRepository.existsById(id)){
            return ninjaRepository.save(ninja);
        } else
            return null;
    }
}
