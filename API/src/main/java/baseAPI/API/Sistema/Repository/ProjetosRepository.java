package baseAPI.API.Sistema.Repository;

import baseAPI.API.Sistema.Model.Projetos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetosRepository extends JpaRepository<Projetos, Long> {
}
