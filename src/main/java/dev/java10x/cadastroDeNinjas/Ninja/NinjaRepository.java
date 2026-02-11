package dev.java10x.cadastroDeNinjas.Ninja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<Ninja, Long> {
    Ninja getReferenceByNome(String Nome);

    boolean getReferenceByIdade(int idade);
}
