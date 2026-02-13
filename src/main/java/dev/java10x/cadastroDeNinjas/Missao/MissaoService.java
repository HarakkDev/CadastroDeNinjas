package dev.java10x.cadastroDeNinjas.Missao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    @Autowired
    MissaoRepository missaoRepository;

    @Autowired
    MissaoMapper missaoMapper;

    public ResponseEntity<List<MissaoDTO>> listar() {
        List<Missao> missoes = missaoRepository.findAll();
        return ResponseEntity.ok(missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList()));
    }

    public ResponseEntity<String> detalhes(Long id) {
        if(!missaoRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrada com o ID: " + id);
        }
        Optional<Missao> missao = this.missaoRepository.findById(id);
        return ResponseEntity.ok("Nome da missão: " + Objects.requireNonNull(missao.map(missaoMapper::map).orElse(null)).getNome());
    }

    public ResponseEntity<String> criar(MissaoDTO missaoDTO) {
        Missao missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);
        missaoMapper.map(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missão criada com sucesso!");
    }

    public ResponseEntity<String> atualizar(Long id, MissaoDTO missaoDTO) {
        Optional<Missao> missao = missaoRepository.findById(id);
        if (missao.isPresent()){
            Missao missaoAtt = missaoMapper.map(missaoDTO);
            missaoAtt.setId(id);
            Missao missaoSalvar = this.missaoRepository.save(missaoAtt);
            missaoMapper.map(missaoSalvar);
            return ResponseEntity.ok("Missão atualizada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrada com o ID: " + id);
    }

    public ResponseEntity<String> deletar(Long id) {
        if (missaoRepository.existsById(id)){
            missaoRepository.deleteById(id);
            return ResponseEntity.ok("Missão deletada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com o id " + id + " não encontrado!");
    }
}
