package dev.java10x.cadastroDeNinjas.Missao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    @Autowired
    MissaoRepository missaoRepository;

    public List<Missao> listar() {
        return this.missaoRepository.findAll();
    }

    public Missao detalhes(Long id) {
        return this.missaoRepository.findById(id)
                .orElse(null);
    }

    public void deletar(Long id) {
        this.missaoRepository.deleteById(id);
    }

    public Missao criar(Missao missao) {
        return this.missaoRepository.save(missao);
    }

    public Missao atualizar(Long id, Missao missao) {
        if (!this.missaoRepository.existsById(id)){
            throw new RuntimeException("ID não existe");
        }
        missao.setId(id);
        return this.missaoRepository.save(missao);
    }
}
