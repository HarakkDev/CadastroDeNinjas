package dev.java10x.cadastroDeNinjas.Ninja;

import dev.java10x.cadastroDeNinjas.Missao.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

    @Autowired
    private MissaoRepository missaoRepository;

    @Autowired
    NinjaMapper ninjaMapper;

    public List<NinjaDTO> listar(){
        List<Ninja> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO buscar(Long id){
        if(!ninjaRepository.existsById(id)){
            throw new RuntimeException("Ninja com o ID '" + id + "' não encontrado");
        }
        Optional<Ninja> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO criar(NinjaDTO ninjaDTO) {
        Ninja ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deletar(Long id) {
        if(!ninjaRepository.existsById(id)){
            throw new RuntimeException("Ninja com o ID '" + id + "' não encontrado");
        }
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizar(Long id, NinjaDTO ninjaDTO) {
        Optional<Ninja> ninja = ninjaRepository.findById(id);
        if(ninja.isPresent()){
            Ninja ninjaAtt = ninjaMapper.map(ninjaDTO);
            ninjaAtt.setId(id);
            Ninja ninjaSalvo = ninjaRepository.save(ninjaAtt);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
