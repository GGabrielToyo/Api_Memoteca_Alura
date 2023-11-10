package alura.memoteca.api.pensamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PensamentoRepository extends JpaRepository<Pensamento, Long> {

    Page<Pensamento> findAllByFavoritoTrue(Pageable paginacao);
}
