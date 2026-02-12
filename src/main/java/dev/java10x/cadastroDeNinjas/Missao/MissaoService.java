package dev.java10x.cadastroDeNinjas.Missao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    @Autowired
    MissaoRepository missaoRepository;

    @Autowired
    MissaoMapper missaoMapper;

    public List<MissaoDTO> listar() {
        List<Missao> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    public MissaoDTO detalhes(Long id) {
        Optional<Missao> missao = missaoRepository.findById(id);
        return missao.map(missaoMapper::map).orElse(null);
    }

    public void deletar(Long id) {
        this.missaoRepository.deleteById(id);
    }

    public MissaoDTO criar(MissaoDTO missaoDTO) {
        Missao missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    public MissaoDTO atualizar(Long id, MissaoDTO missaoDTO) {
        Optional<Missao> missao = missaoRepository.findById(id);
        if (missao.isPresent()){
            Missao missaoAtt = missaoMapper.map(missaoDTO);
            missaoAtt.setId(id);
            Missao missaoSalvar = this.missaoRepository.save(missaoAtt);
            return missaoMapper.map(missaoSalvar);
        }
        return null;
    }
}
