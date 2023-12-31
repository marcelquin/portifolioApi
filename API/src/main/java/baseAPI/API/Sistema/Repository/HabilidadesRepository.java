package baseAPI.API.Sistema.Repository;

import baseAPI.API.Sistema.Model.Habilidades;
import baseAPI.API.Sistema.Model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Long> {
}
