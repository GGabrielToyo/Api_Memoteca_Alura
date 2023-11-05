package alura.memoteca.api.pensamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PensamentoRepository extends JpaRepository<Pensamento, Long> {
    List<Pensamento> findPensamentosByFavorito(String favorito);

}
