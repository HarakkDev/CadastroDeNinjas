package dev.java10x.cadastroDeNinjas.Ninja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

    @Autowired
    NinjaMapper ninjaMapper;

    public ResponseEntity<List<NinjaDTO>> listar(){
        List<Ninja> ninjas = ninjaRepository.findAll();
        return ResponseEntity.ok(ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList())) ;
    }

    public ResponseEntity<String> buscar(Long id){
        if(!ninjaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID " + id + " não encontrado!");
        }
        Optional<Ninja> ninja = ninjaRepository.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body("Ninja encontrado: " + Objects.requireNonNull(ninja.map(ninjaMapper::map).orElse(null)).getNome());
    }

    public ResponseEntity<String> criar(NinjaDTO ninjaDTO) {
        Ninja ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        ninjaMapper.map(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso! Nome do ninja: " + ninja.getNome() + ". ID do Ninja: " + ninja.getId());
    }

    public ResponseEntity<String> atualizar(Long id, NinjaDTO ninjaDTO) {
        Optional<Ninja> ninja = ninjaRepository.findById(id);
        if(ninja.isPresent()){
            Ninja ninjaAtt = ninjaMapper.map(ninjaDTO);
            ninjaAtt.setId(id);
            Ninja ninjaSalvo = ninjaRepository.save(ninjaAtt);
            ninjaMapper.map(ninjaSalvo);
            return ResponseEntity.ok("Ninja atualizado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID '" + ninjaDTO.getId() + "' não encontrado");
    }

    public ResponseEntity<String> deletar(Long id) {
        if(!ninjaRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID '" + id + "' não encontrado!");
        }
        ninjaRepository.deleteById(id);
        return ResponseEntity.ok("Ninja com o ID '" + id + "' foi deletado com sucesso!");
    }
}
