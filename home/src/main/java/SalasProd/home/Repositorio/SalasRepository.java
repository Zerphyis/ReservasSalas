package SalasProd.home.Repositorio;

import SalasProd.home.Salas.Salas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalasRepository extends JpaRepository<Salas,Long> {
}
