package baseAPI.API.Sistema.Repository;

import baseAPI.API.Sistema.Model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Cursos, Long> {
}
